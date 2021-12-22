package org.springframework.samples.petclinic.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Clinica;
import org.springframework.samples.petclinic.model.Doctor;
import org.springframework.samples.petclinic.model.Laboratorio;
import org.springframework.samples.petclinic.model.Paciente;
import org.springframework.samples.petclinic.repository.ClinicaRepository;
import org.springframework.samples.petclinic.repository.DoctorRepository;
import org.springframework.samples.petclinic.repository.LaboratorioRepository;
import org.springframework.samples.petclinic.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicesAux {
	
	@Autowired 
	DoctorRepository doctorRep;
	@Autowired 
	PacienteRepository pacienteRep;
	@Autowired 
	ClinicaRepository clinicaRep;
	@Autowired 
	LaboratorioRepository laboratorioRep;

	public List<Doctor> getAllDoctors() {
		return doctorRep.findAll();
		
	}

	public Collection<Laboratorio> getAllLaboratories() {
		return laboratorioRep.findAll();
		
	}

	public Collection<Paciente> getAllPatients() {
		return pacienteRep.findAll();
		
	}

	public Collection<Clinica> getAllClinics() {
		return clinicaRep.findAll();
	}

	public void createDoctor(Doctor doctor){
		doctorRep.save(doctor);
	}
	public void createLaboratory(Laboratorio lab){
		laboratorioRep.save(lab);
	}
	public void createPatient(Paciente p){
		pacienteRep.save(p);
	}
	public void createClinic(Clinica c){
		clinicaRep.save(c);
	}
    
}
