package com.spring.shorten_url.service;

import com.spring.shorten_url.entity.ShortenUrl;
import com.spring.shorten_url.repository.ShortenUrlRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.PushbackReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShortenUrlServiceTest {

    @Autowired
    ShortenUrlService shortenUrlService;

    @Test
    public void createShortenUrlTest() {
        // given
        String originalUrl = "http://example.com/154554dfdfsdf";

        // when
        String shortenUrl = shortenUrlService.createShortenUrl(originalUrl);

        // then
        assertNotEquals(originalUrl, shortenUrl);
        assertFalse(shortenUrl.matches("\\d+"));
        assertEquals(6, shortenUrl.length());
    }
    @Test
    public void findAllTest() {
        // given
        // when
        List<ShortenUrl>shortenUrlList = shortenUrlService.findAll();
        // then
        assertEquals(3, shortenUrlList.size());
    }
    @Test
    public void findByIdTest() {
        // given
        int userNum = 0;
        String userId = "hi1";
        // when
        shortenUrlService.findById(userId);
        // then
        assertEquals("http://example.com/1", shortenUrlService.findById(userId).getOriginalUrl());
        assertEquals("short1", shortenUrlService.findById(userId).getShortenUrl());
    }
    @Test
    public void saveTest() {
        // given
        int userNum = 3;
        String userId = "hi4";
        String originalUrl = "http://example.com/4495839534jjdj";
        String shortenUrl = "short4";

        ShortenUrl shortenUrl4 = new ShortenUrl();
        shortenUrl4.setUserNum(userNum);
        shortenUrl4.setUserId(userId);
        shortenUrl4.setOriginalUrl(originalUrl);
        shortenUrl4.setShortenUrl(shortenUrl);

        // when
        shortenUrlService.save(shortenUrl4);
        ShortenUrl result = shortenUrlService.findById(userId);

        // then
        assertEquals(4, shortenUrlService.findAll().size());
        assertEquals(originalUrl, result.getOriginalUrl());
        assertEquals(shortenUrl, result.getShortenUrl());
    }
}
