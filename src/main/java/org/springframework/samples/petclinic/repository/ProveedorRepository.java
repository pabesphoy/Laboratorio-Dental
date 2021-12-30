package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Material;
import org.springframework.samples.petclinic.model.Proveedor;

public interface ProveedorRepository extends CrudRepository<Proveedor, Integer>{
    
    List<Proveedor> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM MATERIAL_PROVEEDORES mp JOIN proveedor p WHERE mp.material_id = ?1 AND p.id = mp.proveedores_id")
    List<Proveedor> findAllProveedoresOfMaterial(Material material);

    @Query(nativeQuery = true, value = "SELECT * FROM Proveedor WHERE Proveedor.id NOT IN(SELECT p.id FROM MATERIAL_PROVEEDORES mp JOIN proveedor p WHERE mp.material_id = ?1 AND p.id = mp.proveedores_id)")
    List<Proveedor> findAllNotProveedoresOfMaterial(Material material);
}
