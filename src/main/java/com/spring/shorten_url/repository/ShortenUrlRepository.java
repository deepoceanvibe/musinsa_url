package com.spring.shorten_url.repository;


import com.spring.shorten_url.entity.ShortenUrl;

import java.util.List;

public interface ShortenUrlRepository {

    // 단축 URL 생성
    String createShortenUrl(String originalUrl);

    // 단축 URL 저장
    void save(ShortenUrl shortenUrl);

    // 단축 URL 개별 조회
    ShortenUrl findById(int userId);

    // 단축 URL 전체 조회
    List<ShortenUrl> findAll();

}