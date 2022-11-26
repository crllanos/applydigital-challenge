package com.applydigital.challenge.repository;

import com.applydigital.challenge.repository.entity.StoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends PagingAndSortingRepository<StoryEntity, Long> {

    Page<StoryEntity> findStoriesByAuthor(String author, Pageable pageable);

    Page<StoryEntity> findStoriesByTagsContaining(String tag, Pageable pageable);

    Page<StoryEntity> findStoriesByTitle(String title, Pageable pageable);

    //@Query(value = "select s from Stories s where month(s.created_at) = :month", nativeQuery = true)
    @Query(value = "select * from Stories s where extract(MONTH FROM s.created_at) = :month", nativeQuery = true)
    Page<StoryEntity> findStoriesByMonth(@Param("month") Integer month, Pageable pageable);
}
