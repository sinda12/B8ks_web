package com.esprit.b8ks_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class B8ksWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(B8ksWebApplication.class, args);
    }







    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
