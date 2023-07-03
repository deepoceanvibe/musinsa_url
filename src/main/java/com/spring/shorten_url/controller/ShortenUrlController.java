package com.spring.shorten_url.controller;


import com.spring.shorten_url.entity.ShortenUrl;
import com.spring.shorten_url.service.ShortenUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shortenurl")
public class ShortenUrlController {

    private ShortenUrlService shortenUrlService;
    @Autowired
    public ShortenUrlController(ShortenUrlService shortenUrlService) {
        this.shortenUrlService = shortenUrlService;
    }

    @GetMapping("/detail/{userId}")
    public ResponseEntity<?> findById(@PathVariable String userId) {
        ShortenUrl shortenUrl = shortenUrlService.findById(userId);
        return ResponseEntity
                .ok(shortenUrl);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ShortenUrl shortenUrl) {
        shortenUrlService.save(shortenUrl);
        return ResponseEntity
                .ok("URL이 저장되었습니다.");
    }

    @PostMapping("/main/{userId}")
    public ResponseEntity<ShortenUrl> createShortenUrl(@PathVariable String userId, @RequestParam String originalUrl) {

        shortenUrlService.createShortenUrl(originalUrl);
        ShortenUrl shortenUrl = shortenUrlService.findById(userId);

        return ResponseEntity
                .ok(shortenUrl);
    }

    // 단축 URL로 요청시 원본 URL로 리다이렉트


}
