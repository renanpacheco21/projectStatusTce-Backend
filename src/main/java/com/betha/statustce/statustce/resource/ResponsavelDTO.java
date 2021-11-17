package com.betha.statustce.statustce.resource;
import com.betha.statustce.statustce.model.Responsavel;
import javax.persistence.Column;

public class ResponsavelDTO {

    private Long id;
    private String nome;
    private String usuarioTce;
    private String senhaTce;

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

    public String getUsuarioTce() {
        return usuarioTce;
    }

    public void setUsuarioTce(String usuarioTce) {
        this.usuarioTce = usuarioTce;
    }

    public String getSenhaTce() {
        return senhaTce;
    }

    public void setSenhaTce(String senhaTce) {
        this.senhaTce = senhaTce;
    }

    public static ResponsavelDTO toDTO(Responsavel responsavel) {
        ResponsavelDTO dto = new ResponsavelDTO();
        dto.setId(responsavel.getId());
        dto.setNome(responsavel.getNome());
        dto.setSenhaTce(responsavel.getUsuarioTce());
        dto.setSenhaTce(responsavel.getSenhaTce());
        return dto;
    }

    public static Responsavel fromDTO(ResponsavelDTO dto){
        Responsavel entity = new Responsavel();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setUsuarioTce(dto.getUsuarioTce());
        entity.setSenhaTce(dto.getSenhaTce());
        return entity;
    }
}
