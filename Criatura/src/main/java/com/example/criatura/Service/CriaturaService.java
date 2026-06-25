package com.example.criatura.Service;

import com.example.criatura.Client.RarezaClient;
import com.example.criatura.Client.TipoCriaturaClient;
import com.example.criatura.DTO.CriaturaDTO;
import com.example.criatura.DTO.RarezaDTO;
import com.example.criatura.DTO.TipoCriaturaDTO;
import com.example.criatura.Model.Criatura;
import com.example.criatura.Repository.CriaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class CriaturaService {
    @Autowired
    private CriaturaRepository criaturaRepository;
    @Autowired
    private TipoCriaturaClient tipoCriaturaClient;
    @Autowired
    private RarezaClient rarezaClient;

    public List<Criatura> findAll() {
        return criaturaRepository.findAll();
    }

    public Criatura findById(int id) {
        return criaturaRepository.findById(id).orElse(null);
    }

    public CriaturaDTO findByIdFull(int id) {
        Criatura criatura = findById(id);
        if (criatura != null) {
            try {
                TipoCriaturaDTO tipoCriatura = tipoCriaturaClient.getTipoCriatura(criatura.getIdTipoCriatura());
                RarezaDTO rareza = rarezaClient.getRareza(criatura.getIdRareza());
                CriaturaDTO criaturaDTO = new CriaturaDTO();
                criaturaDTO.setId(criatura.getId());
                criaturaDTO.setNombreCriatura(criatura.getNombreCriatura());
                criaturaDTO.setDescripcion(criatura.getDescripcion());
                criaturaDTO.setTipoCriatura(tipoCriatura);
                criaturaDTO.setRareza(rareza);

                return criaturaDTO;
            } catch (Exception e) {
                System.out.println("Error al obtener datos relacionados: " + e.getMessage());
            }
        }

        return null;
    }

    public Criatura create(Criatura criatura) {
        return criaturaRepository.save(criatura);
    }

    public Criatura update(int id, Criatura criatura) {
        Criatura buscado = findById(id);
        if (buscado != null) {
            buscado.setIdTipoCriatura(criatura.getIdTipoCriatura());
            buscado.setIdRareza(criatura.getIdRareza());
            buscado.setIdUsuarioCreador(criatura.getIdUsuarioCreador());
            buscado.setNombreCriatura(criatura.getNombreCriatura());
            buscado.setDescripcion(criatura.getDescripcion());
            buscado.setOrigenLeyenda(criatura.getOrigenLeyenda());
            buscado.setNivelPeligro(criatura.getNivelPeligro());
            buscado.setAlturaMetros(criatura.getAlturaMetros());
            buscado.setPesoKg(criatura.getPesoKg());
            buscado.setImagenCriatura(criatura.getImagenCriatura());
            buscado.setEstadoRegistro(criatura.getEstadoRegistro());
            return criaturaRepository.save(buscado);
        } else {
            return null;
        }
    }

    public boolean delete(int id) {
        Criatura buscado = findById(id);
        if (buscado != null) {
            criaturaRepository.delete(buscado);
            return true;
        } else {
            return false;
        }
    }

    public List<Criatura> findByTipoCriatura(int idTipoCriatura) {
        return criaturaRepository.findByIdTipoCriatura(idTipoCriatura);
    }

    public List<Criatura> findByIdRareza(int idRareza){
        return criaturaRepository.findByIdRareza(idRareza);
    }
}
