package com.applydigital.challenge.service;

import com.applydigital.challenge.dto.NewsDTO;
import com.applydigital.challenge.dto.StoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HackNewsService {

    NewsDTO fetchNews();

    List<StoryDTO> listStoriesByAuthor(String author);

    List<StoryDTO> listStoriesByTag(String tag);

    List<StoryDTO> listStoriesByTitle(String title);

    List<StoryDTO> listStoriesByMonth(String month);

}
