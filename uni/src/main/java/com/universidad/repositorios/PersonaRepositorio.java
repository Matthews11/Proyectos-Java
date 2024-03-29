package com.universidad.repositorios;

import com.universidad.modelo.entidades.Persona;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Primary
public interface PersonaRepositorio extends CrudRepository<Persona,Integer> {
    @Query("select p from Persona p  where p.nombre=?1 and p.apellido=?2")
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    @Query("select p from Persona p where p.dni=?1")
    Optional<Persona> buscarPorDni(String dni);
    @Query("select p from Persona p where p.apellido like %?1%")
    Iterable<Persona> buscarPersonaPorApellido(String apellido);
}
