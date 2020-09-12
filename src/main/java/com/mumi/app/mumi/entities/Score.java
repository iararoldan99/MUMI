package com.mumi.app.mumi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mumi.app.mumi.entities.Pregunta.TipoPreguntaEnum;
@Entity
@Table(name="score")
public class Score {
    @Id
    @Column(name="score_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="indice_violencia")
    private IndiceViolenciaEnum indice;
    @Column(name="tipo_pregunta")
    private TipoPreguntaEnum tipoPregunta; 
    private String pregunta;
    private String respuesta; 

    //TODO: agregar numeros
    public enum IndiceViolenciaEnum {
        LEVE, MODERADO, GRAVE
    } 

    public IndiceViolenciaEnum getIndice() {
        return indice;
    }

    public void setIndice(IndiceViolenciaEnum indice) {
        this.indice = indice;
    }

    public TipoPreguntaEnum getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(TipoPreguntaEnum tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    

    
   
}
