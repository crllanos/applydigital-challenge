package com.applydigital.challenge.service;

import com.applydigital.challenge.Util;
import com.applydigital.challenge.client.HackerNewsClient;
import com.applydigital.challenge.dto.NewsDTO;
import com.applydigital.challenge.dto.StoryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FetchNewsService {

    private final HackerNewsClient hackerNewsClient;
    private final Util util;

    @Scheduled(fixedDelay = 3000)
    public void fetchNews(){
        NewsDTO newsDTO = hackerNewsClient.getNews();
        log.info("getNews() response: {}", util.objectToJson(newsDTO));
        for(StoryDTO s : newsDTO.getHits()){
            log.info(String.valueOf(s));
        }
    }
}
