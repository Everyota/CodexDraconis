package com.example.habilidad.Controller;

import com.example.habilidad.Model.Habilidad;
import com.example.habilidad.Service.HabilidadService;
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
@RequestMapping("/api/v1/habilidad")
@Tag(name = "API Habilidades", description = "API para la gestion de habilidades")
public class HabilidadController {
    @Autowired
    private HabilidadService habilidadService;

    @GetMapping
    @Operation(summary = "Obtener todos las habilidades", description = "Endpoint permite consultar todos las habilidades")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la lista de habilidades")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa , pero no se encontraron datos")
    public ResponseEntity<List<Habilidad>> findAll() {
        List<Habilidad> habilidads = habilidadService.findAll();
        if (habilidads.isEmpty()) {
            return new ResponseEntity<>(habilidads, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(habilidads, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene habilidad segun su ID")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la habilidad")
    @ApiResponse(responseCode = "404", description = "Habilidad no encontrada")
    public ResponseEntity<Habilidad> findById(@Parameter(description = "ID de la habilidad a consultar") @PathVariable int id) {
        Habilidad habilidad = habilidadService.findById(id);
        if (habilidad == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(habilidad, HttpStatus.OK);
        }
    }

    @PostMapping
    @Operation(summary = "Crear una nueva habilidad", description = "Endpoint para crear una nueva habilidad")
    @ApiResponse(responseCode = "200", description = "Habilidad creada exitosamente")
    @ApiResponse(responseCode = "400", description = "Solicitud invalida")
    public ResponseEntity<Habilidad> create(@RequestBody @Valid Habilidad habilidad) {
        return ResponseEntity.ok(habilidadService.create(habilidad));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una habilidad existente", description = "Endpoint para actualizar una habilidad existente segun su ID")
    @ApiResponse(responseCode = "200", description = "Habilidad actualizada exitosamente")
    @ApiResponse(responseCode = "404", description = "Habilidad no encontrada")
    public ResponseEntity<Habilidad> update(@PathVariable int id, @RequestBody @Valid Habilidad habilidad) {
        Habilidad updated = habilidadService.update(id, habilidad);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una habilidad existente", description = "Endpoint para eliminar una habilidad existente segun su ID")
    @ApiResponse(responseCode = "200", description = "Habilidad eliminada exitosamente")
    @ApiResponse(responseCode = "404", description = "Habilidad no encontrada")
    public ResponseEntity<Habilidad> delete(@PathVariable int id) {
        boolean isDeleted = habilidadService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
