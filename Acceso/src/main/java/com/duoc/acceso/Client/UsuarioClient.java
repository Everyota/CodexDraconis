package com.duoc.acceso.Client;

import com.duoc.acceso.DTO.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Usuario")
public interface UsuarioClient {
    @GetMapping("/api/v1/usuarios/busqueda/{datoUsuario}")
    UsuarioDTO getUsuario(@PathVariable String datoUsuario);

    @GetMapping("/api/v1/usuarios/{id}")
    UsuarioDTO getUsuario(@PathVariable int id);
}
