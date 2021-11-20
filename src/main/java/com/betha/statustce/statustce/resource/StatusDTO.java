package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.Estado;
import com.betha.statustce.statustce.model.Status;

import javax.persistence.Column;

public class StatusDTO {

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

    public static StatusDTO toDTO(Status status) {
        StatusDTO dto = new StatusDTO();
        dto.setId(status.getId());
        dto.setDescricao(status.getDescricao());
        return dto;
    }

    public static Status fromDTO(StatusDTO dto){
        Status entity = new Status();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        return entity;
    }

}
