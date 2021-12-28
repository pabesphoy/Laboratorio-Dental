package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Clinica;
import org.springframework.samples.petclinic.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer>{

	List<Doctor> findAll();

	@Query(nativeQuery = true, value = "SELECT d.* FROM Doctor d JOIN Clinicas_Doctores cd WHERE cd.clinica_id = ?1 AND cd.doctor_id = d.id")
    List<Doctor> findAllByClinic(Clinica clinicaById);
}
