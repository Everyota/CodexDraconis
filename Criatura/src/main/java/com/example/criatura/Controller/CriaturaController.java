package com.example.criatura.Controller;

import com.example.criatura.DTO.CriaturaDTO;
import com.example.criatura.Model.Criatura;
import com.example.criatura.Service.CriaturaService;
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
@RequestMapping("/api/v1/criatura")
@Tag(name = "API Criaturas", description = "API para la gestion de criaturas")
public class CriaturaController {

    @Autowired
    private CriaturaService criaturaService;

    @GetMapping
    @Operation(summary = "Obtener todos los criaturas", description = "Endpoint permite consultar todos los criaturas")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la lista de criaturas")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa , pero no se encontraron datos")
    public ResponseEntity<List<Criatura>> findAll() {
        List<Criatura> criaturas = criaturaService.findAll();
        if (criaturas.isEmpty()) {
            return new ResponseEntity<>(criaturas, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(criaturas, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene criatura segun su ID")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la criatura")
    @ApiResponse(responseCode = "404", description = "Criatura no encontrada")
    public ResponseEntity<Criatura> findById(@Parameter(description = "ID de la criatura a consultar") @PathVariable int id) {
        Criatura criatura = criaturaService.findById(id);
        if (criatura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(criatura, HttpStatus.OK);
        }
    }

    @GetMapping("/full-criatura/{id}")
    @Operation(summary = "Obtiene criatura con sus relaciones segun su ID")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la criatura")
    @ApiResponse(responseCode = "404", description = "Criatura no encontrada")
    public ResponseEntity<CriaturaDTO> findByIdFull(@Parameter(description = "ID de la criatura a consultar") @PathVariable int id) {
        CriaturaDTO criatura = criaturaService.findByIdFull(id);
        if (criatura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(criatura, HttpStatus.OK);
        }
    }

    @GetMapping("/tipo-criatura/{id}")
    @Operation(summary = "Obtiene las criaturas según tu ID de tipo")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega las criaturas")
    @ApiResponse(responseCode = "404", description = "Criaturas no encontradas")
    public ResponseEntity<List<Criatura>> findByTipoCriatura(@Parameter(description = "ID del tipo de criatura a consultar") @PathVariable int id) {
        List<Criatura> criatura = criaturaService.findByTipoCriatura(id);
        if (criatura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(criatura, HttpStatus.OK);
        }
    }

    @PostMapping
    @Operation(summary = "Permite agregar una criatura")
    @ApiResponse(responseCode = "200", description = "Criatura agregada con exito en el sistema ")
    public ResponseEntity<Criatura> create(@RequestBody @Valid Criatura criatura) {
        return ResponseEntity.ok(criaturaService.create(criatura));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Permite actualizar una criatura")
    @ApiResponse(responseCode = "200", description = "Criatura actualizada con exito en el sistema ")
    @ApiResponse(responseCode = "404", description = "Criatura no encontrada")
    public ResponseEntity<Criatura> update(@PathVariable int id, @RequestBody @Valid Criatura criatura) {
        Criatura updated = criaturaService.update(id, criatura);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Permite eliminar una criatura")
    @ApiResponse(responseCode = "200", description = "Criatura eliminada con exito en el sistema ")
    @ApiResponse(responseCode = "404", description = "Criatura no encontrada")
    public ResponseEntity<Criatura> delete(@PathVariable int id) {
        boolean isDeleted = criaturaService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
