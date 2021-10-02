package com.betha.statustce.statustce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(schema = "statustce",name = "status")
@Entity
public class Status {

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="descricao")
    private String descricao;

    public Status(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status(){

    }
}
