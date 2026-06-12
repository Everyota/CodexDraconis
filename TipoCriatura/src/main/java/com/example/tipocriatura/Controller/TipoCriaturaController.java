package com.example.tipocriatura.Controller;

import com.example.tipocriatura.Model.TipoCriatura;
import com.example.tipocriatura.Service.TipoCriaturaService;
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
@RequestMapping("/api/v1/tipo-criatura")
@Tag(name = "API Tipos de Criaturas", description = "API para la gestion de tipos de criaturas")
public class TipoCriaturaController {
    @Autowired
    private TipoCriaturaService tipoCriaturaService;

    @GetMapping
    @Operation(summary = "Obtener todos los tipos de criaturas", description = "Endpoint permite consultar todos los tipos de criaturas")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la lista de tipos de criaturas")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa , pero no se encontraron datos")
    public ResponseEntity<List<TipoCriatura>> findAll() {
        List<TipoCriatura> tipoCriaturas = tipoCriaturaService.findAll();
        if (tipoCriaturas.isEmpty()) {
            return new ResponseEntity<>(tipoCriaturas, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(tipoCriaturas, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene tipo de criatura segun su ID")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega el tipo de criatura")
    @ApiResponse(responseCode = "404", description = "Tipo de criatura no encontrado")
    public ResponseEntity<TipoCriatura> findById(@Parameter(description = "ID del tipo de criatura a consultar") @PathVariable int id) {
        TipoCriatura tipoCriatura = tipoCriaturaService.findById(id);
        if (tipoCriatura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(tipoCriatura, HttpStatus.OK);
        }
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo tipo de criatura", description = "Endpoint permite crear un nuevo tipo de criatura")
    @ApiResponse(responseCode = "200", description = "Tipo de criatura creado exitosamente")
    public ResponseEntity<TipoCriatura> create(@RequestBody @Valid TipoCriatura tipoCriatura) {
        return ResponseEntity.ok(tipoCriaturaService.create(tipoCriatura));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un tipo de criatura existente", description = "Endpoint permite actualizar un tipo de criatura existente segun su ID")
    @ApiResponse(responseCode = "200", description = "Tipo de criatura actualizado exitosamente")
    @ApiResponse(responseCode = "404", description = "Tipo de criatura no encontrado")
    public ResponseEntity<TipoCriatura> update(@PathVariable int id, @RequestBody @Valid TipoCriatura tipoCriatura) {
        TipoCriatura updated = tipoCriaturaService.update(id, tipoCriatura);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un tipo de criatura existente", description = "Endpoint permite eliminar un tipo de criatura existente segun su ID")
    @ApiResponse(responseCode = "200", description = "Tipo de criatura eliminado exitosamente")
    @ApiResponse(responseCode = "404", description = "Tipo de criatura no encontrado")
    public ResponseEntity<TipoCriatura> delete(@PathVariable int id) {
        boolean isDeleted = tipoCriaturaService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
