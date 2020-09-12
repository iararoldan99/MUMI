package com.mumi.app.mumi.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mumi.app.mumi.entities.Pregunta.TipoPreguntaEnum;
import com.mumi.app.mumi.entities.Respuesta.TipoRespuestaEnum;

@Entity
@Table(name = "cuestionario")
public class Cuestionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "tipo_pregunta")
    private TipoPreguntaEnum tipoPregunta;
    @Column(name = "tipo_respuesta")
    private TipoRespuestaEnum tipoRespuesta;
    private Integer score;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
    private List<Pregunta> pregunta; 


    public Cuestionario() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoPreguntaEnum getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(TipoPreguntaEnum tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public TipoRespuestaEnum getTipoRespuesta() {
        return tipoRespuesta;
    }

    public void setTipoRespuesta(TipoRespuestaEnum tipoRespuesta) {
        this.tipoRespuesta = tipoRespuesta;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Cuestionario(Integer id, TipoPreguntaEnum tipoPregunta, TipoRespuestaEnum tipoRespuesta, Integer score) {
        this.id = id;
        this.tipoPregunta = tipoPregunta;
        this.tipoRespuesta = tipoRespuesta;
        this.score = score;
    }

    public List<Pregunta> getPregunta() {
        return pregunta;
    }

    public void setPregunta(List<Pregunta> pregunta) {
        this.pregunta = pregunta;
    }

   

}
