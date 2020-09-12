package com.mumi.app.mumi.services;

import java.util.List;
import java.util.Optional;

import com.mumi.app.mumi.entities.Pregunta;
import com.mumi.app.mumi.entities.Pregunta.TipoPreguntaEnum;
import com.mumi.app.mumi.repositories.PreguntaRepository;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreguntaService {

    @Autowired
    PreguntaRepository preguntaRepo;

    public Pregunta crearPregunta(Pregunta pregunta) {
       return preguntaRepo.save(pregunta);
    
    }

    public Pregunta crearPregunta(String pregunta, TipoPreguntaEnum tipoPregunta) {
        Pregunta question = new Pregunta();
        question.setPregunta(pregunta);
        question.setTipoPregunta(tipoPregunta);
        return question;

    }

    public List<Pregunta> listarPreguntas() {
        return preguntaRepo.findAll();
    }

    public Pregunta obtenerPreguntaPorId(Integer id) {
        Optional<Pregunta> p = preguntaRepo.findById(id);

        if (p.isPresent())
            return p.get();
        return null;
    }

    public void obtenerPreguntaSegunTipoDeViolencia(Integer tipoPreguntaId) {

        switch (tipoPreguntaId) {
            case 1:
                this.violenciaFisica();
                break;
            case 2:
                this.violenciaPsicologica();
                break;

            case 3:
                this.violenciaSexual();
                break;

            case 4:
                this.violenciaEconomica();
                break;

            default:
                break;
        }

        // List<Pregunta> preguntasTipo = this.listarPreguntas().stream().filter(t ->
        // t.getTipoPregunta().contains(tipoPreguntaId)).collect(Collectors.toList());

    }

    public List<Pregunta> violenciaFisica() {
        Pregunta pr = new Pregunta();
        try {
            List<Pregunta> preguntasViolenciaFisica = this.listarPreguntas().stream()
                    .filter(p -> p.getPregunta().contains("fisicamente")).collect(Collectors.toList());
            // pr.getPreguntas().add(preguntasViolenciaFisica);
            pr.setTipoPregunta(TipoPreguntaEnum.VIOLENCIA_FISICA);
            preguntaRepo.save(pr);
            return preguntasViolenciaFisica;

        } catch (Exception e) {
            System.out.println("Esta pregunta no es de violencia fisica");
        }
        return null;

    }

    public List<Pregunta> violenciaPsicologica() {
        Pregunta pre = new Pregunta();
        List<Pregunta> preguntasViolenciaPsico = this.listarPreguntas().stream()
                .filter(p -> p.getPregunta().contains("verbal")).collect(Collectors.toList());
        // pre.getPreguntas().add(preguntasViolenciaPsico);
        pre.setTipoPregunta(TipoPreguntaEnum.VIOLENCIA_PSICO);
        preguntaRepo.save(pre);
        return preguntasViolenciaPsico;

    }

    public List<Pregunta> violenciaSexual() {
        Pregunta preg = new Pregunta();
        List<Pregunta> preguntasViolenciaSexual = this.listarPreguntas().stream()
                .filter(p -> p.getPregunta().contains("sexual")).collect(Collectors.toList());
        preg.setTipoPregunta(TipoPreguntaEnum.VIOLENCIA_SEXUAL);
        // preg.getPreguntas().add(preguntasViolenciaSexual);
        preguntaRepo.save(preg);
        return preguntasViolenciaSexual;

    }

    public List<Pregunta> violenciaEconomica() {
        Pregunta pregu = new Pregunta();
        List<Pregunta> preguntasViolenciaEconomica = this.listarPreguntas().stream()
                .filter(p -> p.getPregunta().contains("dinero") || p.getPregunta().contains("economicamente"))
                .collect(Collectors.toList());
        pregu.setTipoPregunta(TipoPreguntaEnum.VIOLENCIA_ECO);
        // pregu.getPreguntas().add(preguntasViolenciaEconomica);
        preguntaRepo.save(pregu);
        return preguntasViolenciaEconomica;
    }

}
