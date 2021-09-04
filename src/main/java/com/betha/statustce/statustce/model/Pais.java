package com.betha.statustce.statustce.model;

import com.betha.statustce.statustce.enterprise.AbstractRegion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "statustce",name = "pais")
public class Pais extends AbstractRegion {
    @Column(name = "idh")
    private double idh;

    public Pais(){

    }

    public Pais(double idh) { this.idh = idh; }
    public double getIdh() {
        return idh;
    }
    public void setIdh(double idh) {
        this.idh = idh;
    }
}
