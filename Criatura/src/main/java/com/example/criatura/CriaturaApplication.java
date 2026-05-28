package com.example.criatura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CriaturaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CriaturaApplication.class, args);
    }

}
