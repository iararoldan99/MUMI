package com.mumi.app.mumi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mumi.app.mumi.entities.Pregunta.TipoPreguntaEnum;
@Entity
@Table(name="resultado")
public class Resultado {
    @Id
    @Column(name="resultado_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private TipoPreguntaEnum tipoPregunta;

    public Resultado() {

    }

    public Resultado(TipoPreguntaEnum tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public TipoPreguntaEnum getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(TipoPreguntaEnum tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
