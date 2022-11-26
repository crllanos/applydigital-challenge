package com.applydigital.challenge.service;

import com.applydigital.challenge.dto.NewsDTO;
import org.springframework.stereotype.Service;

@Service
public interface FetchNewsService {

    NewsDTO fetchNews();

}
