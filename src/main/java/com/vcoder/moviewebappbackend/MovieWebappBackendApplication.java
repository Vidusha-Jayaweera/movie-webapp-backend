package com.vcoder.moviewebappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MovieWebappBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieWebappBackendApplication.class, args);
    }
}
