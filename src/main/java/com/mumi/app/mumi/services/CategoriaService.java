package com.mumi.app.mumi.services;

import java.util.List;
import java.util.Optional;

import com.mumi.app.mumi.entities.Categoria;
import com.mumi.app.mumi.entities.Pregunta;
import com.mumi.app.mumi.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository repoCategoria;

    @Autowired
    PreguntaService preguntaService;

    public void crearCategoria(Categoria categoria) {
        repoCategoria.save(categoria);
    }

    public Categoria crearCategoria(String nombre) {
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        repoCategoria.save(categoria);
        return categoria;
    }

    public Categoria actualizarCategoria(Categoria categoria) {
        return repoCategoria.save(categoria);
    }

    public Categoria buscarPorId(Integer id) {
        Optional<Categoria> opCategoria = repoCategoria.findById(id);

        if (opCategoria.isPresent())
            return opCategoria.get();
        else
            return null;

    }

    public List<Categoria> obtenerCategorias() {
        return (repoCategoria.findAll());

    }

	public boolean asignarPregunta(Integer id, Integer preguntaId) {
		Categoria c = buscarPorId(id);

        for (Pregunta p : c.getPreguntas()) {
            if (p.getId().equals(preguntaId))
                return false; // Si lo encuentra no hay que hacer nadas
            // Hay que terminar de recorrer.
        }

        c.asignarPregunta(preguntaService.obtenerPreguntaPorId(preguntaId));

        // Actualizo el curso en la base de datos
        // dejo que el repositorio haga su magia(y cruzamos los dedos)
        repoCategoria.save(c);

        return true;
	}
}
