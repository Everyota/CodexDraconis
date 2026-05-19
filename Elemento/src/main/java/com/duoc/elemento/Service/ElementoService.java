package com.duoc.elemento.Service;

import com.duoc.elemento.Model.Elemento;
import com.duoc.elemento.Repository.ElementoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementoService {
    @Autowired
    private ElementoRepository elementoRepository;

    public List<Elemento> findAll() {
        return elementoRepository.findAll();
    }
}
