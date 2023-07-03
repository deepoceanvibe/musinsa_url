package com.spring.shorten_url.repository;

import com.spring.shorten_url.entity.ShortenUrl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShortenUrlRepositoryTest {

    @Autowired
    ShortenUrlRepository shortenUrlRepository;

    @Test
    public void createShortenUrlTest() {
        // given
        String originalUrl = "http://example.com/516584561";

        // when
        String shortenUrl = shortenUrlRepository.createShortenUrl(originalUrl);

        // then
        assertNotEquals(originalUrl, shortenUrl);
        assertFalse(shortenUrl.matches("\\d+"));
        assertEquals(6, shortenUrl.length());

    }
    @Test
    public void saveTest() {
        // given
        int userNum = 3;
        String userId = "hi4";
        String originalUrl = "http://example.com/4";
        String shortenUrl = "short4";

        ShortenUrl shortenUrlBuilder = ShortenUrl.builder()
                .userNum(userNum)
                .userId(userId)
                .originalUrl(originalUrl)
                .shortenUrl(shortenUrl)
                .build();

        // when
        List<ShortenUrl> shortenUrlList = shortenUrlRepository.findAll();
        shortenUrlRepository.save(shortenUrlBuilder);

        // then
        assertEquals(4, shortenUrlList.size());
        assertEquals(originalUrl, shortenUrlList.get(userNum).getOriginalUrl());
        assertEquals(shortenUrl, shortenUrlList.get(userNum).getShortenUrl());
    }
    @Test
    public void findAllTest() {
        // given
        // when
        List<ShortenUrl>shortenUrlList = shortenUrlRepository.findAll();
        // then
        assertEquals(3, shortenUrlList.size());
    }
    @Test
    public void findByIdTest() {
        // given
        String userId = "hi2";
        String originalUrl = "http://example.com/2";
        String shortenUrl = "short2";

        ShortenUrl shortenUrlBuilder = ShortenUrl.builder()
                .userId(userId)
                .originalUrl(originalUrl)
                .shortenUrl(shortenUrl)
                .build();

        // when
        ShortenUrl url2 = shortenUrlRepository.findById(userId);

        // then
        assertEquals(originalUrl, url2.getOriginalUrl());
        assertEquals(shortenUrl, url2.getShortenUrl());
    }
}
