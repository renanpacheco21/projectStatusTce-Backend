package com.betha.statustce.statustce.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(schema = "statustce",name = "assunto")
public class Assunto {

    @Column(name="id")
    private Integer id;
    @Column(name="descricao")
    private String descricao;
}
