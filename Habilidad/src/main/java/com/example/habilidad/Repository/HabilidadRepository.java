package com.example.habilidad.Repository;

import com.example.habilidad.Model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository <Habilidad, Integer> {

}
