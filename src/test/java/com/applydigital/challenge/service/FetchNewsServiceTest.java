package com.applydigital.challenge.service;

import com.applydigital.challenge.client.HackerNewsClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class FetchNewsServiceTest {

    @Autowired
    private HackerNewsClient hackerNewsClient;

    @Test
    public void should_fetchStories(){
        //hackerNewsClient.getStories();
    }
}