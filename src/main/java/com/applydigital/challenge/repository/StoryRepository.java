package com.applydigital.challenge.repository;

import com.applydigital.challenge.repository.entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<StoryEntity, Long> {

    List<StoryEntity> findStoriesByAuthor(String author);

    List<StoryEntity> findStoriesByTagsLike(String tag);

    List<StoryEntity> findStoriesByTitle(String title);

    //List<StoryEntity> findStoriesByMonth(String month);
}
