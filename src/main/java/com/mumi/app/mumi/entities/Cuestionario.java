package com.mumi.app.mumi.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.mumi.app.mumi.entities.Pregunta.TipoPreguntaEnum;

@Entity
@Table(name = "cuestionario")
public class Cuestionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cuestionario_id")
    private Integer id;
    @Column(name = "tipo_pregunta")
    private TipoPreguntaEnum tipoPregunta;
    @Column(name = "tipo_respuesta")

    @OneToMany(mappedBy = "cuestionarioId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pregunta> preguntas;

    @OneToMany(mappedBy = "cuestionarioId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Opcion> opciones;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name="usuaria_id")
    private Usuaria usuariaId;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name= "resultado_id")
    private Resultado resultado;

    // UN CUESTIONARIO TIENE UNA UNICA USUARIA Y VICEVERSA
    // un cuestionario tiene una lista de preguntas (onetomany)
    // una pregunta tiene una lista de opciones (onetomany)
    // una opcion tiene una sola respuesta boolean selected;
    // una respuesta tiene un punto (integer)
    // un score es una sumatoria de puntos
    // un score tiene un resultado
    // un resultado es: la suma de puntos totales (un score total) + indice
    // de violencia correspondiente a ese score + tipo de violencia correspondiente
    // a las preguntas respondidas

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

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }

    public Usuaria getUsuariaId() {
        return usuariaId;
    }

    public void setUsuariaId(Usuaria usuariaId) {
        this.usuariaId = usuariaId;
    }

    public Cuestionario(Integer id, TipoPreguntaEnum tipoPregunta, List<Pregunta> preguntas, List<Opcion> opciones,
            Usuaria usuariaId) {
        this.id = id;
        this.tipoPregunta = tipoPregunta;
        this.preguntas = preguntas;
        this.opciones = opciones;
        this.usuariaId = usuariaId;
    }

}
