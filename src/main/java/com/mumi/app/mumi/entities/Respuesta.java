package com.mumi.app.mumi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mumi.app.mumi.entities.Pregunta.TipoPreguntaEnum;

@Entity
@Table(name="respuesta")
public class Respuesta {
    @Id
    @Column(name = "respuesta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String respuesta;
    private Integer score;
    private TipoPreguntaEnum tipoPregunta;
    private TipoRespuestaEnum tipoRespuesta;

    public Respuesta() {

    }

    public enum TipoRespuestaEnum{
        NUNCA(1), 
        A_VECES(2), 
        SIEMPRE(3);

        private final Integer value;

        // NOTE: Enum constructor tiene que estar en privado
        private TipoRespuestaEnum(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static TipoRespuestaEnum parse(Integer id) {
            TipoRespuestaEnum status = null; // Default
            for (TipoRespuestaEnum item : TipoRespuestaEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

    public Respuesta(Integer id, String respuesta, Integer score, TipoPreguntaEnum tipoPregunta) {
        this.id = id;
        this.respuesta = respuesta;
        this.score = score;
        this.tipoPregunta = tipoPregunta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

}
