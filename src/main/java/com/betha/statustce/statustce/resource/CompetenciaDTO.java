package com.betha.statustce.statustce.resource;
import com.betha.statustce.statustce.model.Competencia;
import java.util.Date;

public class CompetenciaDTO {

    private Long id;
    private String competencia;
    private Integer ano;
    private Date dataStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Date getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Date dataStatus) {
        this.dataStatus = dataStatus;
    }

    public static CompetenciaDTO toDTO(Competencia competencia) {
        CompetenciaDTO dto = new CompetenciaDTO();
        dto.setId(competencia.getId());
        dto.setCompetencia(competencia.getCompetencia());
        dto.setAno(competencia.getAno());
        dto.setDataStatus(competencia.getDataStatus());
        return dto;
    }

    public static Competencia fromDTO(CompetenciaDTO dto){
        Competencia entity = new Competencia();
        entity.setId(dto.getId());
        entity.setCompetencia(dto.getCompetencia());
        entity.setAno(dto.getAno());
        entity.setDataStatus(dto.getDataStatus());
        return entity;
    }
}