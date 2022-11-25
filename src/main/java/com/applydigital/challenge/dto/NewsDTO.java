package com.applydigital.challenge.dto;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {

    @SerializedName("hits")
    private List<StoryDTO> hits;

}
