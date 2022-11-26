package com.applydigital.challenge.service.impl;

import com.applydigital.challenge.Util;
import com.applydigital.challenge.client.HackerNewsClient;
import com.applydigital.challenge.client.HackerNewsClientMock;
import com.applydigital.challenge.dto.NewsDTO;
import com.applydigital.challenge.dto.StoryDTO;
import com.applydigital.challenge.exception.HackNewsException;
import com.applydigital.challenge.repository.StoryRepository;
import com.applydigital.challenge.repository.entity.StoryEntity;
import com.applydigital.challenge.service.HackNewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.Month;

@Service
@Slf4j
@RequiredArgsConstructor
public class HackNewsServiceImpl implements HackNewsService {

    private final HackerNewsClient hackerNewsClient;

    private final StoryRepository storyRepository;

    private final Util util;

    /**
     * Scheduled cron service for fetching data from Hacker News and persist
     *
     * @return NewsDTO
     */
    //@Scheduled(cron = "0 * * * *") @fixme cron
    @Scheduled(fixedDelay = 30000)
    @Override
    public NewsDTO fetchNews(){
        NewsDTO newsDTO = hackerNewsClient.fetchNews();
        log.info("fetchNews() response: {}", util.objToJson(newsDTO));
        for(StoryDTO s : newsDTO.getHits()){
            storyRepository.save(StoryEntity.builder()
                    .title(s.getTitle())
                    .author(s.getAuthor())
                    .tags( (!ObjectUtils.isEmpty(s.getTags()) ? String.join(",", s.getTags()) : null) )
                    .createdAt(s.getCreatedAt())
                    .url(s.getUrl())
                    .storyId(s.getStoryId())
                    .storyTitle(s.getStoryTitle())
                    .commentText(s.getCommentText())
                    .build());
        }
        return newsDTO;
    }

    @Override
    public Page<StoryEntity> listStoriesByAuthor(String author, int page, int size) {
        return storyRepository.findStoriesByAuthor(author, PageRequest.of(page, size));
    }

    @Override
    public Page<StoryEntity> listStoriesByTag(String tag, int page, int size) {
        return storyRepository.findStoriesByTagsContaining(tag, PageRequest.of(page, size));
    }

    @Override
    public Page<StoryEntity> listStoriesByTitle(String title, int page, int size) {
        return storyRepository.findStoriesByTitleContaining(title, PageRequest.of(page, size));
    }

    @Override
    public Page<StoryEntity> listStoriesByMonth(String month, int page, int size) {
        try{
            Month m = Month.valueOf(month.toUpperCase());
            return storyRepository.findStoriesByMonth(m.getValue(), PageRequest.of(page, size));
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

}
