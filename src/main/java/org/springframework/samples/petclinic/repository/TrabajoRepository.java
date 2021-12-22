package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Trabajo;

public interface TrabajoRepository extends CrudRepository<Trabajo, Integer>{
    List<Trabajo> findAll();
}
