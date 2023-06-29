package com.spring.shorten_url.repository;

import com.spring.shorten_url.entity.ShortenUrl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Mapper를 사용하지 않으므로 Repository 구현체 안에 CRUD 로직을 구현할거임
@Repository
public class ShortenUrlRepositoryImp implements ShortenUrlRepository {

    // List 자료형 선언
    private List<ShortenUrl> shortenUrlList;

    // shortenUrl 객체 자동으로 받아와서 ArrayList에 저장하기
    public ShortenUrlRepositoryImp() {
        this.shortenUrlList = new ArrayList<>();
    }

    @Override
    public void save(ShortenUrl shortenUrl) {
        shortenUrlList.add(shortenUrl);
    }

    @Override
    public String createShortenUrl(String originalUrl) {
        // 이미 생성된 단축 url 있으면 그거 반환
        for (ShortenUrl shortenUrl : shortenUrlList) {
            if (shortenUrl.getOriginalUrl().equals(originalUrl)) {
                return shortenUrl.getShortenUrl();
            }
        }

        // 랜덤 shortenUrl(String)을 생성하는 알고리즘
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 7;

        StringBuilder shortenUrl = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            shortenUrl.append(characters.charAt(index));
        }

        return shortenUrl.toString();
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
