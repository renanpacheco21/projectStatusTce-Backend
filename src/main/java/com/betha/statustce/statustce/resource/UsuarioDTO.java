package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.Assunto;
import com.betha.statustce.statustce.model.Usuario;

import javax.persistence.Column;

public class UsuarioDTO {

    private Long id;
    private String login;
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setLogin(usuario.getLogin());
        dto.setSenha(usuario.getSenha());
        return dto;
    }

    public static Usuario fromDTO(UsuarioDTO dto){
        Usuario entity = new Usuario();
        entity.setId(dto.getId());
        entity.setLogin(dto.getLogin());
        entity.setSenha(dto.getSenha());
        return entity;
    }
}
