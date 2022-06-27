package com.betha.statustce.statustce.model;

import javax.persistence.*;

@Table(schema = "ma = \"statustce\",naassunto")
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
    private Long id;
    @Column(name="descricao")
    private String descricao;

    public Assunto(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
