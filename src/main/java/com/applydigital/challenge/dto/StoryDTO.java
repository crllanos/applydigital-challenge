package com.applydigital.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoryDTO {

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("title")
    private String title;

    @JsonProperty("author")
    private String author;

    @JsonProperty("_tags")
    private List<String> tags;

    @JsonProperty("url")
    private String url;

    @JsonProperty("comment_text")
    private String commentText;

    @JsonProperty("story_id")
    private Integer storyId;

    @JsonProperty("story_title")
    private String storyTitle;
}
