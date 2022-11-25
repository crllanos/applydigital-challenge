package com.applydigital.challenge.repository;

import com.applydigital.challenge.repository.entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<StoryEntity, Long> {
}
