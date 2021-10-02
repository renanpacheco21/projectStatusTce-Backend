package com.betha.statustce.statustce.repository;

import com.betha.statustce.statustce.model.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Competencia, Long> {

}