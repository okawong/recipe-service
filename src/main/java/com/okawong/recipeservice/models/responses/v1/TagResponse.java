package com.okawong.recipeservice.models.responses.v1;

import com.okawong.recipeservice.models.Tag;

import java.util.UUID;

public class TagResponse {
    public final UUID id;
    public final String name;

    private TagResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TagResponse fromTag(Tag tag) {
        return new TagResponse(tag.getId(), tag.getName());
    }
}
