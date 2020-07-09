package com.okawong.recipeservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@Where(clause = "deletion_time IS NULL")
@Table(name = "tags")
public class Tag extends AbstractAuditEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(columnDefinition = "text not null unique")
    private String name;

    protected Tag() {}

    public Tag(String name) {
        this.name = name;
        this.creationTime = Instant.now();
        this.lastUpdatedTime = creationTime;
    }
}