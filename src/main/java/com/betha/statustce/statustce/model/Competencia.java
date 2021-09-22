package com.betha.statustce.statustce.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Table(schema = "statustce",name = "competencia")
public class Competencia {

    @Column(name="id")
    private Integer id;
    @Column(name="competencia")
    private String competencia;
    @Column(name="ano")
    private Integer ano;
    @Column(name="dataStatus")
    private Date dataStatus;

    public Competencia(Integer id, String competencia, Integer ano, Date dataStatus) {
        this.id = id;
        this.competencia = competencia;
        this.ano = ano;
        this.dataStatus = dataStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Competencia(){

    }
}
