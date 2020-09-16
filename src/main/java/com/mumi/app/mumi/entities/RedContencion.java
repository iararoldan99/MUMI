package com.mumi.app.mumi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "red_contencion")
public class RedContencion {
    @Id
    @Column(name = "red_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String direccion;
    private Integer numero;
    private String email;
    @Column(name = "sitio_web")
    private String sitioWeb;

    public RedContencion() {

    }

    public RedContencion(Integer id, String nombre, String direccion, Integer numero, String email, String sitioWeb) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numero = numero;
        this.email = email;
        this.sitioWeb = sitioWeb;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

}
