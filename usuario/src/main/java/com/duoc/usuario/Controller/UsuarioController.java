package com.duoc.usuario.Controller;


import com.duoc.usuario.Model.Usuario;
import com.duoc.usuario.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAllUsuario() {
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return new ResponseEntity<>(usuarios, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.create(usuario), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario updated = usuarioService.update(id, usuario);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete (@PathVariable int id) {
        boolean isDeleted = usuarioService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}