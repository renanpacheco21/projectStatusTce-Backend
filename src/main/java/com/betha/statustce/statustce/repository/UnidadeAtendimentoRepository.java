package com.betha.statustce.statustce.repository;

import com.betha.statustce.statustce.model.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeAtendimentoRepository extends JpaRepository<Competencia, Long> {

}