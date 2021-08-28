package com.betha.statustce.statustce.repository;

import com.betha.statustce.statustce.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository <Pais, Long> {

}
