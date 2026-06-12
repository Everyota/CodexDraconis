package com.duoc.favorito.Controller;


import com.duoc.favorito.Model.Favorito;
import com.duoc.favorito.Repository.FavoritoRepository;
import com.duoc.favorito.Service.FavoritoService;
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
@RequestMapping ("/api/v1/favoritos")
@Tag(name = "API Favoritos", description = "API para la gestion de favoritos")
public class FavoritoController {

   @Autowired
    private FavoritoService favoritoService;

   @GetMapping
   @Operation(summary = "Obtener todos los favoritos", description = "Endpoint permite consultar todos los favoritos")
   @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega la lista de favoritos")
   @ApiResponse(responseCode = "204", description = "Consulta exitosa , pero no se encontraron datos")
   public ResponseEntity<List<Favorito>> findAll(){
       List<Favorito> favoritos = favoritoService.findAll();
       if (favoritos.isEmpty()) {
           return ResponseEntity.noContent().build();
       } else {
           return ResponseEntity.ok(favoritos);
       }
   }

   @GetMapping("/usuario/{id}")
   @Operation(summary = "Obtiene favorito segun su ID")
   @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega el favorito")
   @ApiResponse(responseCode = "404", description = "Favorito no encontrado")
    public ResponseEntity<List<Favorito>> findByUsuario(@Parameter(description = "ID del favorito a consultar") @PathVariable Long id) {
        List<Favorito> favoritos = favoritoService.findByUsuario(id);
        if (favoritos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(favoritos);
        }
    }

    @GetMapping("/criatura/{id}")
    @Operation(summary = "Obtiene favorito segun su ID")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa , se entrega el favorito")
    @ApiResponse(responseCode = "404", description = "Favorito no encontrado")
    public ResponseEntity<List<Favorito>> findByCriatura(@PathVariable Long id) {
        List<Favorito> favoritos = favoritoService.findByCriatura(id);
        if (favoritos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(favoritos);
        }
    }
    @PostMapping
    @Operation(summary = "Crea un nuevo favorito", description = "Endpoint permite crear un nuevo favorito")
    @ApiResponse(responseCode = "200", description = "Favorito creado exitosamente")
    public ResponseEntity<Favorito> create(@RequestBody @Valid Favorito favorito) {

            return ResponseEntity.ok(favoritoService.create(favorito));
        }

        //Las id las va a detectar como distintas aunque estén juntas en el enunciado
    @DeleteMapping("/{idUsuario}/{idCriatura}")
    @Operation(summary = "Permite eliminar la relación entre un usuario y una criatura", description = "Endpoint para eliminar una relacion entre usuario y criatura")
    @ApiResponse(responseCode = "200", description = "Relación usuario con criatura eliminada con exito en el sistema ")
    @ApiResponse(responseCode = "404", description = "Relación usuario con criatura no encontrada")
    public ResponseEntity<Favorito> delete(@PathVariable int idUsuario, @PathVariable int idCriatura) {
        boolean isDeleted = favoritoService.delete(idUsuario, idCriatura);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
