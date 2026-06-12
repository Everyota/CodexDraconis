package com.example.rareza.Controller;

import com.example.rareza.Model.Rareza;
import com.example.rareza.Service.RarezaService;
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
@RequestMapping("/api/v1/rareza")
@Tag(name = "API Rarezas", description = "API para la gestion de rarezas")
public class RarezaController {
    @Autowired
    private RarezaService rarezaService;

    @GetMapping
    @Operation(summary = "Obtener todos las rarezas", description = "Endpoint permite consultar todos las rarezas")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la lista de rarezas")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa , pero no se encontraron datos")
    public ResponseEntity<List<Rareza>> findAll() {
        List<Rareza> rarezas = rarezaService.findAll();
        if (rarezas.isEmpty()) {
            return new ResponseEntity<>(rarezas, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(rarezas, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene rareza segun su ID")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la rareza")
    @ApiResponse(responseCode = "404", description = "Rareza no encontrada")
    public ResponseEntity<Rareza> findById(@Parameter(description = "ID de la rareza a consultar") @PathVariable int id) {
        Rareza rareza = rarezaService.findById(id);
        if (rareza == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(rareza, HttpStatus.OK);
        }
    }

    @PostMapping
    @Operation(summary = "Crear una nueva rareza", description = "Endpoint para crear una nueva rareza")
    @ApiResponse(responseCode = "200", description = "Rareza creada exitosamente")
    public ResponseEntity<Rareza> create(@RequestBody @Valid Rareza rareza) {
        return ResponseEntity.ok(rarezaService.create(rareza));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una rareza existente", description = "Endpoint para actualizar una rareza existente segun su ID")
    @ApiResponse(responseCode = "200", description = "Rareza actualizada exitosamente")
    @ApiResponse(responseCode = "404", description = "Rareza no encontrada")
    public ResponseEntity<Rareza> update(@PathVariable int id, @RequestBody @Valid Rareza rareza) {
        Rareza updated = rarezaService.update(id, rareza);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una rareza existente", description = "Endpoint para eliminar una rareza existente segun su ID")
    @ApiResponse(responseCode = "200", description = "Rareza eliminada exitosamente")
    @ApiResponse(responseCode = "404", description = "Rareza no encontrada")
    public ResponseEntity<Rareza> delete(@PathVariable int id) {
        boolean isDeleted = rarezaService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
