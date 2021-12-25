package org.springframework.samples.petclinic.service;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Clinica;
import org.springframework.samples.petclinic.model.Doctor;
import org.springframework.samples.petclinic.model.Laboratorio;
import org.springframework.samples.petclinic.model.Material;
import org.springframework.samples.petclinic.model.Paciente;
import org.springframework.samples.petclinic.model.Producto;
import org.springframework.samples.petclinic.model.Proveedor;
import org.springframework.samples.petclinic.model.Trabajo;
import org.springframework.samples.petclinic.model.TrabajosProductos;
import org.springframework.samples.petclinic.repository.ClinicaRepository;
import org.springframework.samples.petclinic.repository.DoctorRepository;
import org.springframework.samples.petclinic.repository.LaboratorioRepository;
import org.springframework.samples.petclinic.repository.MaterialRepository;
import org.springframework.samples.petclinic.repository.PacienteRepository;
import org.springframework.samples.petclinic.repository.ProductoRepository;
import org.springframework.samples.petclinic.repository.ProveedorRepository;
import org.springframework.samples.petclinic.repository.TrabajoRepository;
import org.springframework.samples.petclinic.repository.TrabajosProductosRepository;
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
	@Autowired 
	TrabajoRepository trabajoRep;
	@Autowired 
	ProductoRepository productoRepository;
	@Autowired 
	MaterialRepository materialRepo;
	@Autowired
	ProveedorRepository proveedorRepo;
	@Autowired
	TrabajosProductosRepository trabajosProductosRepository;


	//----------------------GETTERS--------------------------------------
	public List<Doctor> getAllDoctors() {
		return doctorRep.findAll();
	}

	public Doctor getDoctorById(Integer id){
		return doctorRep.findById(id).orElse(null);
	}

	public Collection<Laboratorio> getAllLaboratories() {
		return laboratorioRep.findAll();
	}

	public Laboratorio getLaboratoryById(Integer id){
		return laboratorioRep.findById(id).orElse(null);
	}

	public Collection<Paciente> getAllPatients() {
		return pacienteRep.findAll();
	}

	public Paciente getPacienteById(Integer id){
		return pacienteRep.findById(id).orElse(null);
	}
	
	public Collection<Clinica> getAllClinics() {
		return clinicaRep.findAll();
	}

	public Clinica getClinicaById(Integer id){
		return clinicaRep.findById(id).orElse(null);
	}

	public List<Trabajo> getAllTrabajos(){
		return trabajoRep.findAll();
	}

	public Trabajo getTrabajoById(Integer workId) {
        return trabajoRep.findById(workId).orElse(null);
    }

	public List<TrabajosProductos> getAllProductosWorksOf(Trabajo trabajo) {
		return trabajosProductosRepository.findAllByTrabajo(trabajo);
	}

	public List<Producto> getAllProductos() {
		return productoRepository.findAll();
	}

	public Producto getProductoById(Integer id) {
		return productoRepository.findById(id).orElse(null);
	}


	public List<Producto> getAllProductosOf(Trabajo t) {
		return productoRepository.findAllByTrabajo(t);
	}

	public TrabajosProductos getTrabajoProductoById(Integer id){
		return trabajosProductosRepository.findById(id).orElse(null);
	}

	public List<Material> getAllMateriales() {
		return materialRepo.findAll();
	}

	public Material getMaterialById(Integer id) {
        return materialRepo.findById(id).orElse(null);
    }

	public List<Material> getAllMaterialesOf(Producto p) {
		return materialRepo.findAllByProduct(p);
	}

	public List<Proveedor> getAllProveedores() {
		return proveedorRepo.findAll();
	}

	public Proveedor getProveedorById(Integer id){
		return proveedorRepo.findById(id).orElse(null);
	}

	//----------------------CREATE--------------------------------------

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

	public void createTrabajo(Trabajo t){
		trabajoRep.save(t);
	}

	public void createProduct(@Valid Producto p) {
		productoRepository.save(p);
    }

	public void createMaterial(@Valid Material m){
		materialRepo.save(m);
	}
	public void createProveedor(@Valid Proveedor p){
		proveedorRepo.save(p);
	}


	//----------------------DELETE--------------------------------------
	public void deleteDoctor(Doctor doctor){
		doctorRep.delete(doctor);
	}

	public void deleteLaboratorio(Laboratorio lab){
		laboratorioRep.delete(lab);
	}

	public void deletePaciente(Paciente p){
		pacienteRep.delete(p);
	}

	public void deleteClinic(Clinica c){
		clinicaRep.delete(c);
	}
	
	public void deleteTrabajo(Trabajo t){
		trabajoRep.delete(t);
	}

	public void deleteProduct(Producto p){
		productoRepository.delete(p);
	}

	public void deleteTrabajosProductos(TrabajosProductos tp){
		trabajosProductosRepository.delete(tp);
	}

	public void deleteMaterial(Material m){
		materialRepo.delete(m);
	}

	public void deleteProveedor(Proveedor p){
		proveedorRepo.delete(p);
	}

    
    
}
