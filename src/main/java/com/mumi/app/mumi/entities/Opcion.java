package com.mumi.app.mumi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "opcion")
public class Opcion {
    @Id
    @Column(name = "opcion_id")
    private Integer id;
    private boolean selected;
    @ManyToOne
    @JoinColumn(name = "cuestionario_id")
    private Cuestionario cuestionarioId;
    private OpcionEnum opciones;
    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    private Pregunta pregunta;

    public enum OpcionEnum {
        NUNCA(1), A_VECES(2), SIEMPRE(3);

        private final Integer value;

        // NOTE: Enum constructor tiene que estar en privado
        private OpcionEnum(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static OpcionEnum parse(Integer id) {
            OpcionEnum status = null; // Default
            for (OpcionEnum item : OpcionEnum.values()) {
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

   

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public OpcionEnum getOpciones() {
        return opciones;
    }

    public void setOpciones(OpcionEnum opciones) {
        this.opciones = opciones;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Opcion(Integer id, boolean selected, Cuestionario cuestionarioId, OpcionEnum opciones, Pregunta pregunta) {
        this.id = id;
        this.selected = selected;
        this.cuestionarioId = cuestionarioId;
        this.opciones = opciones;
        this.pregunta = pregunta;
    }

    public Opcion() {
    }

    public Cuestionario getCuestionarioId() {
        return cuestionarioId;
    }

    public void setCuestionarioId(Cuestionario cuestionarioId) {
        this.cuestionarioId = cuestionarioId;
    }

}
