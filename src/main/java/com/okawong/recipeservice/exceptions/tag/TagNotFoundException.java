package com.okawong.recipeservice.exceptions.tag;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class TagNotFoundException extends ResponseStatusException {
    public TagNotFoundException(UUID id) {
        super(HttpStatus.BAD_REQUEST, "TAG_NOT_FOUND");
    }
}
