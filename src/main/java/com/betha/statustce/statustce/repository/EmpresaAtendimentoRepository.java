package com.betha.statustce.statustce.repository;


import com.betha.statustce.statustce.model.Competencia;
import com.betha.statustce.statustce.model.EmpresaAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpresaAtendimentoRepository extends JpaRepository<Competencia, Long> , QuerydslPredicateExecutor<EmpresaAtendimento> {

}