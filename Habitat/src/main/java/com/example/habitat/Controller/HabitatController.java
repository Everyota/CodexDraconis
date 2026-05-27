package com.example.habitat.Controller;

import com.example.habitat.Model.Habitat;
import com.example.habitat.Service.HabitatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/habitat")
public class HabitatController {
    @Autowired
    private HabitatService habitatService;

    @GetMapping
    public ResponseEntity<List<Habitat>> findAll() {
        List<Habitat> habitats = habitatService.findAll();
        if (habitats.isEmpty()) {
            return new ResponseEntity<>(habitats, HttpStatus.NO_CONTENT);
        }else  {
            return new ResponseEntity<>(habitats, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitat> findById(@PathVariable int id) {
        Habitat habitat = habitatService.findById(id);
        if (habitat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(habitat, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Habitat> create(@RequestBody @Valid Habitat habitat) {
        return ResponseEntity.ok(habitatService.create(habitat));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitat> update(@PathVariable int id, @RequestBody @Valid Habitat habitat) {
        Habitat updated = habitatService.update(id, habitat);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Habitat> delete(@PathVariable int id) {
        boolean isDeleted = habitatService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
