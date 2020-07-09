package com.okawong.recipeservice.repositories;

import com.okawong.recipeservice.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
}
