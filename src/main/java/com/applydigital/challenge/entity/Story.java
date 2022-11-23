package com.applydigital.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Story {

    private String author;
    private String _tags;
    private String title;
    private LocalDateTime createdAt;

    private String storyTitle;




}
