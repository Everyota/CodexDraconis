package com.duoc.favorito;

import com.duoc.favorito.Model.Favorito;
import com.duoc.favorito.Service.FavoritoService;
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
class FavoritoApplicationTests {

    @Autowired
    FavoritoService favoritoService;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Verificar cantidad de favoritos registradas")
    void checkCantidadFavoritos() {
        List<Favorito> lista = favoritoService.findAll();
        log.info("total de favoritos en bd: {}", lista.size());
        assertEquals(0, lista.size());
    }
}
