package com.example.templateissue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest(PingController.class)
public class PingControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void shouldReturnPongFromPing() {
        webClient.get()
                 .uri("/ping")
                 .exchange()
                 .expectStatus().isOk()
                 .expectBody(String.class).isEqualTo("pong");
    }
}