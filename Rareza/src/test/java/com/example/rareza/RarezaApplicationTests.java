package com.example.rareza;

import com.example.rareza.Model.Rareza;
import com.example.rareza.Service.RarezaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
@SpringBootTest
class RarezaApplicationTests {

    @Autowired
    RarezaService rarezaService;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("verificar nombre de rareza existente")
    void checkNombreRareza() {
        Rareza rareza = rarezaService.findById(1);
        log.info("Revisando rareza: {}", rareza.getNombreRareza());
        assertEquals("Común", rareza.getNombreRareza());
    }

    @Test
    @DisplayName("buscar rareza inexistente por id")
    void checkRarezaNoExistente() {
        Rareza rareza = rarezaService.findById(9999);
        log.info("buscando rareza con id no existente");
        assertNull(rareza);
    }

    @Test
    @DisplayName("Verificar cantidad de rarezas registradas")
    void checkCantidadRarezas() {
        List<Rareza> lista = rarezaService.findAll();
        log.info("total de rareza en bd: {}", lista.size());
        assertEquals(1, lista.size());
    }

}
