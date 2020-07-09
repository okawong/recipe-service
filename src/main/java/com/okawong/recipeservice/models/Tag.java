package com.okawong.recipeservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
public class Tag {

    @Id
    private UUID id;
    private String name;

    protected Tag() {}
}