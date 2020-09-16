package com.mumi.app.mumi.entities;

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
    @Column(name = "indice_violencia_id")
    private Integer indiceViolenciaId;
    @Column(name = "indice_violencia")
    private String indiceViolencia;
    @Column(name = "tipo_violencia_id")
    private Integer tipoViolenciaId;
    @Column(name = "tipo_violencia")
    private String tipoViolencia;
    @Column(name = "score_final")
    private Integer scoreFinal;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "usuaria_id")
    private Usuaria usuariaId;

    public enum IndiceViolenciaEnum {
        LEVE(1), MODERADO(2), GRAVE(3); // no son Indices, son Ids

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

    public Integer getIndiceViolenciaId() {
        return indiceViolenciaId;
    }

    public void setIndiceViolenciaId(Integer indiceViolenciaId) {
        this.indiceViolenciaId = indiceViolenciaId;
    }

    public String getIndiceViolencia() {
        return indiceViolencia;
    }

    public void setIndiceViolencia(String indiceViolencia) {
        this.indiceViolencia = indiceViolencia;
    }

    public Integer getTipoViolenciaId() {
        return tipoViolenciaId;
    }

    public void setTipoViolenciaId(Integer tipoViolenciaId) {
        this.tipoViolenciaId = tipoViolenciaId;
    }

    public String getTipoViolencia() {
        return tipoViolencia;
    }

    public void setTipoViolencia(String tipoViolencia) {
        this.tipoViolencia = tipoViolencia;
    }

    public Resultado(Integer id, Integer indiceViolenciaId, String indiceViolencia, Integer tipoViolenciaId,
            String tipoViolencia, Integer scoreFinal, Usuaria usuariaId) {
        this.id = id;
        this.indiceViolenciaId = indiceViolenciaId;
        this.indiceViolencia = indiceViolencia;
        this.tipoViolenciaId = tipoViolenciaId;
        this.tipoViolencia = tipoViolencia;
        this.scoreFinal = scoreFinal;
        this.usuariaId = usuariaId;
    }

}
