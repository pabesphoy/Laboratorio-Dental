package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Trabajo;
import org.springframework.samples.petclinic.model.TrabajosProductos;


public interface TrabajosProductosRepository extends CrudRepository<TrabajosProductos, Integer>{

    @Query(nativeQuery = true, value = "SELECT * FROM trabajos_productos wHERE trabajo_id = 1")
    List<TrabajosProductos> findAllByTrabajo(Trabajo trabajo);
}
