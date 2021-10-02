package com.betha.statustce.statustce.model;


import javax.persistence.*;

@Table(schema = "statustce",name = "situacao_entidade")
@Entity
public class SituacaoEntidade {

    @ManyToOne
    @JoinColumn(name="i_entidade", referencedColumnName = "id")
    private EntidadeTCE entidadeTCE;

    public EntidadeTCE getEntidadeTCE() {
        return entidadeTCE;
    }

    public void setEntidadeTCE(EntidadeTCE entidadeTCE) {

        this.entidadeTCE = entidadeTCE;
    }


    @Id
    @Column(name="id")
    private Integer id;

    public SituacaoEntidade(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
