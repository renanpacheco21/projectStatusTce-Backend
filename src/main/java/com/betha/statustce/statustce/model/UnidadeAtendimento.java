package com.betha.statustce.statustce.model;

import javax.persistence.*;

@Table(schema = "statustce",name = "unidade_atendimento")
@Entity
public class UnidadeAtendimento {

    @ManyToOne
    @JoinColumn(name="i_municipio", referencedColumnName = "id")
    private EmpresaAtendimento empresaAtendimento;

    public EmpresaAtendimento getEmpresaAtendimento() {
        return empresaAtendimento;
    }

    public void setEmpresaAtendimento(EmpresaAtendimento empresaAtendimento) {
        this.empresaAtendimento = empresaAtendimento;
    }

    @Id
    @Column(name="id")
    private Long id;
    @Column(name="nome")
    private String nome;

    public UnidadeAtendimento(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UnidadeAtendimento(){

    }
}
