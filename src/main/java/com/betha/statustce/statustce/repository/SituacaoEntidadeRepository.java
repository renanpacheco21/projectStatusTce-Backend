package com.betha.statustce.statustce.repository;

import com.betha.statustce.statustce.model.SituacaoEntidade;
import com.betha.statustce.statustce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoEntidadeRepository extends JpaRepository<SituacaoEntidade, Long>, QuerydslPredicateExecutor<SituacaoEntidade> {
}
