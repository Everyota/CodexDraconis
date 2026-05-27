package com.duoc.criaturaelemento.repository;

import com.duoc.criaturaelemento.model.CriaturaElemento;
import com.duoc.criaturaelemento.model.CriaturaElementoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriaturaElementoRepository extends JpaRepository<CriaturaElemento, CriaturaElementoId> {
    // Encuentra los ids de los elementos que tiene una criatura
    List<CriaturaElemento> findByIdIdCriatura(Integer idCriatura);
    // Encuentra los ids de las criaturas que tienen un elemento
    List<CriaturaElemento> findByIdIdElemento(Integer idElemento);
}
