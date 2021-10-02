package com.betha.statustce.statustce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(schema = "statustce",name = "empresa_atendimento")
@Entity
public class EmpresaAtendimento {

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="nome")
    private String nome;
}
