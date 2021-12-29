package org.springframework.samples.petclinic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Color;

public interface ColorRepository extends CrudRepository<Color, Integer>{
    
    List<Color> findAll();

    Optional<Color> findById(Integer id);
}
