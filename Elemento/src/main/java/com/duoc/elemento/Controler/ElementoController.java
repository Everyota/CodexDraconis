package com.duoc.elemento.Controler;


import com.duoc.elemento.Model.Elemento;
import com.duoc.elemento.Service.ElementoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
