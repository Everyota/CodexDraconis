package com.duoc.criaturahabitat.repository;

import com.duoc.criaturahabitat.model.CriaturaHabitat;
import com.duoc.criaturahabitat.model.CriaturaHabitatId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriaturaHabitatRepository extends JpaRepository<CriaturaHabitat, CriaturaHabitatId> {
    // Encuentra los ids de los habitats que tiene una criatura
    List<CriaturaHabitat> findByIdIdCriatura(Integer idCriatura);
    // Encuentra los ids de las criaturas que viven en un habitat
    List<CriaturaHabitat> findByIdIdHabitat(Integer idHabitat);
}
