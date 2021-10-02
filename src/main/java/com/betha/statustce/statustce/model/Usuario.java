package com.betha.statustce.statustce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(schema = "statustce",name = "usuario")
@Entity
public class Usuario {

    @Id
    @Column (name="usuario")
    private String login;
    @Column (name="senha")
    private String senha;
}
