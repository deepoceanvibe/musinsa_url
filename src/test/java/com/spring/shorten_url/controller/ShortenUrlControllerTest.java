package com.spring.shorten_url.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class ShortenUrlControllerTest {

    @Autowired
    ShortenUrlController shortenUrlController;

    @Test
    public void findByIdTest() {

    }

}
