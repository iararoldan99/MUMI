package com.mumi.app.mumi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuaria")
public class Usuaria {
    @Id
    @Column(name="usuaria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

}
