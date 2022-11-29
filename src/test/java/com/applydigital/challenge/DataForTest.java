package com.applydigital.challenge;

import com.applydigital.challenge.dto.NewsDTO;
import com.applydigital.challenge.dto.StoryDTO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Util class for mocking objects
 *
 */
public class DataForTest {

    protected NewsDTO mockNews() {
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
