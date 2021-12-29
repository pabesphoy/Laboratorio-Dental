package org.springframework.samples.petclinic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.CategoriaProducto;

public interface CategoriasProductosRepository extends CrudRepository<CategoriaProducto, Integer>{

    List<CategoriaProducto> findAll();

    Optional<CategoriaProducto> findById(Integer id);
    
}
