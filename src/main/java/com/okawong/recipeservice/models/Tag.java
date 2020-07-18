package com.okawong.recipeservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@Table(name = "tags")
public class Tag extends AbstractAuditEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(columnDefinition = "text not null unique")
    private String name;

    protected Tag() {
        super(Instant.now());
    }

    public Tag(String name) {
        super(Instant.now());
        this.name = name;
    }
}