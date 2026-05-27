package com.example.habilidad.Controller;

import com.example.habilidad.Model.Habilidad;
import com.example.habilidad.Service.HabilidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/habilidad")
public class HabilidadController {
    @Autowired
    private HabilidadService habilidadService;

    @GetMapping
    public ResponseEntity<List<Habilidad>> findAll() {
        List<Habilidad> habilidads = habilidadService.findAll();
        if (habilidads.isEmpty()) {
            return new ResponseEntity<>(habilidads, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(habilidads, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidad> findById(@PathVariable int id) {
        Habilidad habilidad = habilidadService.findById(id);
        if (habilidad == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(habilidad, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Habilidad> create(@RequestBody @Valid Habilidad habilidad) {
        return ResponseEntity.ok(habilidadService.create(habilidad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habilidad> update(@PathVariable int id, @RequestBody @Valid Habilidad habilidad) {
        Habilidad updated = habilidadService.update(id, habilidad);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Habilidad> delete(@PathVariable int id) {
        boolean isDeleted = habilidadService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
