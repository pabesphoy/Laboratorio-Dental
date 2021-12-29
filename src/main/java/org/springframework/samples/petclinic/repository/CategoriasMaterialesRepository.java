package org.springframework.samples.petclinic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.CategoriaMaterial;

public interface CategoriasMaterialesRepository extends CrudRepository<CategoriaMaterial, Integer>{
    
    List<CategoriaMaterial> findAll();

    Optional<CategoriaMaterial> findById(Integer id);
}
