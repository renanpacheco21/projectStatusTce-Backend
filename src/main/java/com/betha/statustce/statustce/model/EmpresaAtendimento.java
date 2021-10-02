package com.betha.statustce.statustce.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(schema = "statustce",name = "empresa_atendimento")
public class EmpresaAtendimento {

    @Column(name="id")
    private Integer id;
    @Column(name="nome")
    private String nome;
}
