package com.duoc.elemento.Controler;


import com.duoc.elemento.Model.Elemento;
import com.duoc.elemento.Service.ElementoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/elementos")
public class ElementoController {
    @Autowired
    private ElementoService elementoService;

    @GetMapping
    public ResponseEntity<List<Elemento>>findAll() {
        List<Elemento> elementos = elementoService.findAll();
        if (elementos.isEmpty()) {
            return new ResponseEntity<>(elementos, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(elementos, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Elemento> findById(@PathVariable int id) {
        Elemento elemento = elementoService.findById(id);
        if (elemento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(elemento, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Elemento> create(@RequestBody @Valid Elemento elemento) {
        return ResponseEntity.ok(elementoService.create(elemento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Elemento> update(@PathVariable int id, @RequestBody @Valid Elemento elemento) {
        Elemento updated = elementoService.update(id, elemento);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Elemento> delete(@PathVariable int id) {
        boolean isDeleted = elementoService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
