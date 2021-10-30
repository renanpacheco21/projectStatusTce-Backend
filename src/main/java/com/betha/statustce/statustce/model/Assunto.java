package com.betha.statustce.statustce.model;

import javax.persistence.*;

@Table(schema = "statustce",name = "assunto")
@Entity
public class Assunto {

    @ManyToOne
    @JoinColumn(name="i_grupo_assunto", referencedColumnName = "id")
    private GrupoAssunto grupoAssunto;

    public GrupoAssunto getGrupoAssunto() {
        return grupoAssunto;
    }

    public void setGrupoAssunto(GrupoAssunto grupoAssunto) {
        this.grupoAssunto = grupoAssunto;
    }

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="descricao")
    private String descricao;

    public Assunto(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
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

    public Assunto(){

    }
}
