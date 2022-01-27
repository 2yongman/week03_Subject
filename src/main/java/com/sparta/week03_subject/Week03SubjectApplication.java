package com.sparta.week03_subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week03SubjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week03SubjectApplication.class, args);
    }

}
