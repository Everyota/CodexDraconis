package com.example.criatura.Client;

import com.example.criatura.DTO.RarezaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Rareza")
public interface RarezaClient {
    @GetMapping("/api/v1/rareza/{id}")
    RarezaDTO getRareza(@PathVariable int id);
}
