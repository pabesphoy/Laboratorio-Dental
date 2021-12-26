package org.springframework.samples.petclinic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Producto;
import org.springframework.samples.petclinic.model.Trabajo;
import org.springframework.samples.petclinic.model.TrabajosProductos;


public interface TrabajosProductosRepository extends CrudRepository<TrabajosProductos, Integer>{

    @Query(nativeQuery = true, value = "SELECT * FROM trabajos_productos wHERE trabajo_id = 1")
    List<TrabajosProductos> findAllByTrabajo(Trabajo trabajo);

    @Query(nativeQuery = true, value = "SELECT * FROM trabajos_productos tp WHERE tp.producto_id = ?2 AND tp.trabajo_id = ?1")
    Optional<TrabajosProductos> findByTrabajoAndProducto(Trabajo trabajo, Producto producto);

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO Trabajos_Productos (trabajo_id, producto_id, unidades, precio_por_unidad, descuento) VALUES (?1,?2,?3,?4,?5)")
    void addProductoToTrabajo(Trabajo t, Producto p, Integer unidades, Double precioPorUnidad, Double descuento);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM Trabajos_Productos WHERE id = ?1")
    void deleteProductoFromTrabajo(TrabajosProductos tp);

}
