package com.okawong.recipeservice.models.requests.v1;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class PostTagRequest {

    @NotBlank
    private String name;

    public PostTagRequest() {}

    public PostTagRequest(String name) {
        this.name = name;
    }
}
