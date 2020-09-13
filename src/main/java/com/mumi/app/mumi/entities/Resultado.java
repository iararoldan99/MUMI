package com.mumi.app.mumi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "resultado")
public class Resultado {
    @Id
    @Column(name = "resultado_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "indice_violencia")
    private IndiceViolenciaEnum indiceViolencia;
    @Column(name = "score_final")
    private Integer scoreFinal;
    @OneToOne
    @PrimaryKeyJoinColumn(name="usuaria_id")
    private Usuaria usuariaId;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "cuestionario_id")
    private Cuestionario cuestionarioId;

    public enum IndiceViolenciaEnum {
        LEVE(5), MODERADO(10), GRAVE(20);

        private final Integer value;

        // NOTE: Enum constructor tiene que estar en privado
        private IndiceViolenciaEnum(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static IndiceViolenciaEnum parse(Integer id) {
            IndiceViolenciaEnum status = null; // Default
            for (IndiceViolenciaEnum item : IndiceViolenciaEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

    public enum TipoViolencia {
        FISICA(1), PSICOLOGICA(2), SEXUAL(3), ECONOMICA(4);

        private final Integer value;

        // NOTE: Enum constructor tiene que estar en privado
        private TipoViolencia(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static TipoViolencia parse(Integer id) {
            TipoViolencia status = null; // Default
            for (TipoViolencia item : TipoViolencia.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

    public Resultado() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IndiceViolenciaEnum getIndiceViolencia() {
        return indiceViolencia;
    }

    public void setIndiceViolencia(IndiceViolenciaEnum indiceViolencia) {
        this.indiceViolencia = indiceViolencia;
    }

    public Integer getScoreFinal() {
        return scoreFinal;
    }

    public void setScoreFinal(Integer scoreFinal) {
        this.scoreFinal = scoreFinal;
    }

    public Usuaria getUsuariaId() {
        return usuariaId;
    }

    public void setUsuariaId(Usuaria usuariaId) {
        this.usuariaId = usuariaId;
    }

    public Resultado(Integer id, IndiceViolenciaEnum indiceViolencia, Integer scoreFinal, Usuaria usuariaId,
            Cuestionario cuestionarioId) {
        this.id = id;
        this.indiceViolencia = indiceViolencia;
        this.scoreFinal = scoreFinal;
        this.usuariaId = usuariaId;
        this.cuestionarioId = cuestionarioId;
    }

    public Cuestionario getCuestionarioId() {
        return cuestionarioId;
    }

    public void setCuestionarioId(Cuestionario cuestionarioId) {
        this.cuestionarioId = cuestionarioId;
    }

}
