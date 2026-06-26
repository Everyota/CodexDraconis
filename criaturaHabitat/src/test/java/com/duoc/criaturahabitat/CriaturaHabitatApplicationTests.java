package com.duoc.criaturahabitat;

import com.duoc.criaturahabitat.model.CriaturaHabitat;
import com.duoc.criaturahabitat.service.CriaturaHabitatService;
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
class CriaturaHabitatApplicationTests {

    @Autowired
    CriaturaHabitatService criaturaHabitatService;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Verificar cantidad de habitats registrados")
    void checkCantidadHabitats() {
        List<CriaturaHabitat> lista = criaturaHabitatService.findAll();
        log.info("total de habitats en bd: {}", lista.size());
        assertEquals(0, lista.size());
    }

}
