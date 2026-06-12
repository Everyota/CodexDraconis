package com.duoc.usuario.Controller;


import com.duoc.usuario.Model.Usuario;
import com.duoc.usuario.Service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
@Tag(name = "API Usuarios", description = "API para la gestion de usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Endpoint permite consultar todos los usuarios")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la lista de usuarios")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa , pero no se encontraron datos")
    public ResponseEntity<List<Usuario>> findAllUsuario() {
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return new ResponseEntity<>(usuarios, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene usuario segun su ID")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega el usuario")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<Usuario> findById(@Parameter(description = "ID del usuario a consultar") @PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
    }

    @GetMapping("/busqueda/{datoUsuario}")
    @Operation(summary = "Obtiene usuario segun su nickname o correo")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega el usuario")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<Usuario> findByNicknameOrCorreo(@PathVariable String datoUsuario) {
        Usuario usuario = usuarioService.findByNicknameOrCorreo(datoUsuario);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
    }

    @PostMapping
    @Operation(summary = "Permite agregar un usuario")
    @ApiResponse(responseCode = "200", description = "Usuario agregado con exito en el sistema ")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.create(usuario), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Permite actualizar un usuario segun su ID")
    @ApiResponse(responseCode = "200", description = "Usuario actualizado con exito en el sistema ")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario updated = usuarioService.update(id, usuario);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Permite eliminar un usuario segun su ID")
    @ApiResponse(responseCode = "200", description = "Usuario eliminado con exito en el sistema ")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<Usuario> delete (@PathVariable int id) {
        boolean isDeleted = usuarioService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}