package com.applydigital.challenge.service;

import com.applydigital.challenge.dto.NewsDTO;
import com.applydigital.challenge.dto.StoryDTO;
import com.applydigital.challenge.repository.entity.StoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HackNewsService {

    NewsDTO fetchNews();

    Page<StoryEntity> listStoriesByAuthor(String author, int page, int size);

    Page<StoryEntity> listStoriesByTag(String tag, int page, int size);

    Page<StoryEntity> listStoriesByTitle(String title, int page, int size);

    Page<StoryEntity> listStoriesByMonth(String month);

}
