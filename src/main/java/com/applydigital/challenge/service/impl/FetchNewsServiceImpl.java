package com.applydigital.challenge.service.impl;

import com.applydigital.challenge.Util;
import com.applydigital.challenge.client.HackerNewsClientMock;
import com.applydigital.challenge.dto.NewsDTO;
import com.applydigital.challenge.dto.StoryDTO;
import com.applydigital.challenge.repository.StoryRepository;
import com.applydigital.challenge.repository.entity.StoryEntity;
import com.applydigital.challenge.service.FetchNewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FetchNewsServiceImpl implements FetchNewsService {

    //private final HackerNewsClient hackerNewsClient; // @fixme mock
    private final HackerNewsClientMock hackerNewsClient;
    private final StoryRepository storyRepository;
    private final Util util;

    //@Scheduled(cron = "0 * * * *") @fixme cron
    @Scheduled(fixedDelay = 3000)
    @Override
    public NewsDTO fetchNews(){
        NewsDTO newsDTO = hackerNewsClient.fetchNews();
        log.info("fetchNews() response: {}", util.objectToJson(newsDTO));
        for(StoryDTO s : newsDTO.getHits()){
            storyRepository.save(StoryEntity.builder()
                    .title(s.getTitle())
                    .author(s.getAuthor())
                    .tags(String.join(",", s.get_tags()))
                    .createdAt(s.getCreatedAt())
                    .url(s.getUrl())
                    .storyId(s.getStoryId())
                    .storyTitle(s.getStoryTitle())
                    .commentText(s.getCommentText())
                    .build());
        }
        return newsDTO;
    }
}
