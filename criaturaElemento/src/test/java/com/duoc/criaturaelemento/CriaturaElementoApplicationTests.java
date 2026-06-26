package com.duoc.criaturaelemento;

import com.duoc.criaturaelemento.model.CriaturaElemento;
import com.duoc.criaturaelemento.service.CriaturaElementoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class CriaturaElementoApplicationTests {

    @Autowired
    CriaturaElementoService criaturaElementoService;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Verificar cantidad de elementos registrados")
    void checkCantidadElementos() {
        List<CriaturaElemento> lista = criaturaElementoService.findAll();
        log.info("total de elementos en bd: {}", lista.size());
        assertEquals(0, lista.size());
    }
}
