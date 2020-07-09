package com.okawong.recipeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AbstractAuditEntity.class)
@JsonIgnoreProperties(
        value = {"creationTime", "lastUpdatedTime"},
        allowGetters =  true
)
public abstract class AbstractAuditEntity {
    private static final long serialVersionUID = 123212L;

    @Column(name = "creation_time", nullable = false, updatable = false)
    @CreatedDate
    protected Instant creationTime;

    @Column(name = "last_updated_time", nullable = false)
    @LastModifiedDate
    protected Instant lastUpdatedTime;

    @Column(name = "deletion_time")
    protected Instant deletionTime;
}
