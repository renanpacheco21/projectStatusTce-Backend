package com.betha.statustce.statustce.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(schema = "statustce",name = "entidadetce")
public class EntidadeTCE {

    @Column(name="id")
    private Integer id;
    @Column(name="nome")
    private String nome;
    @Column(name="cnpj")
    private String cnpj;
}
