package com.betha.statustce.statustce.model;

import javax.persistence.*;

@Table(schema = "statustce",name = "entidade_tce")
@Entity
public class EntidadeTCE {

    @ManyToOne
    @JoinColumn(name="i_municipio", referencedColumnName = "id")
    private Municipio municipio;

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="nome")
    private String nome;
    @Column(name="cnpj")
    private String cnpj;

    public EntidadeTCE(Integer id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public EntidadeTCE(){

    }
}
