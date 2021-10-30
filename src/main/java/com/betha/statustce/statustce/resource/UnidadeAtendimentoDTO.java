package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.UnidadeAtendimento;

public class UnidadeAtendimentoDTO {
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

    public static UnidadeAtendimentoDTO toDTO(UnidadeAtendimento unidadeatendimento)   {
        UnidadeAtendimentoDTO dto = new UnidadeAtendimentoDTO();
        dto.setId(unidadeatendimento.getId());
        dto.setNome(unidadeatendimento.getNome());
        return dto;
    }

    public static UnidadeAtendimento fromDTO(UnidadeAtendimentoDTO dto) {
        UnidadeAtendimento entity = new UnidadeAtendimento();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        return entity;
    }
}
