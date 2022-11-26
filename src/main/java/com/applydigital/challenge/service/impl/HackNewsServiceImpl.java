package com.applydigital.challenge.service.impl;

import com.applydigital.challenge.Util;
import com.applydigital.challenge.client.HackerNewsClientMock;
import com.applydigital.challenge.dto.NewsDTO;
import com.applydigital.challenge.dto.StoryDTO;
import com.applydigital.challenge.repository.StoryRepository;
import com.applydigital.challenge.repository.entity.StoryEntity;
import com.applydigital.challenge.service.HackNewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class HackNewsServiceImpl implements HackNewsService {

    //private final HackerNewsClient hackerNewsClient; // @fixme mock

    private final HackerNewsClientMock hackerNewsClient;

    private final StoryRepository storyRepository;

    private final Util util;

    //@Scheduled(cron = "0 * * * *") @fixme cron
    @Scheduled(fixedDelay = 3000)
    @Override
    public NewsDTO fetchNews(){
        NewsDTO newsDTO = hackerNewsClient.fetchNews();
        log.info("fetchNews() response: {}", util.objToJson(newsDTO));
        for(StoryDTO s : newsDTO.getHits()){
            storyRepository.save(StoryEntity.builder()
                    .title(s.getTitle())
                    .author(s.getAuthor())
                    .tags(String.join(",", s.getTags()))
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
    public List<StoryDTO> listStoriesByAuthor(String author) {
        List<StoryEntity> list = Optional.of(storyRepository.findStoriesByAuthor(author))
                .orElseThrow(EntityNotFoundException::new);
        return parseEntityToDto(list);
    }

    @Override
    public List<StoryDTO> listStoriesByTag(String tag) {
        List<StoryEntity> list = Optional.of(storyRepository.findStoriesByTagsContaining(tag))
                .orElseThrow(EntityNotFoundException::new);
        return parseEntityToDto(list);
    }

    @Override
    public List<StoryDTO> listStoriesByTitle(String title) {
        List<StoryEntity> list = Optional.of(storyRepository.findStoriesByTitle(title))
                .orElseThrow(EntityNotFoundException::new);
        return parseEntityToDto(list);
    }

    @Override
    public List<StoryDTO> listStoriesByMonth(String month) {
        return null;
    }



    private List<StoryDTO> parseEntityToDto(List<StoryEntity> listStories) {
        List<StoryDTO> response = new ArrayList<>();
        for(StoryEntity s : listStories){
            response.add(StoryDTO.builder()
                    .title(s.getTitle())
                    .author(s.getAuthor())
                    .tags(List.of(s.getTags()))
                    .createdAt(s.getCreatedAt())
                    .url(s.getUrl())
                    .storyId(s.getStoryId())
                    .build());
        }
        return response;
    }
}
