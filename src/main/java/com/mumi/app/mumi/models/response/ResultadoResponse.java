package com.mumi.app.mumi.models.response;

import com.mumi.app.mumi.entities.Resultado.IndiceViolenciaEnum;
import com.mumi.app.mumi.entities.Resultado.TipoViolencia;

public class ResultadoResponse {
    public Integer usuariaId;
    public Integer resultadoId;
    public Integer cuestionarioId; 
    public TipoViolencia tipoViolencia;
    public IndiceViolenciaEnum indiceViolencia;
    public Integer scoreFinal;
}
