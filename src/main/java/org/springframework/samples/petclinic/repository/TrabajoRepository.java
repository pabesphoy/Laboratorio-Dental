package org.springframework.samples.petclinic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Clinica;
import org.springframework.samples.petclinic.model.Doctor;
import org.springframework.samples.petclinic.model.Paciente;
import org.springframework.samples.petclinic.model.Trabajo;
import org.springframework.samples.petclinic.model.TrabajosProductos;

public interface TrabajoRepository extends CrudRepository<Trabajo, Integer>{
    List<Trabajo> findAll();

    @Query(nativeQuery = true, value = "SELECT t.* FROM Trabajo t JOIN Trabajos_Productos tp WHERE tp.id = ? AND tp.trabajos_id = t.id")
    Optional<Trabajo> findTrabajoByTrabajosProductos(TrabajosProductos tp);

    @Query(nativeQuery = true, value = "SELECT t.* FROM Trabajo t WHERE t.doctor_id = ?1")
    List<Trabajo> findAllTrabajosByDoctor(Doctor d);

    @Query(nativeQuery = true, value = "SELECT t.* FROM Trabajo t WHERE t.paciente_id = ?1")
    List<Trabajo> findAllTrabajosByPaciente(Paciente p);

    @Query(nativeQuery = true, value = "SELECT t.* FROM Trabajo t WHERE t.clinica_id = ?1")
    List<Trabajo> findAllTrabajosByClinica(Clinica c);
}
