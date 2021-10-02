package com.betha.statustce.statustce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(schema = "statustce",name = "responsavel")
@Entity
public class Responsavel {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="nome")
    private String nome;
    @Column(name="usuarioTce")
    private String usuarioTce;
    @Column(name="senhaTce")
    private String senhaTce;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuarioTce() {
        return usuarioTce;
    }

    public void setUsuarioTce(String usuarioTce) {
        this.usuarioTce = usuarioTce;
    }

    public String getSenhaTce() {
        return senhaTce;
    }

    public void setSenhaTce(String senhaTce) {
        this.senhaTce = senhaTce;
    }

    public Responsavel(){

    }
}

