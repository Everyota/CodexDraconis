package com.example.tipocriatura;

import com.example.tipocriatura.Model.TipoCriatura;
import com.example.tipocriatura.Service.TipoCriaturaService;
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
class TipoCriaturaApplicationTests {

    @Autowired
    TipoCriaturaService tipoCriaturaService;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("verificar nombre de tipo criatura existente")
    void checkNombreTipoCriatura() {
        TipoCriatura tCriatura = tipoCriaturaService.findById(1);
        log.info("Revisando tipo criatura: {}", tCriatura.getNombreTipo());
        assertEquals("Ángel", tCriatura.getNombreTipo());
    }

    @Test
    @DisplayName("buscar tipo criatura inexistente por id")
    void checkTipoCriaturaNoExistente() {
        TipoCriatura tCriatura = tipoCriaturaService.findById(9999);
        log.info("buscando tipo criatura con id no existente");
        assertNull(tCriatura);
    }

    @Test
    @DisplayName("Verificar cantidad de tipos criaturas registradas")
    void checkCantidadTipoCriaturas() {
        List<TipoCriatura> lista = tipoCriaturaService.findAll();
        log.info("total de tipo criaturas en bd: {}", lista.size());
        assertEquals(1, lista.size());
    }

}
