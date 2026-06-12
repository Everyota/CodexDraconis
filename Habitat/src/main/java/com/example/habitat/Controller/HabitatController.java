package com.example.habitat.Controller;

import com.example.habitat.Model.Habitat;
import com.example.habitat.Service.HabitatService;
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
@RequestMapping("/api/v1/habitat")
@Tag(name = "API Habitats", description = "API para la gestion de habitats")
public class HabitatController {
    @Autowired
    private HabitatService habitatService;

    @GetMapping
    @Operation(summary = "Obtener todos los habitats", description = "Endpoint permite consultar todos los habitats")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la lista de habitats")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa , pero no se encontraron datos")
    public ResponseEntity<List<Habitat>> findAll() {
        List<Habitat> habitats = habitatService.findAll();
        if (habitats.isEmpty()) {
            return new ResponseEntity<>(habitats, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(habitats, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene habitat segun su ID")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega el habitat")
    @ApiResponse(responseCode = "404", description = "Habitat no encontrado")
    public ResponseEntity<Habitat> findById(@Parameter(description = "ID del habitat a consultar") @PathVariable int id) {
        Habitat habitat = habitatService.findById(id);
        if (habitat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(habitat, HttpStatus.OK);
        }
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo habitat", description = "Endpoint para crear un nuevo habitat")
    @ApiResponse(responseCode = "200", description = "Habitat creado exitosamente")
    public ResponseEntity<Habitat> create(@RequestBody @Valid Habitat habitat) {
        return ResponseEntity.ok(habitatService.create(habitat));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un habitat existente", description = "Endpoint para actualizar un habitat existente segun su ID")
    @ApiResponse(responseCode = "200", description = "Habitat actualizado exitosamente")
    @ApiResponse(responseCode = "404", description = "Habitat no encontrado")
    public ResponseEntity<Habitat> update(@PathVariable int id, @RequestBody @Valid Habitat habitat) {
        Habitat updated = habitatService.update(id, habitat);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un habitat existente", description = "Endpoint para eliminar un habitat existente segun su ID")
    @ApiResponse(responseCode = "200", description = "Habitat eliminado exitosamente")
    @ApiResponse(responseCode = "404", description = "Habitat no encontrado")
    public ResponseEntity<Habitat> delete(@PathVariable int id) {
        boolean isDeleted = habitatService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
