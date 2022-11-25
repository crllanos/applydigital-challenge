package com.applydigital.challenge.config;

import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public Encoder encoder(){
        return new GsonEncoder();
    }

    @Bean
    public Decoder decoder(){
        return new GsonDecoder();
    }

    @Bean
    public Logger logger(){
        return new Slf4jLogger();
    }

    @Bean
    public Logger.Level feignLoggerLevel(){ return Logger.Level.FULL; }
}
