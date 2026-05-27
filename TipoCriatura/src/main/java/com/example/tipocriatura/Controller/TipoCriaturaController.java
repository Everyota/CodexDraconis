package com.example.tipocriatura.Controller;

import com.example.tipocriatura.Model.TipoCriatura;
import com.example.tipocriatura.Service.TipoCriaturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipo-criatura")
public class TipoCriaturaController {
    @Autowired
    private TipoCriaturaService tipoCriaturaService;

    @GetMapping
    public ResponseEntity<List<TipoCriatura>> findAll() {
        List<TipoCriatura> tipoCriaturas = tipoCriaturaService.findAll();
        if (tipoCriaturas.isEmpty()) {
            return new ResponseEntity<>(tipoCriaturas, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(tipoCriaturas, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCriatura> findById(@PathVariable int id) {
        TipoCriatura tipoCriatura = tipoCriaturaService.findById(id);
        if (tipoCriatura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(tipoCriatura, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<TipoCriatura> create(@RequestBody @Valid TipoCriatura tipoCriatura) {
        return ResponseEntity.ok(tipoCriaturaService.create(tipoCriatura));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoCriatura> update(@PathVariable int id, @RequestBody @Valid TipoCriatura tipoCriatura) {
        TipoCriatura updated = tipoCriaturaService.update(id, tipoCriatura);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoCriatura> delete(@PathVariable int id) {
        boolean isDeleted = tipoCriaturaService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
