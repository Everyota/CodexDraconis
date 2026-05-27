package com.duoc.acceso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccesoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccesoApplication.class, args);
    }

}
