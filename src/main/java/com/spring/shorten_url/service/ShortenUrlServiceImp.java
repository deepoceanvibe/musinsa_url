package com.spring.shorten_url.service;

import com.spring.shorten_url.entity.ShortenUrl;
import com.spring.shorten_url.repository.ShortenUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortenUrlServiceImp implements ShortenUrlService {

    ShortenUrlRepository shortenUrlRepository;

    @Autowired
    public ShortenUrlServiceImp(ShortenUrlRepository shortenUrlRepository) {
        this.shortenUrlRepository = shortenUrlRepository;
    }

    @Override
    public List<ShortenUrl> findAll() {
        return shortenUrlRepository.findAll();
    }

    @Override
    public ShortenUrl findById(String userId) {
        return shortenUrlRepository.findById(userId);
    }

    @Override
    public void save(ShortenUrl shortenUrl) {
        shortenUrlRepository.save(shortenUrl);
    }

    @Override
    public String createShortenUrl(String originalUrl) {
        return shortenUrlRepository.createShortenUrl(originalUrl);
    }
}
