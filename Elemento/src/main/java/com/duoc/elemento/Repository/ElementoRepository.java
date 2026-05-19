package com.duoc.elemento.Repository;

import com.duoc.elemento.Model.Elemento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementoRepository extends JpaRepository<Elemento, Integer> {

}
