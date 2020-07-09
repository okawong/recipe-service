package com.okawong.recipeservice.controllers;

import com.okawong.recipeservice.models.Tag;
import com.okawong.recipeservice.models.requests.v1.PostTagRequest;
import com.okawong.recipeservice.models.responses.v1.TagResponse;
import com.okawong.recipeservice.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping(value = "/tags", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TagResponse> getAllTags() {
        return tagRepository.findAll()
                .stream()
                .map(TagResponse::fromTag)
                .collect(Collectors.toList());
    }

    @PostMapping("/tags")
    public TagResponse createTag(@Valid @RequestBody PostTagRequest postTagRequest) {
        final Tag tag = new Tag(postTagRequest.getName());
        return TagResponse.fromTag(tagRepository.save(tag));
    }
}
