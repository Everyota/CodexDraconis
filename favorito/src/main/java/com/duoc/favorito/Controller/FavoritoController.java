package com.duoc.favorito.Controller;


import com.duoc.favorito.Model.Favorito;
import com.duoc.favorito.Repository.FavoritoRepository;
import com.duoc.favorito.Service.FavoritoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/favoritos")
public class FavoritoController {

   @Autowired
    private FavoritoService favoritoService;

   @GetMapping
   public ResponseEntity<List<Favorito>> findAll(){
       List<Favorito> favoritos = favoritoService.findAll();
       if (favoritos.isEmpty()) {
           return ResponseEntity.noContent().build();
       } else {
           return ResponseEntity.ok(favoritos);
       }
   }

   @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Favorito>> findByUsuario(@PathVariable Long id) {
        List<Favorito> favoritos = favoritoService.findByUsuario(id);
        if (favoritos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(favoritos);
        }
    }

    @GetMapping("/criatura/{id}")
    public ResponseEntity<List<Favorito>> findByCriatura(@PathVariable Long id) {
        List<Favorito> favoritos = favoritoService.findByCriatura(id);
        if (favoritos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(favoritos);
        }
    }
    @PostMapping
    public ResponseEntity<Favorito> create(@RequestBody @Valid Favorito favorito) {

            return ResponseEntity.ok(favoritoService.create(favorito));
        }

        //Las id las va a detectar como distintas aunque estén juntas en el enunciado
    @DeleteMapping("/{idUsuario}/{idCriatura}")
    public ResponseEntity<Favorito> delete(@PathVariable int idUsuario, @PathVariable int idCriatura) {
        boolean isDeleted = favoritoService.delete(idUsuario, idCriatura);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
