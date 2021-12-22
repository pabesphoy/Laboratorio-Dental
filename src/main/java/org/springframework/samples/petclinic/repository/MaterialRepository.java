package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Material;
import org.springframework.samples.petclinic.model.Producto;

public interface MaterialRepository extends CrudRepository<Material, Integer>{

    List<Material> findAll();

    @Query(nativeQuery = true, value = "SELECT m.* FROM Material m JOIN productos_materiales pm where m.id = pm.materiales_id AND p.id = ?1")
    List<Material> findAllByProduct(Producto p);
    
    
}
