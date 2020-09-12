package com.mumi.app.mumi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pregunta")
public class Pregunta {
    @Id
    @Column(name="pregunta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pregunta;
    //private List<String> preguntas;
    @Column(name="tipo_pregunta")
    private TipoPreguntaEnum tipoPregunta;
    //@Column(name="tipo_pregunta_id")
    //private Integer tipoPreguntaId; 

    public enum TipoPreguntaEnum {
        VIOLENCIA_FISICA(1), VIOLENCIA_PSICO(2), VIOLENCIA_SEXUAL(3), VIOLENCIA_ECO(4);

        private final Integer value;

        // NOTE: Enum constructor tiene que estar en privado
        private TipoPreguntaEnum(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static TipoPreguntaEnum parse(Integer id) {
            TipoPreguntaEnum status = null; // Default
            for (TipoPreguntaEnum item : TipoPreguntaEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }

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

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }



}
