package com.example.rareza.Controller;

import com.example.rareza.Model.Rareza;
import com.example.rareza.Service.RarezaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rareza")
public class RarezaController {
    @Autowired
    private RarezaService rarezaService;

    @GetMapping
    public ResponseEntity<List<Rareza>> findAll() {
        List<Rareza> rarezas = rarezaService.findAll();
        if (rarezas.isEmpty()) {
            return new ResponseEntity<>(rarezas, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(rarezas, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Rareza> findById(@PathVariable int id) {
        Rareza rareza = rarezaService.findById(id);
        if (rareza == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(rareza, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Rareza> create(@RequestBody @Valid Rareza rareza) {
        return ResponseEntity.ok(rarezaService.create(rareza));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rareza> update(@PathVariable int id, @RequestBody @Valid Rareza rareza) {
        Rareza updated = rarezaService.update(id, rareza);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rareza> delete(@PathVariable int id) {
        boolean isDeleted = rarezaService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
