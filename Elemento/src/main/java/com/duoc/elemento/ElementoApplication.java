package com.duoc.elemento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ElementoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElementoApplication.class, args);
    }

}
