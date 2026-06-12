package com.duoc.acceso.controller;

import com.duoc.acceso.DTO.LoginDTO;
import com.duoc.acceso.model.Acceso;
import com.duoc.acceso.service.AccesoService;
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
@RequestMapping("/api/v1/accesos")
@Tag(name = "API Acceso", description = "API para la gestion de accesos")
public class AccesoController {
    @Autowired
    private AccesoService accesoService;

    @GetMapping
    @Operation(summary = "Obtener todos los accesos", description = "Endpoint permite consultar todos los accesos")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la lista de accesos")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa , pero no se encontraron datos")
    public ResponseEntity<List<Acceso>> findAll() {
        List<Acceso> accesos = accesoService.findAll();
        if (accesos.isEmpty()) {
            return new ResponseEntity<>(accesos, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(accesos, HttpStatus.OK); 
        }

    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene acceso segun su ID")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega el acceso")
    @ApiResponse(responseCode = "404", description = "Acceso no encontrado")
    public ResponseEntity<Acceso> findById(@Parameter(description = "ID del acceso a consultar") @PathVariable int id) {
        Acceso Acceso = accesoService.findById(id);
        if (Acceso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(Acceso, HttpStatus.OK);
        }
    }

    @PostMapping
    @Operation(summary = "Permite agregar acceso")
    @ApiResponse(responseCode = "200", description = "Acceso agregado con exito en el sistema ")
    public ResponseEntity<Acceso> create(@RequestBody @Valid Acceso Acceso) {
        return ResponseEntity.ok(accesoService.create(Acceso));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Permite actualizar acceso segun su ID")
    @ApiResponse(responseCode = "200", description = "Acceso actualizado con exito en el sistema ")
    @ApiResponse(responseCode = "404", description = "Acceso no encontrado")
    public ResponseEntity<Acceso> update(@PathVariable int id, @RequestBody @Valid Acceso Acceso) {
        Acceso updated = accesoService.update(id, Acceso);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Permite eliminar acceso segun su ID")
    @ApiResponse(responseCode = "200", description = "Acceso eliminado con exito en el sistema ")
    @ApiResponse(responseCode = "404", description = "Acceso no encontrado")
    public ResponseEntity<Acceso> delete(@Parameter(description = "ID del acceso a eliminar") @PathVariable int id) {
        boolean isDeleted = accesoService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    @Operation(summary = "Permite iniciar sesión en el sistema")
    @ApiResponse(responseCode = "200", description = "Inicio de sesión exitoso, se entrega mensaje de bienvenida")
    @ApiResponse(responseCode = "401", description = "Inicio de sesión fallido, se entrega mensaje de error")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO loginDTO) {
        boolean inicioSesion = accesoService.login(loginDTO.getDatoUsuario(), loginDTO.getContrasenia());
        if (inicioSesion) {
            return new ResponseEntity<>("Bienvenido a la manada", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Eres un impostor", HttpStatus.UNAUTHORIZED);
        }
    }
}
