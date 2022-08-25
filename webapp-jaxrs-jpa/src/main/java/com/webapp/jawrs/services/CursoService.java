package com.webapp.jawrs.services;

import com.webapp.jawrs.models.Curso;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface CursoService {

    List<Curso> listar();

    Curso guardar(Curso curso);

    Optional<Curso> obtener(Long id);

    void eliminar(Long id);
}
