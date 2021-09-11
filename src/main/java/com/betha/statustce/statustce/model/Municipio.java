package com.betha.statustce.statustce.model;

import com.betha.statustce.statustce.enterprise.AbstractRegion;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "statustce",name = "municipio")
public class Municipio extends AbstractRegion {

    @ManyToOne
    @JoinColumn(name="i_estado", referencedColumnName = "id")
    private Municipio municipio;

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Estado estado) {
        this.municipio = municipio;
    }
}