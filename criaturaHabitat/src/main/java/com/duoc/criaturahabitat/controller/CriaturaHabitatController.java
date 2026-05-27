package com.duoc.criaturahabitat.controller;

import com.duoc.criaturahabitat.model.CriaturaHabitat;
import com.duoc.criaturahabitat.service.CriaturaHabitatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/criatura-habitats")
public class CriaturaHabitatController {
    @Autowired
    private CriaturaHabitatService criaturaHabitatService;

    @GetMapping
    public ResponseEntity<List<CriaturaHabitat>> findAll(){
        List<CriaturaHabitat> criaturaHabitats = criaturaHabitatService.findAll();
        if (criaturaHabitats.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(criaturaHabitats);
        }
    }

    @GetMapping("/habitat/{id}")
    public ResponseEntity<List<CriaturaHabitat>> findByHabitat(@PathVariable int id) {
        List<CriaturaHabitat> criaturaHabitats = criaturaHabitatService.findByHabitat(id);
        if (criaturaHabitats.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(criaturaHabitats);
        }
    }

    @GetMapping("/criatura/{id}")
    public ResponseEntity<List<CriaturaHabitat>> findByCriatura(@PathVariable int id) {
        List<CriaturaHabitat> criaturaHabitats = criaturaHabitatService.findByCriatura(id);
        if (criaturaHabitats.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(criaturaHabitats);
        }
    }
    @PostMapping
    public ResponseEntity<CriaturaHabitat> create(@RequestBody @Valid CriaturaHabitat criaturaHabitat) {

        return ResponseEntity.ok(criaturaHabitatService.create(criaturaHabitat));
    }

    //Las id las va a detectar como distintas aunque estén juntas en el enunciado
    @DeleteMapping("/{idCriatura}/{idHabitat}")
    public ResponseEntity<CriaturaHabitat> delete(@PathVariable int idCriatura, @PathVariable int idHabitat) {
        boolean isDeleted = criaturaHabitatService.delete(idHabitat, idCriatura);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
