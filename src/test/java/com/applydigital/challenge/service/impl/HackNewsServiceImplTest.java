package com.applydigital.challenge.service.impl;

import com.applydigital.challenge.DataForTest;
import com.applydigital.challenge.Util;
import com.applydigital.challenge.client.HackerNewsClient;
import com.applydigital.challenge.repository.StoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.mockito.Mockito.when;

@SpringBootTest
class HackNewsServiceImplTest extends DataForTest {

    @InjectMocks
    private HackNewsServiceImpl fetchNewsService;

    @Mock
    private HackerNewsClient hackerNewsClient;

    @Mock
    private StoryRepository storyRepository;

    @Mock
    private Util util;

    @Test
    public void should_fetchStories(){
        when(hackerNewsClient.fetchNews()).thenReturn(mockNews());

        Assert.notEmpty(fetchNewsService.fetchNews().getHits()
                , "News collection must not be empty");
    }
}