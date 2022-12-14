package com.applydigital.challenge.client;

import com.applydigital.challenge.config.FeignClientConfig;
import com.applydigital.challenge.dto.NewsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "hackernews", url = "${feign.hackernews.url}", configuration = FeignClientConfig.class)
public interface HackerNewsClient {

    @GetMapping(value = "/search_by_date?query=java", consumes = MediaType.APPLICATION_JSON_VALUE)
    NewsDTO fetchNews();

}
