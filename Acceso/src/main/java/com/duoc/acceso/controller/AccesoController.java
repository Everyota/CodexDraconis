package com.duoc.acceso.controller;

import com.duoc.acceso.model.Acceso;
import com.duoc.acceso.service.AccesoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accesos")
public class AccesoController {
    @Autowired
    private AccesoService accesoService;

    @GetMapping
    public ResponseEntity<List<Acceso>> findAll() {
        List<Acceso> accesos = accesoService.findAll();
        if (accesos.isEmpty()) {
            return new ResponseEntity<>(accesos, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(accesos, HttpStatus.OK); 
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Acceso> findById(@PathVariable int id) {
        Acceso Acceso = accesoService.findById(id);
        if (Acceso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(Acceso, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Acceso> create(@RequestBody @Valid Acceso Acceso) {
        return ResponseEntity.ok(accesoService.create(Acceso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acceso> update(@PathVariable int id, @RequestBody @Valid Acceso Acceso) {
        Acceso updated = accesoService.update(id, Acceso);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Acceso> delete(@PathVariable int id) {
        boolean isDeleted = accesoService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
