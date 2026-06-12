package com.duoc.elemento.Controler;


import com.duoc.elemento.Model.Elemento;
import com.duoc.elemento.Service.ElementoService;
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
@RequestMapping("/api/v1/elementos")
@Tag(name = "API Elementos", description = "API para la gestion de elementos")
public class ElementoController {
    @Autowired
    private ElementoService elementoService;

    @GetMapping
    @Operation(summary = "Obtener todos los elementos", description = "Endpoint permite consultar todos los elementos")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la lista de elementos")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa , pero no se encontraron datos")
    public ResponseEntity<List<Elemento>>findAll() {
        List<Elemento> elementos = elementoService.findAll();
        if (elementos.isEmpty()) {
            return new ResponseEntity<>(elementos, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(elementos, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene elemento segun su ID")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega el elemento")
    @ApiResponse(responseCode = "404", description = "Elemento no encontrado")
    public ResponseEntity<Elemento> findById(@Parameter(description = "ID del elemento a consultar") @PathVariable int id) {
        Elemento elemento = elementoService.findById(id);
        if (elemento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(elemento, HttpStatus.OK);
        }
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo elemento", description = "Endpoint para crear un nuevo elemento")
    @ApiResponse(responseCode = "200", description = "Elemento creado exitosamente")
    public ResponseEntity<Elemento> create(@RequestBody @Valid Elemento elemento) {
        return ResponseEntity.ok(elementoService.create(elemento));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un elemento existente", description = "Endpoint para actualizar un elemento existente segun su ID")
    @ApiResponse(responseCode = "200", description = "Elemento actualizado exitosamente")
    @ApiResponse(responseCode = "404", description = "Elemento no encontrado")
    public ResponseEntity<Elemento> update(@PathVariable int id, @RequestBody @Valid Elemento elemento) {
        Elemento updated = elementoService.update(id, elemento);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un elemento existente", description = "Endpoint para eliminar un elemento existente segun su ID")
    @ApiResponse(responseCode = "200", description = "Elemento eliminado exitosamente")
    @ApiResponse(responseCode = "404", description = "Elemento no encontrado")
    public ResponseEntity<Elemento> delete(@PathVariable int id) {
        boolean isDeleted = elementoService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
