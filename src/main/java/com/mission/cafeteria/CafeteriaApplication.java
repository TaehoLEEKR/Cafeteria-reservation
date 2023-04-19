package com.mission.cafeteria;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@ServletComponentScan
@EnableFeignClients
@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
public class CafeteriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CafeteriaApplication.class, args);
    }

}
