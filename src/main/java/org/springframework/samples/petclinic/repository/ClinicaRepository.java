package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Clinica;
import org.springframework.samples.petclinic.model.Doctor;

public interface ClinicaRepository extends CrudRepository<Clinica, Integer>{
	
	List<Clinica> findAll();

	@Query(nativeQuery = true, value = "SELECT c.* FROM Clinica c JOIN Clinicas_Doctores cd WHERE c.id = cd.clinica_id AND cd.doctor_id = ?1")
	List<Clinica> findAllByDoctor(Doctor d);

}