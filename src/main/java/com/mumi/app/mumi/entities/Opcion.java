package com.mumi.app.mumi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "opcion")
public class Opcion {
    @Id
    @Column(name = "opcion_id")
    private Integer id;
    private String opcion;

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

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Opcion(Integer id, String opcion) {
        this.id = id;
        this.opcion = opcion;
    }

    public Opcion() {

    }

}
