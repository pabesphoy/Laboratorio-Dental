package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Integer>{

	List<Paciente> findAll();
}
