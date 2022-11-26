package com.applydigital.challenge.client;

import com.applydigital.challenge.dto.NewsDTO;
import com.applydigital.challenge.dto.StoryDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class HackerNewsClientMock implements HackerNewsClient {

    @Override
    public NewsDTO fetchNews() {
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
