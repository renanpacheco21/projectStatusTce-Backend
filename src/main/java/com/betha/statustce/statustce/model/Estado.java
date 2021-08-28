package com.betha.statustce.statustce.model;

import com.betha.statustce.statustce.enterprise.AbstractRegion;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "statustce",name = "estado")
public class Estado extends AbstractRegion {
    @ManyToOne
    @JoinColumn(name="i_paises", referencedColumnName = "id")
    private Pais pais;

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}