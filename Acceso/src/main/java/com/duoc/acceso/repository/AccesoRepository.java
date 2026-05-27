package com.duoc.acceso.repository;

import com.duoc.acceso.model.Acceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccesoRepository extends JpaRepository<Acceso, Integer> {
    Optional<Acceso> findByIdUsuario(Integer idUsuario);
}
