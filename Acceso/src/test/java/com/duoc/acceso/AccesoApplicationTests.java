package com.duoc.acceso;

import com.duoc.acceso.model.Acceso;
import com.duoc.acceso.service.AccesoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
@SpringBootTest
class AccesoApplicationTests {

    @Autowired
    AccesoService accesoService;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("verificar cantidad de accesos registrados")
    void checkCantidadAccesos() {
        int cantidad = accesoService.findAll().size();
        log.info("verificacion de registros de Accesos: {}", cantidad);
        assertEquals(0, cantidad);
    }

    @Test
    @DisplayName("buscar acceso inexistente por id")
    void checkAccesoNoExistente() {
        Acceso acceso = accesoService.findById(9999);
        log.info("buscando acceso con id no existente");
        assertNull(acceso);
    }
}
