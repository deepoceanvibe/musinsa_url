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
        String originalUrl = "deepoceanvibe/musinsa_url";

        // when
        String shortenUrl = shortenUrlRepository.createShortenUrl(originalUrl);

        // then
        assertNotEquals(originalUrl, shortenUrl);
        assertFalse(shortenUrl.matches("\\d+"));
    }
    @Test
    public void saveTest() {
        // given
        int userId = 0;
        String originalUrl = "https://github.com/deepoceanvibe/spring_mvc/blob/master/src/test/java/com/spring/mvc/chap04/ScoreRepositoryTest.java#L20";
        String shortenUrl = "https://github.com/3CPSkut";

        ShortenUrl shortenUrlBuilder = ShortenUrl.builder()
                .originalUrl(originalUrl)
                .shortenUrl(shortenUrl)
                .build();

        // when
        List<ShortenUrl> shortenUrlList = shortenUrlRepository.findAll();
        shortenUrlRepository.save(shortenUrlBuilder);

        // then
        assertEquals(originalUrl, shortenUrlList.get(userId).getOriginalUrl());
        assertEquals(shortenUrl, shortenUrlList.get(userId).getShortenUrl());
    }
    @Test
    public void findByIdTest() {
        // given
        int userId = 2;
        String originalUrl = "https://velog.io/@oceanyu/%EC%8A%A4%ED%94%84%EB%A7%81-Mybatis-%EB%B8%94%EB%A1%9C%EA%B7%B8-%EB%A7%8C%EB%93%A4%EA%B8%B0-feat.-REST%EC%84%9C%EB%B2%84";
        String shortenUrl = "https://velog.io/4NE5dom";

        ShortenUrl shortenUrlBuilder = ShortenUrl.builder()
                .userId(userId)
                .originalUrl(originalUrl)
                .shortenUrl(shortenUrl)
                .build();

        shortenUrlRepository.save(shortenUrlBuilder);

        // when
        ShortenUrl shortenUrl2 = shortenUrlRepository.findById(userId);
        // then
        assertEquals(originalUrl, shortenUrl2.getOriginalUrl());
        assertEquals(shortenUrl, shortenUrl2.getShortenUrl());
    }
    @Test
    public void findAllTest() {
        // given

        // when

        // then
    }
}
