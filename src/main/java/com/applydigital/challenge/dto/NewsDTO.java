package com.applydigital.challenge.dto;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.Collection;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {

    @SerializedName("hits")
    private Collection<StoryDTO> hits;

}
