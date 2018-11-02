package com.example.templateissue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.nio.charset.StandardCharsets;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@WebFluxTest(PingController.class)
public class PingControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void shouldReturnPongFromPing() {
        final byte[] responseBody = webClient.get()
                                             .uri("/ping")
                                             .exchange()
                                             .expectStatus().isOk()
                                             .expectBody()
                                             .returnResult()
                                             .getResponseBody();

        assertEquals("pong", new String(responseBody, StandardCharsets.UTF_8));
    }
}