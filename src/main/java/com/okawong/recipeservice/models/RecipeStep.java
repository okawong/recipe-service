package com.okawong.recipeservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name =  "recipe_steps")
public class RecipeStep extends AbstractAuditEntity {

    @Id
    @GeneratedValue
    private UUID id;

    protected RecipeStep() {
        super(Instant.now());
    }
}