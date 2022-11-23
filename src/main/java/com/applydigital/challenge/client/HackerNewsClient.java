package com.applydigital.challenge.client;

import com.applydigital.challenge.entity.Story;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "hackernews", url = "https://hn.algolia.com/api/v1")
public interface HackerNewsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/search_by_date?query=java")
    List<Story> getStories();

}
