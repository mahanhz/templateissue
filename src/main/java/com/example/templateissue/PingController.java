package com.example.templateissue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping(value = "/ping")
public class PingController {

    private final AtomicBoolean isAppRunning = new AtomicBoolean(true);

    @GetMapping
    public Mono<ResponseEntity<String>> ping() {
        if (isAppRunning.get()) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK).body("pong"));
        }

        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping
    public Mono<ResponseEntity<String>> startPing() {
        isAppRunning.set(true);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).build());
    }

    @DeleteMapping
    public Mono<ResponseEntity<String>> stopPing() {
        isAppRunning.set(false);
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
