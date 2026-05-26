package com.example.criatura.Controller;

import com.example.criatura.Model.Criatura;
import com.example.criatura.Service.CriaturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/criatura")
public class CriaturaController {

    @Autowired
    private CriaturaService criaturaService;

    @GetMapping
    public ResponseEntity<List<Criatura>> findAll() {
        List<Criatura> criaturas = criaturaService.findAll();
        if (criaturas.isEmpty()) {
            return new ResponseEntity<>(criaturas, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(criaturas, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Criatura> findById(@PathVariable int id) {
        Criatura criatura = criaturaService.findById(id);
        if (criatura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(criatura, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Criatura> create(@RequestBody @Valid Criatura criatura) {
        return ResponseEntity.ok(criaturaService.create(criatura));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Criatura> update(@PathVariable int id, @RequestBody @Valid Criatura criatura) {
        Criatura updated = criaturaService.update(id, criatura);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Criatura> delete(@PathVariable int id) {
        boolean isDeleted = criaturaService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
