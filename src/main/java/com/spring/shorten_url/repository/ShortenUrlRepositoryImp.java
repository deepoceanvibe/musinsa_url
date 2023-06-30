package com.spring.shorten_url.repository;

import com.spring.shorten_url.entity.ShortenUrl;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class ShortenUrlRepositoryImp implements ShortenUrlRepository {

    // List 자료형 선언
    private List<ShortenUrl> shortenUrlList;


    // shortenUrl 객체 자동으로 받아와서 ArrayList에 저장하기
    public ShortenUrlRepositoryImp() {
        this.shortenUrlList = new ArrayList<>();

        // 테스트 데이터 추가
        ShortenUrl url1 = new ShortenUrl(1, "http://example.com/1", "short1", LocalDateTime.now(), 0);
        ShortenUrl url2 = new ShortenUrl(2, "http://example.com/2", "short2", LocalDateTime.now(), 0);
        ShortenUrl url3 = new ShortenUrl(3, "http://example.com/3", "short3", LocalDateTime.now(), 0);

        // List에 데이터 추가
        shortenUrlList.add(url1);
        shortenUrlList.add(url2);
        shortenUrlList.add(url3);
    }

    @Override
    public String createShortenUrl(String originalUrl) {
        // 이미 생성된 단축 url 있으면 그거 반환
        ShortenUrl existingShortenUrl = findExistingShortenUrl(originalUrl);
        if (existingShortenUrl != null) {
            return existingShortenUrl.getShortenUrl();
        }

        // 랜덤 shortenUrl(String)을 생성하는 알고리즘
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 6;

        StringBuilder shortenUrl = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            shortenUrl.append(characters.charAt(index));
        }

        return shortenUrl.toString();
    }
    private ShortenUrl findExistingShortenUrl(String originalUrl) {
        for (ShortenUrl shortenUrl : shortenUrlList) {
            if (shortenUrl.getOriginalUrl().equals(originalUrl)) {
                return shortenUrl;
            }
        }
        return null;
    }


    @Override
    public void save(ShortenUrl shortenUrl) {
        shortenUrlList.add(shortenUrl);
    }

    @Override
    public ShortenUrl findById(int userId) {
        return shortenUrlList.get(userId);
    }

    @Override
    public List<ShortenUrl> findAll() {
        return shortenUrlList;
    }
}
