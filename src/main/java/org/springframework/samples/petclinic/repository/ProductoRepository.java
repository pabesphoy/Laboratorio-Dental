package org.springframework.samples.petclinic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Producto;
import org.springframework.samples.petclinic.model.Trabajo;
import org.springframework.samples.petclinic.model.TrabajosProductos;


public interface ProductoRepository extends CrudRepository<Producto, Integer>{
    List<Producto> findAll();

    @Query(nativeQuery = true, value = "SELECT p.* FROM Producto p JOIN trabajos_productos tp WHERE p.id = tp.producto_id AND tp.trabajo_id = ?1")
    List<Producto> findAllByTrabajo(Trabajo t);

    @Query(nativeQuery = true, value = "SELECT p.* FROM Producto p JOIN trabajos_productos tp WHERE tp.id = ?1 AND p.id = tp.producto_id")
    Optional<Producto> findProductoByTrabajosProductos(TrabajosProductos tp);

}
