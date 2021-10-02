package com.betha.statustce.statustce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(schema = "statustce",name = "entidade_tce")
@Entity
public class EntidadeTCE {

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="nome")
    private String nome;
    @Column(name="cnpj")
    private String cnpj;
}
