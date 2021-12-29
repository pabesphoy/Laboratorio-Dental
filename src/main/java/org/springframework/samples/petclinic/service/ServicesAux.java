package org.springframework.samples.petclinic.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.CategoriaMaterial;
import org.springframework.samples.petclinic.model.CategoriaProducto;
import org.springframework.samples.petclinic.model.Clinica;
import org.springframework.samples.petclinic.model.Color;
import org.springframework.samples.petclinic.model.Doctor;
import org.springframework.samples.petclinic.model.Laboratorio;
import org.springframework.samples.petclinic.model.Material;
import org.springframework.samples.petclinic.model.Paciente;
import org.springframework.samples.petclinic.model.Producto;
import org.springframework.samples.petclinic.model.Proveedor;
import org.springframework.samples.petclinic.model.Trabajo;
import org.springframework.samples.petclinic.model.TrabajosProductos;
import org.springframework.samples.petclinic.repository.CategoriasMaterialesRepository;
import org.springframework.samples.petclinic.repository.CategoriasProductosRepository;
import org.springframework.samples.petclinic.repository.ClinicaRepository;
import org.springframework.samples.petclinic.repository.ColorRepository;
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

	@Autowired
	ColorRepository colorRepository;

	@Autowired
	CategoriasProductosRepository categoriaProductoRepository;

	@Autowired
	CategoriasMaterialesRepository categoriasMaterialesRepository;


	//----------------------GETTERS--------------------------------------
	public List<Doctor> getAllDoctors() {
		return doctorRep.findAll();
	}

	public Doctor getDoctorById(Integer id){
		return doctorRep.findById(id).orElse(null);
	}

	public List<Doctor> getDoctorsOfClinic(Clinica clinicaById) {
        return doctorRep.findAllByClinic(clinicaById);
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

	public Trabajo getTrabajoByTrabajosProductos(TrabajosProductos tp){
		return trabajoRep.findTrabajoByTrabajosProductos(tp).orElse(null);
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
	public Producto getProductoByTrabajosProductos(TrabajosProductos tp){
		return productoRepository.findProductoByTrabajosProductos(tp).orElse(null);
	}

	public TrabajosProductos getTrabajoProductoById(Integer id){
		return trabajosProductosRepository.findById(id).orElse(null);
	}

	public TrabajosProductos getTrabajosProductosByTrabajosAndProductos(Trabajo trabajo, Producto producto){
		return trabajosProductosRepository.findByTrabajoAndProducto(trabajo, producto).orElse(null);
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

	public List<Color> getAllColors(){
		return colorRepository.findAll();
	}

	public Color getColorById(Integer id){
		return colorRepository.findById(id).orElse(null);
	}

	public List<CategoriaProducto> getAllCategoriasProductos(){
		return categoriaProductoRepository.findAll();
	}

	public CategoriaProducto getCategoriaProductosById(Integer id){
		return categoriaProductoRepository.findById(id).orElse(null);
	}

	public List<CategoriaMaterial> getAllCategoriasMateriales(){
		return categoriasMaterialesRepository.findAll();
	}

	public CategoriaMaterial getCategoriaMaterialById(Integer id){
		return categoriasMaterialesRepository.findById(id).orElse(null);
	}

	public List<Trabajo> getAllTrabajosByLaboratorio(Laboratorio laboratorio) {
        return this.getAllTrabajos().stream().filter(t -> t.getLaboratorio() == laboratorio).collect(Collectors.toList());
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

	public void createTrabajo(@Valid Trabajo t){
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

	public void createTrabajosProductos(@Valid TrabajosProductos tp) {
		trabajosProductosRepository.save(tp);
    }

	public void createColor(@Valid Color color){
		colorRepository.save(color);
	}

	public void createCategoriaProducto(@Valid CategoriaProducto categoriaProducto){
		categoriaProductoRepository.save(categoriaProducto);
	}
	
	public void createCategoriaMaterial(@Valid CategoriaMaterial categoriaMaterial){
		categoriasMaterialesRepository.save(categoriaMaterial);
	}

	//----------------------DELETE--------------------------------------

	@Transactional
	public void deleteDoctor(Doctor doctor){
		doctorRep.delete(doctor);
	}

	@Transactional
	public void deleteLaboratorio(Laboratorio lab){
		laboratorioRep.delete(lab);
	}

	@Transactional
	public void deletePaciente(Paciente p){
		pacienteRep.delete(p);
	}		

	@Transactional
	public void deleteClinic(Clinica c){
		clinicaRep.delete(c);
	}
	
	@Transactional
	public void deleteTrabajo(Trabajo t){
		trabajoRep.delete(t);
	}

	@Transactional
	public void deleteProduct(Producto p){
		productoRepository.delete(p);
	}

	@Transactional
	public void deleteTrabajosProductos(TrabajosProductos tp){
		trabajosProductosRepository.deleteProductoFromTrabajo(tp);
	}


	@Transactional
	public void deleteMaterial(Material m){
		materialRepo.delete(m);
	}

	@Transactional
	public void deleteProveedor(Proveedor p){
		proveedorRepo.delete(p);
	}

	public void deleteDoctorFromClinic(Clinica clinica, Doctor doctor) {
		clinica.getDoctores().remove(doctor);
		clinicaRep.save(clinica);
    }

	public void deleteColor(Color color){
		colorRepository.delete(color);
	}

	public void deleteColorById(Integer colorId){
		colorRepository.deleteById(colorId);
	}

	public void deleteCategoriaProducto(CategoriaProducto categoria){
		categoriaProductoRepository.delete(categoria);
	}

	public void deleteCategoriaProductoById(Integer id){
		categoriaProductoRepository.deleteById(id);
	}

	public void deleteCategoriaMaterial(CategoriaMaterial categoria){
		categoriasMaterialesRepository.delete(categoria);
	}

	public void deleteCategoriaMaterialById(Integer id){
		categoriasMaterialesRepository.deleteById(id);
	}
    
	//-----------------INSERTS-------------------

	@Transactional
	public void addTrabajoToProducto(Trabajo t, Producto p, Integer unidades, Double precioPorUnidad, Double descuento){
		trabajosProductosRepository.addProductoToTrabajo(t, p, unidades, precioPorUnidad, descuento);
	}

	//-----------------OTROS-------------------

	public boolean perteneceDoctorAClinica(Doctor doctor, Clinica clinica){
		return getDoctorsOfClinic(clinica).contains(doctor);
	}

    

    

    
}
