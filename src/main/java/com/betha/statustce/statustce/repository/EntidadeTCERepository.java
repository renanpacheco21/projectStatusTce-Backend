package com.betha.statustce.statustce.repository;

import com.betha.statustce.statustce.model.Competencia;
import com.betha.statustce.statustce.model.EntidadeTCE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadeTCERepository extends JpaRepository<EntidadeTCE, Long> , QuerydslPredicateExecutor<EntidadeTCERepository> {

}