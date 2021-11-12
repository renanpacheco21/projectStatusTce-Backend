package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.Assunto;
import com.betha.statustce.statustce.model.EmpresaAtendimento;

import javax.persistence.Column;

public class EmpresaAtendimentoDTO {

    private Long id;
    private String nome;

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

    public static EmpresaAtendimentoDTO toDTO(EmpresaAtendimento empresaAtendimento){
        EmpresaAtendimentoDTO dto = new EmpresaAtendimentoDTO();
        dto.setId(empresaAtendimento.getId());
        dto.setNome(empresaAtendimento.getNome());
        return dto;
    }

    public static EmpresaAtendimento fromDTO(EmpresaAtendimentoDTO dto){
        EmpresaAtendimento entity = new EmpresaAtendimento();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        return entity;
    }
}