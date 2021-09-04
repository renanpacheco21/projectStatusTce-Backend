package com.betha.statustce.statustce.model;

import com.betha.statustce.statustce.enterprise.AbstractRegion;

public class Estado extends AbstractRegion {

    private Pais pais;

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
