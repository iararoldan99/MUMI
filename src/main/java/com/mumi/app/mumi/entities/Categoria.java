package com.mumi.app.mumi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "categoria") // refiere a la categoria de preguntas: violencia fisica, psico, etc
public class Categoria {
    @Id
    @Column(name = "categoria_id")
    private Integer categoriaId;
    private String nombre;
    // @JsonIgnore
    @ManyToMany
    @JoinTable(name = "pregunta_x_categoria", joinColumns = @JoinColumn(name = "categoria_id"), inverseJoinColumns = @JoinColumn(name = "pregunta_id"))
    private List<Pregunta> preguntas = new ArrayList<>();

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Categoria(Integer categoriaId, String nombre, List<Pregunta> preguntas) {
        this.categoriaId = categoriaId;
        this.nombre = nombre;
        this.preguntas = preguntas;
    }

    public Categoria() {
    }

    public void asignarPregunta(Pregunta pregunta) {
        this.preguntas.add(pregunta);
        pregunta.getCategorias().add(this);
    }

}
