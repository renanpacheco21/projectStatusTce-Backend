package com.betha.statustce.statustce.model;
import javax.persistence.*;
import java.util.Date;

@Table(schema = "statustce",name = "competencia")
@Entity
public class Competencia {

    @ManyToOne
    @JoinColumn(name = "i_status", referencedColumnName = "id")

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Id
    @Column(name="id")
    private Long id;
    @Column(name="competencia")
    private String competencia;
    @Column(name="ano")
    private Integer ano;
    @Column(name="dataStatus")
    private Date dataStatus;


    public Competencia(Long id, String competencia, Integer ano, Date dataStatus) {
        this.id = id;
        this.competencia = competencia;
        this.ano = ano;
        this.dataStatus = dataStatus;
    }

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

    public Competencia(){

    }
}
