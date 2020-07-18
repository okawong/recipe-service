package com.okawong.recipeservice.controllers;

import com.okawong.recipeservice.exceptions.tag.TagNotFoundException;
import com.okawong.recipeservice.exceptions.tag.DuplicateTagException;
import com.okawong.recipeservice.models.Tag;
import com.okawong.recipeservice.models.requests.v1.PostTagRequest;
import com.okawong.recipeservice.models.responses.v1.TagResponse;
import com.okawong.recipeservice.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public List<TagResponse> getAllTags() {
        return tagRepository.findAll()
                .stream()
                .map(TagResponse::fromTag)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public TagResponse getTagById(@PathVariable UUID id) {
        final Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new TagNotFoundException(id));
        return TagResponse.fromTag(tag);
    }

    @PostMapping
    public TagResponse createTag(@Valid @RequestBody PostTagRequest postTagRequest) {
        final Tag tag = new Tag(postTagRequest.getName());
        try {
            return TagResponse.fromTag(tagRepository.save(tag));
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateTagException();
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTag(@PathVariable UUID id) {
        try {
            tagRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e) {
            throw new TagNotFoundException(id);
        }
    }
}
