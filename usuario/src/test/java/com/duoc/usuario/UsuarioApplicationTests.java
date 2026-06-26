package com.duoc.usuario;

import com.duoc.usuario.Model.Usuario;
import com.duoc.usuario.Service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
@SpringBootTest(properties = "spring.flyway.enabled=false")
//ta raro, hay un problema con'MariaBD' qué
class UsuarioApplicationTests {

    @Autowired
    UsuarioService usuarioService;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("verificar nickname del usuario existente")
    void checkNicknameUsuario() {
        Usuario usuario = usuarioService.findById(1);
        log.info("Revisando usuario: {}", usuario.getNickname());
        assertEquals("RaccoonNebula", usuario.getNickname());
    }

    //saldrá nulo porque en la base de datos este está vacio xd tampoco agregué manualmente aquí

    @Test
    @DisplayName("buscar usuario inexistente por id")
    void checkUsuarioNoExistente() {
        Usuario usuario = usuarioService.findById(9999);
        log.info("buscando usuario con id no existente");
        assertNull(usuario);
    }

    @Test
    @DisplayName("Verificar cantidad de usuarios registrados")
    void checkCantidadUsuarios() {
        List<Usuario> lista = usuarioService.findAll();
        log.info("total de usuarios en bd: {}", lista.size());
        assertEquals(0, lista.size());
    }
}
