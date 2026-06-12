package com.duoc.criaturahabitat.controller;

import com.duoc.criaturahabitat.model.CriaturaHabitat;
import com.duoc.criaturahabitat.service.CriaturaHabitatService;
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
@RequestMapping("/api/v1/criatura-habitats")
@Tag(name = "API Criatura-Habitat", description = "API para la gestion de criaturas en habitats")
public class CriaturaHabitatController {
    @Autowired
    private CriaturaHabitatService criaturaHabitatService;

    @GetMapping
    @Operation(summary = "Obtener todos las criaturas en habitats", description = "Endpoint permite consultar todos las criaturas en habitats")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la lista de criaturas en habitats")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa , pero no se encontraron datos")
    public ResponseEntity<List<CriaturaHabitat>> findAll(){
        List<CriaturaHabitat> criaturaHabitats = criaturaHabitatService.findAll();
        if (criaturaHabitats.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(criaturaHabitats);
        }
    }

    @GetMapping("/habitat/{id}")
    @Operation(summary = "Obtiene criatura en habitat segun su ID")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la criatura en habitat")
    @ApiResponse(responseCode = "404", description = "Criatura en habitat no encontrada")
    public ResponseEntity<List<CriaturaHabitat>> findByHabitat(@Parameter(description = "ID de la criatura habitat a consultar") @PathVariable int id) {
        List<CriaturaHabitat> criaturaHabitats = criaturaHabitatService.findByHabitat(id);
        if (criaturaHabitats.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(criaturaHabitats);
        }
    }

    @GetMapping("/criatura/{id}")
    @Operation(summary = "Obtiene criatura en habitat segun su ID de criatura")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la lista de criaturas en habitat")
    @ApiResponse(responseCode = "404", description = "Criaturas en habitat no encontrada")
    public ResponseEntity<List<CriaturaHabitat>> findByCriatura(@PathVariable int id) {
        List<CriaturaHabitat> criaturaHabitats = criaturaHabitatService.findByCriatura(id);
        if (criaturaHabitats.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(criaturaHabitats);
        }
    }
    @PostMapping
    @Operation(summary = "Crea una nueva relación criatura-habitat")
    @ApiResponse(responseCode = "200", description = "Relación criatura-habitat creada exitosamente")
    public ResponseEntity<CriaturaHabitat> create(@RequestBody @Valid CriaturaHabitat criaturaHabitat) {

        return ResponseEntity.ok(criaturaHabitatService.create(criaturaHabitat));
    }

    //Las id las va a detectar como distintas aunque estén juntas en el enunciado
    @DeleteMapping("/{idCriatura}/{idHabitat}")
    @Operation(summary = "Permite eliminar la relación entre una criatura y un habitat", description = "Endpoint para eliminar una relacion entre criatura y habitat")
    @ApiResponse(responseCode = "200", description = "Relación criatura-habitat eliminada exitosamente")
    @ApiResponse(responseCode = "404", description = "Relación criatura-habitat no encontrada")
    public ResponseEntity<CriaturaHabitat> delete(@PathVariable int idCriatura, @PathVariable int idHabitat) {
        boolean isDeleted = criaturaHabitatService.delete(idHabitat, idCriatura);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
