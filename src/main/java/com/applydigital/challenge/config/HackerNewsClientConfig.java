package com.applydigital.challenge.config;

import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HackerNewsClientConfig {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public GsonEncoder encoder(){
        return new GsonEncoder();
    }

    @Bean
    public GsonDecoder decoder(){
        return new GsonDecoder();
    }

    //@Bean   .logger(new Slf4jLogger(BookClient.class))

    @Bean
    public Logger.Level feignLoggerLevel(){ return Logger.Level.FULL; }
}
