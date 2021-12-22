package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Clinica;

public interface ClinicaRepository extends CrudRepository<Clinica, Integer>{
	
	List<Clinica> findAll();

}