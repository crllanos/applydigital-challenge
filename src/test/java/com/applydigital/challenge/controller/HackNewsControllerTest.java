package com.applydigital.challenge.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class HackNewsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private final String url = "/api/v1/hacknews/";

    @Before("")
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldListStoriesByAuthor_OK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url.concat("?author=slavboj&page=0&size=5"))
                        .contentType(MediaType.APPLICATION_JSON))
                            .andExpect(status().isOk())
                            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                            .andExpect(MockMvcResultMatchers.jsonPath("$.content").exists());
    }

    @Test
    public void shouldListStoriesByAuthor_NotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url.concat("?author=NOT-FOUND&page=0&size=5"))
                        .contentType(MediaType.APPLICATION_JSON))
                            .andExpect(status().isOk())
                            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                            .andExpect(MockMvcResultMatchers.jsonPath("$.content").isEmpty());
    }
}
