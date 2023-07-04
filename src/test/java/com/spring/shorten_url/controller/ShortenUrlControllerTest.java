package com.spring.shorten_url.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.shorten_url.repository.ShortenUrlRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class ShortenUrlControllerTest {

    @Autowired
    private MockMvc mockMvc;        // 가짜 브라우저 객체
    @Autowired
    private WebApplicationContext context;      // 웹에서 스프링빈들을 관리하는거
    @Autowired
    private ObjectMapper objectMapper;      // 직렬화 시켜주는거
    @Autowired
    ShortenUrlRepository shortenUrlRepository;

    @Test
    public void findByIdTest() {

    }

}
