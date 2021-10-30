package com.betha.statustce.statustce.repository;


import com.betha.statustce.statustce.model.Competencia;
import com.betha.statustce.statustce.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StatusRepository extends JpaRepository<Status, Long> , QuerydslPredicateExecutor<Status> {

}