package com.spring.shorten_url.repository;


import com.spring.shorten_url.entity.ShortenUrl;

public interface ShortenUrlRepository {

    // 단축 URL 생성
    String createShortenUrl(String originalUrl);

    // 단축 URL 저장
    void save(ShortenUrl shortenUrl);

    // 단축 URL 조회
    ShortenUrl findById(int userId);

}