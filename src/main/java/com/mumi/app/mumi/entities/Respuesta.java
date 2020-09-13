package com.mumi.app.mumi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "respuesta")
public class Respuesta {
    @Id
    @Column(name = "respuesta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer point; // por cada respuesta

    public void puntosOpcion(Integer opcionElegida) {
        switch (opcionElegida) {
            case 1: // Opcion: NUNCA
                setPoint(0);
                break;
            case 2: // Opcion: A_VECES
                setPoint(2);
                break;
            case 3: // Opcion NUNCA
                setPoint(4);
                break;
            default:
                break;
        }

    }

    public Respuesta() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Respuesta(Integer id, Integer point) {
        this.id = id;
        this.point = point;
    }

}
