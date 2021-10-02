package com.betha.statustce.statustce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(schema = "statustce",name = "unidade_atendimento")
@Entity
public class UnidadeAtendimento {

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="nome")
    private String nome;
}
