package com.example.habilidad;

import com.example.habilidad.Model.Habilidad;
import com.example.habilidad.Service.HabilidadService;
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
class HabilidadApplicationTests {

    @Autowired
    HabilidadService habilidadService;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("verificar nombre de habilidad existente")
    void checkNombreHabilidad() {
        Habilidad habilidad = habilidadService.findById(1);
        log.info("Revisando habilidad: {}", habilidad.getNombreHabilidad());
        assertEquals("espinas", habilidad.getNombreHabilidad());
    }

    //saldrá nulo porque en la base de datos este está vacio xd tampoco agregué manualmente aquí

    @Test
    @DisplayName("buscar habilidad inexistente por id")
    void checkHabilidadNoExistente() {
        Habilidad habilidad = habilidadService.findById(9999);
        log.info("buscando habilidad con id no existente");
        assertNull(habilidad);
    }

    @Test
    @DisplayName("Verificar cantidad de habilidades registradas")
    void checkCantidadHabilidad() {
        List<Habilidad> lista = habilidadService.findAll();
        log.info("total de habilidades en bd: {}", lista.size());
        assertEquals(0, lista.size());
    }

}
