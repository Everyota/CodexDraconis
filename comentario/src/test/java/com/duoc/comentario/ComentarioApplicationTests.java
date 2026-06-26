package com.duoc.comentario;

import com.duoc.comentario.model.Comentario;
import com.duoc.comentario.service.ComentarioService;
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
class ComentarioApplicationTests {

    @Autowired
    ComentarioService comentarioService;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("buscar comentario inexistente por id")
    void checkComentarioNoExistente() {
        Comentario criatura = comentarioService.findById(9999);
        log.info("buscando criatura con id no existente");
        assertNull(criatura);
    }

    @Test
    @DisplayName("Verificar cantidad de comentarios registradas")
    void checkCantidadComentarios() {
        List<Comentario> lista = comentarioService.findAll();
        log.info("total de comentarios en bd: {}", lista.size());
        assertEquals(0, lista.size());
    }
}
