package com.applydigital.challenge.service;

import com.applydigital.challenge.Util;
import com.applydigital.challenge.client.HackerNewsClientMock;
import com.applydigital.challenge.dto.NewsDTO;
import com.applydigital.challenge.dto.StoryDTO;
import com.applydigital.challenge.repository.StoryRepository;
import com.applydigital.challenge.service.impl.HackNewsServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class FetchNewsServiceTest {

    @InjectMocks
    private HackNewsServiceImpl fetchNewsService;

    @Mock
    private HackerNewsClientMock hackerNewsClient;

    @Mock
    private StoryRepository storyRepository;

    @Mock
    private Util util;

    @Test
    public void should_fetchStories(){
        when(hackerNewsClient.fetchNews()).thenReturn(mockNews());

        NewsDTO news = fetchNewsService.fetchNews();
        Assert.notEmpty(news.getHits(), "news.fetchNews() must contain elements");
    }

    private NewsDTO mockNews() {
        return NewsDTO.builder().hits(List.of(
                storyMock(123,"Phillip K. Dick", "Ovejas"),
                storyMock(456,"Arthur C. Clark", "Ramah")
        )).build();
    }

    protected StoryDTO storyMock(Integer storyId, String author, String title){
        return StoryDTO.builder()
                .title(title)
                .author(author)
                .tags(List.of("tag1","tag2","tag3"))
                .createdAt(LocalDateTime.now())
                .url("url")
                .storyId(storyId)
                .build();
    }
}