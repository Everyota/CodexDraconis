package com.example.criatura.Client;

import com.example.criatura.DTO.TipoCriaturaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="TipoCriatura")
public interface TipoCriaturaClient {
    @GetMapping("/api/v1/tipo-criatura/{id}")
    TipoCriaturaDTO getTipoCriatura(@PathVariable int id);
}
