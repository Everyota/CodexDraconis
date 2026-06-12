package com.duoc.criaturaelemento.controller;

import com.duoc.criaturaelemento.model.CriaturaElemento;
import com.duoc.criaturaelemento.service.CriaturaElementoService;
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
@RequestMapping("/api/v1/criatura-elementos")
@Tag(name = "API Criatura-Elemento", description = "API para la gestion de criaturas y elementos")
public class CriaturaElementoController {
    @Autowired
    private CriaturaElementoService criaturaElementoService;

    @GetMapping
    @Operation(summary = "Obtener todos los criatura-elemento", description = "Endpoint permite consultar todos los criatura-elemento")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la lista de criatura-elemento")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa , pero no se encontraron datos")
    public ResponseEntity<List<CriaturaElemento>> findAll(){
        List<CriaturaElemento> criaturaElementos = criaturaElementoService.findAll();
        if (criaturaElementos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(criaturaElementos);
        }
    }

    @GetMapping("/elemento/{id}")
    @Operation(summary = "Obtiene criatura-elemento segun un ID de elemento")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entregan las relaciones criatura-elemento")
    @ApiResponse(responseCode = "404", description = "Relaciones Criatura-Elemento no encontradas")
    public ResponseEntity<List<CriaturaElemento>> findByElemento(@Parameter(description = "ID del elemento a consultar") @PathVariable int id) {
        List<CriaturaElemento> criaturaElementos = criaturaElementoService.findByElemento(id);
        if (criaturaElementos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(criaturaElementos);
        }
    }

    @GetMapping("/criatura/{id}")
    @Operation(summary = "Obtiene criatura-elemento segun un ID de criatura")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entregan las relaciones criatura-elemento")
    @ApiResponse(responseCode = "404", description = "Relaciones Criatura-Elemento no encontradas")
    public ResponseEntity<List<CriaturaElemento>> findByCriatura(@Parameter(description = "ID de la criatura a consultar") @PathVariable int id) {
        List<CriaturaElemento> criaturaElementos = criaturaElementoService.findByCriatura(id);
        if (criaturaElementos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(criaturaElementos);
        }
    }
    @PostMapping
    @Operation(summary = "Permite relacionar una criatura con un elemento", description = "Endpoint para agregar una relacion entre criatura y elemento")
    @ApiResponse(responseCode = "200", description = "Relación criatura con elementos creada con exito en el sistema ")
    public ResponseEntity<CriaturaElemento> create(@RequestBody @Valid CriaturaElemento criaturaElemento) {

        return ResponseEntity.ok(criaturaElementoService.create(criaturaElemento));
    }

    //Las id las va a detectar como distintas aunque estén juntas en el enunciado
    @DeleteMapping("/{idCriatura}/{idElemento}")
    @Operation(summary = "Permite eliminar la relación entre una criatura y un elemento", description = "Endpoint para eliminar una relacion entre criatura y elemento")
    @ApiResponse(responseCode = "200", description = "Relación criatura con elemento eliminada con exito en el sistema ")
    @ApiResponse(responseCode = "404", description = "Relación criatura con elemento no encontrada")
    public ResponseEntity<CriaturaElemento> delete(@PathVariable int idCriatura, @PathVariable int idElemento) {
        boolean isDeleted = criaturaElementoService.delete(idElemento, idCriatura);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
