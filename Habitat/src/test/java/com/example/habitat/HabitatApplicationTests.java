package com.example.habitat;

import com.example.habitat.Model.Habitat;
import com.example.habitat.Service.HabitatService;
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
class HabitatApplicationTests {

    @Autowired
    HabitatService habitatService;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("verificar nombre de habitat existente")
    void checkNombreHabitat() {
        Habitat habitat = habitatService.findById(1);
        log.info("Revisando habitat: {}", habitat.getNombreHabitat());
        assertEquals("Polar", habitat.getNombreHabitat());
    }

    @Test
    @DisplayName("buscar habitat inexistente por id")
    void checkHabitatNoExistente() {
        Habitat habitat = habitatService.findById(9999);
        log.info("buscando habitat con id no existente");
        assertNull(habitat);
    }

    @Test
    @DisplayName("Verificar cantidad de habitats registradas")
    void checkCantidadHabitat() {
        List<Habitat> lista = habitatService.findAll();
        log.info("total de habitats en bd: {}", lista.size());
        assertEquals(1, lista.size());
    }
}
