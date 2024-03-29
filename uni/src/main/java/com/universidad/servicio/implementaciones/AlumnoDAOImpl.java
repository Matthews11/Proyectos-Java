package com.universidad.servicio.implementaciones;

import com.universidad.modelo.entidades.Persona;
import com.universidad.repositorios.AlumnoRepositorio;
import com.universidad.repositorios.PersonaRepositorio;
import com.universidad.servicio.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO  {

    @Autowired
    public AlumnoDAOImpl( @Qualifier( "repo_alumno")PersonaRepositorio rep) {
        super(rep);
    }


    @Override
    @Transactional (readOnly = true)
    public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre) {
        return ((AlumnoRepositorio)rep).buscarAlumnosPorNombreCarrera(nombre);
    }
}
