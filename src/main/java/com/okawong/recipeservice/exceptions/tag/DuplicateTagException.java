package com.okawong.recipeservice.exceptions.tag;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DuplicateTagException extends ResponseStatusException {
    public DuplicateTagException() {
       super(HttpStatus.BAD_REQUEST, "TAG_ALREADY_EXISTS");
    }
}
