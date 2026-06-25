package com.example.criatura;

import com.example.criatura.Model.Criatura;
import com.example.criatura.Service.CriaturaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class CriaturaApplicationTests {

    @Autowired
    CriaturaService criaturaService;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("verificar nombre de criatura existente")
    void checkNombreCriatura() {
        Criatura criatura = criaturaService.findById(1);
        log.info("Revisando criatura: {}", criatura.getNombreCriatura());
        assertEquals("Basilisco", criatura.getNombreCriatura());
    }

    //saldrá nulo porque en la base de datos este está vacio xd tampoco agregué manualmente aquí

    @Test
    @DisplayName("buscar criatura inexistente")
    void checkCriaturaNoExistente() {
        Criatura criatura = criaturaService.findById(9999);
        log.info("buscando criatura con id no existente");
        assertNull(criatura);
    }

    @Test
    @DisplayName("Verificar cantidad de criaturas registradas")
    void checkCantidadCriaturas() {
        List<Criatura> lista = criaturaService.findAll();
        log.info("total de criaturas en bd: {}", lista.size());
        assertEquals(0, lista.size());
    }
}