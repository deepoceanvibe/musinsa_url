package com.spring.shorten_url.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString @Builder
public class ShortenUrl {

    private int userNum;
    private String userId;
    private String originalUrl;
    private String shortenUrl;
    private LocalDateTime publishedAt;
    private int requestCount;

}
