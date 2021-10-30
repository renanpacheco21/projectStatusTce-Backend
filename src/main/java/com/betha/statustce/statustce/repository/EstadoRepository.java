package com.betha.statustce.statustce.repository;


import com.betha.statustce.statustce.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> , QuerydslPredicateExecutor<Estado> {

}
