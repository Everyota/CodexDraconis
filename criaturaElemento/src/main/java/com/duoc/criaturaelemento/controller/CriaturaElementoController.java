package com.duoc.criaturaelemento.controller;

import com.duoc.criaturaelemento.model.CriaturaElemento;
import com.duoc.criaturaelemento.service.CriaturaElementoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/criatura-elementos")
public class CriaturaElementoController {
    @Autowired
    private CriaturaElementoService criaturaElementoService;

    @GetMapping
    public ResponseEntity<List<CriaturaElemento>> findAll(){
        List<CriaturaElemento> criaturaElementos = criaturaElementoService.findAll();
        if (criaturaElementos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(criaturaElementos);
        }
    }

    @GetMapping("/elemento/{id}")
    public ResponseEntity<List<CriaturaElemento>> findByElemento(@PathVariable int id) {
        List<CriaturaElemento> criaturaElementos = criaturaElementoService.findByElemento(id);
        if (criaturaElementos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(criaturaElementos);
        }
    }

    @GetMapping("/criatura/{id}")
    public ResponseEntity<List<CriaturaElemento>> findByCriatura(@PathVariable int id) {
        List<CriaturaElemento> criaturaElementos = criaturaElementoService.findByCriatura(id);
        if (criaturaElementos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(criaturaElementos);
        }
    }
    @PostMapping
    public ResponseEntity<CriaturaElemento> create(@RequestBody @Valid CriaturaElemento criaturaElemento) {

        return ResponseEntity.ok(criaturaElementoService.create(criaturaElemento));
    }

    //Las id las va a detectar como distintas aunque estén juntas en el enunciado
    @DeleteMapping("/{idCriatura}/{idElemento}")
    public ResponseEntity<CriaturaElemento> delete(@PathVariable int idCriatura, @PathVariable int idElemento) {
        boolean isDeleted = criaturaElementoService.delete(idElemento, idCriatura);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
