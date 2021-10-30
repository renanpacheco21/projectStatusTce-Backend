package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.Assunto;

public class AssuntoDTO {

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

    public static AssuntoDTO toDTO(Assunto assunto){
        AssuntoDTO dto = new AssuntoDTO();
        dto.setId(assunto.getId());
        dto.setDescricao(assunto.getDescricao());
        return dto;
    }

    public static Assunto fromDTO(AssuntoDTO dto){
        Assunto entity = new Assunto();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
