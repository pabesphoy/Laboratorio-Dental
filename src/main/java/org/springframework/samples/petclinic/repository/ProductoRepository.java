package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Producto;
import org.springframework.samples.petclinic.model.Trabajo;


public interface ProductoRepository extends CrudRepository<Producto, Integer>{
    List<Producto> findAll();

    @Query(nativeQuery = true, value = "SELECT p.* FROM Producto p JOIN trabajos_productos tp WHERE p.id = tp.productos_id AND tp.trabajo_id = ?1")
    List<Producto> findAllByTrabajo(Trabajo t);

}
