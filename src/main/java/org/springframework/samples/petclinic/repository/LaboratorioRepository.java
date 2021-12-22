package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Laboratorio;

public interface LaboratorioRepository extends CrudRepository<Laboratorio, Integer>{

	List<Laboratorio> findAll();
}
