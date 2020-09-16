package com.mumi.app.mumi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "usuaria")
public class Usuaria {
    @Id
    @Column(name = "usuaria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "cuestionario_id")
    private Cuestionario cuestionarioId;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "resultado_id")
    private Resultado resultadoId;

    public Usuaria() {

    }

    public Usuaria(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cuestionario getCuestionarioId() {
        return cuestionarioId;
    }

    public void setCuestionarioId(Cuestionario cuestionarioId) {
        this.cuestionarioId = cuestionarioId;
    }

    public Resultado getResultadoId() {
        return resultadoId;
    }

    public void setResultadoId(Resultado resultadoId) {
        this.resultadoId = resultadoId;
    }

    public Usuaria(Integer id, Cuestionario cuestionarioId, Resultado resultadoId) {
        this.id = id;
        this.cuestionarioId = cuestionarioId;
        this.resultadoId = resultadoId;
    }

}
