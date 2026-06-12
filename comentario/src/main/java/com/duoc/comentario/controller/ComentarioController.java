package com.duoc.comentario.controller;

import com.duoc.comentario.model.Comentario;
import com.duoc.comentario.service.ComentarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comentarios")
@Tag(name = "API Comentarios", description = "API para la gestion de comentarios")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    @Operation(summary = "Obtener todos los comentarios", description = "Endpoint permite consultar todos los comentarios")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la lista de comentarios")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa , pero no se encontraron datos")
    public ResponseEntity<List<Comentario>> findAll() {
        List<Comentario> comentarios = comentarioService.findAll();
        if (comentarios.isEmpty()) {
            return new ResponseEntity<>(comentarios, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(comentarios, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene comentario segun su ID")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega el comentario")
    @ApiResponse(responseCode = "404", description = "Comentario no encontrado")
    public ResponseEntity<Comentario> findById(@Parameter(description = "ID del comentario a consultar") @PathVariable int id) {
        Comentario comentario = comentarioService.findById(id);
        if (comentario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(comentario, HttpStatus.OK);
        }
    }

    @PostMapping
    @Operation(summary = "Permite agregar comentario")
    @ApiResponse(responseCode = "200", description = "Comentario agregado con exito en el sistema ")
    public ResponseEntity<Comentario> create(@RequestBody @Valid Comentario comentario) {
        return ResponseEntity.ok(comentarioService.create(comentario));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Permite actualizar comentario segun su ID")
    @ApiResponse(responseCode = "200", description = "Comentario actualizado con exito en el sistema ")
    @ApiResponse(responseCode = "404", description = "Comentario no encontrado")
    public ResponseEntity<Comentario> update(@PathVariable int id, @RequestBody @Valid Comentario comentario) {
        Comentario updated = comentarioService.update(id, comentario);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Permite eliminar comentario segun su ID")
    @ApiResponse(responseCode = "200", description = "Comentario eliminado con exito en el sistema ")
    @ApiResponse(responseCode = "404", description = "Comentario no encontrado")
    public ResponseEntity<Comentario> delete(@PathVariable int id) {
        boolean isDeleted = comentarioService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
