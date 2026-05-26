package com.duoc.comentario.controller;

import com.duoc.comentario.model.Comentario;
import com.duoc.comentario.service.ComentarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comentarios")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public ResponseEntity<List<Comentario>> findAll() {
        List<Comentario> comentarios = comentarioService.findAll();
        if (comentarios.isEmpty()) {
            return new ResponseEntity<>(comentarios, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(comentarios, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> findById(@PathVariable int id) {
        Comentario comentario = comentarioService.findById(id);
        if (comentario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(comentario, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Comentario> create(@RequestBody @Valid Comentario comentario) {
        return ResponseEntity.ok(comentarioService.create(comentario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> update(@PathVariable int id, @RequestBody @Valid Comentario comentario) {
        Comentario updated = comentarioService.update(id, comentario);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comentario> delete(@PathVariable int id) {
        boolean isDeleted = comentarioService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
