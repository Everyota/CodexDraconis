package com.duoc.elemento;

import com.duoc.elemento.Model.Elemento;
import com.duoc.elemento.Service.ElementoService;
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
class ElementoApplicationTests {

    @Autowired
    ElementoService elementoService;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("verificar nombre de elemento existente")
    void checkNombreelemento() {
        Elemento elemento = elementoService.findById(1);
        log.info("Revisando elemento: {}", elemento.getNombreElemento());
        assertEquals("Fuego", elemento.getNombreElemento());
    }

    @Test
    @DisplayName("buscar elemento inexistente por id")
    void checkElementoNoExistente() {
        Elemento elemento = elementoService.findById(9999);
        log.info("buscando elemento con id no existente");
        assertNull(elemento);
    }

    @Test
    @DisplayName("Verificar cantidad de elementos registrados")
    void checkCantidadElementos() {
        List<Elemento> lista = elementoService.findAll();
        log.info("total de elemento en bd: {}", lista.size());
        assertEquals(1, lista.size());
    }

}
