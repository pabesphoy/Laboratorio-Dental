package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer>{

	List<Doctor> findAll();
}
