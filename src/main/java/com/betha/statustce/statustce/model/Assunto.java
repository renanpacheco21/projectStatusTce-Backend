package com.betha.statustce.statustce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(schema = "statustce",name = "assunto")
@Entity
public class Assunto {

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="descricao")
    private String descricao;
}
