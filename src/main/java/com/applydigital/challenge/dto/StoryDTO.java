package com.applydigital.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoryDTO {

    @JsonProperty("author")
    private String author;

    //private String _tags;

    @JsonProperty("title")
    private String title;

    //    private LocalDateTime createdAt;
    @JsonProperty("created_at")
    private String createdAt;

  //  private String storyTitle;




}
