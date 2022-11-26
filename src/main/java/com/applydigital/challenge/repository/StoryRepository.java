package com.applydigital.challenge.repository;

import com.applydigital.challenge.repository.entity.StoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends PagingAndSortingRepository<StoryEntity, Long> {

    Page<StoryEntity> findStoriesByAuthor(String author, Pageable pageable);

    List<StoryEntity> findStoriesByTagsContaining(String tag, Pageable pageable);

    List<StoryEntity> findStoriesByTitle(String title, Pageable pageable);

    //List<StoryEntity> findStoriesByMonth(String month, Pageable pageable);
}
