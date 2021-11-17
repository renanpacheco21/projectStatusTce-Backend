package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.Estado;
import com.betha.statustce.statustce.model.GrupoAssunto;

import javax.persistence.Column;

public class GrupoAssuntoDTO {

    private Long id;
    private String descricao;

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

    public static GrupoAssuntoDTO toDTO(GrupoAssunto grupoAssunto) {
        GrupoAssuntoDTO dto = new GrupoAssuntoDTO();
        dto.setId(grupoAssunto.getId());
        dto.setDescricao(grupoAssunto.getDescricao());
        return dto;
    }

    public static GrupoAssunto fromDTO(GrupoAssuntoDTO dto){
        GrupoAssunto entity = new GrupoAssunto();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
