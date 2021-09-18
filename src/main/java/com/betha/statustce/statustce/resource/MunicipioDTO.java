package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.Municipio;

public class MunicipioDTO {

    private Long id;
    private String nome;
    private  String populacao;

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

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    public static MunicipioDTO toDTO(Municipio municipio) {
        MunicipioDTO dto = new MunicipioDTO();
        dto.setId(municipio.getId());
        dto.setNome(municipio.getNome());
        dto.setPopulacao(municipio.getPopulacao());
        return dto;
    }

    public static Municipio fromDTO(MunicipioDTO dto){
        Municipio entity = new Municipio();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setPopulacao(dto.getPopulacao());
        return entity;
    }
}