package com.spring.shorten_url.service;

import com.spring.shorten_url.entity.ShortenUrl;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShortenUrlService {
    List<ShortenUrl> findAll();
    ShortenUrl findById(String userId);
    void save(ShortenUrl shortenUrl);
    String createShortenUrl(String originalUrl);
}
