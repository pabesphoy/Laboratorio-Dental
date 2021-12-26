package org.springframework.samples.petclinic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Trabajo;
import org.springframework.samples.petclinic.model.TrabajosProductos;

public interface TrabajoRepository extends CrudRepository<Trabajo, Integer>{
    List<Trabajo> findAll();

    @Query(nativeQuery = true, value = "SELECT t.* FROM Trabajos t JOIN Trabajos_Productos tp WHERE tp.id = ? AND tp.trabajos_id = t.id")
    Optional<Trabajo> findTrabajoByTrabajosProductos(TrabajosProductos tp);
}
