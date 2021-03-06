package org.springframework.samples.petclinic.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Clinica;
import org.springframework.samples.petclinic.model.Doctor;
import org.springframework.samples.petclinic.model.Laboratorio;
import org.springframework.samples.petclinic.model.Paciente;
import org.springframework.samples.petclinic.service.ServicesAux;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clients")
public class ClientController {

    public static final String VIEW_LIST_DOCTORES = "clients/listDoctors";
    public static final String VIEW_LIST_PACIENTES = "clients/listPatients";
    public static final String VIEW_LIST_CLINICAS = "clients/listClinics";
    public static final String VIEW_LIST_LABORATORIOS = "clients/listLaboratories";
    public static final String VIEW_LIST_DOCTORES_OF_CLINIC = "clients/listDoctorsOfClinic";
    public static final String VIEW_CREATE_DOCTORES = "clients/createDoctors";
    public static final String VIEW_CREATE_PACIENTES = "clients/createPatients";
    public static final String VIEW_CREATE_CLINICAS = "clients/createClinics";
    public static final String VIEW_CREATE_LABORATORIOS = "clients/createLaboratories";
    public static final String VIEW_CREATE_DOCTOR_OF_CLINIC = "clients/createDoctorOfClinic";
    


    @Autowired
    ServicesAux service;
    
    @GetMapping("/laboratories")
    public String listLaboratories(ModelMap model) {
    	model.addAttribute("laboratories", service.getAllLaboratories());
    	return VIEW_LIST_LABORATORIOS;
    }
    
    @GetMapping("/clinics")
    public String listClinics(ModelMap model) {
    	
    	model.addAttribute("clinics", service.getAllClinics());
    	return VIEW_LIST_CLINICAS;
    }
    
    @GetMapping("/patients")
    public String listPatients(ModelMap model) {
    	model.addAttribute("patients", service.getAllPatients());
    	return VIEW_LIST_PACIENTES;
    }

    

    @GetMapping("/clinics/new")
    public String initClinic(ModelMap model) {

        if(!model.containsAttribute("clinic"))
    	    model.addAttribute("clinic", new Clinica());
    	return VIEW_CREATE_CLINICAS;
    }

    @PostMapping("/clinics/new")
    public String createClinic(RedirectAttributes redirect, @Valid Clinica clinic,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            model.addAttribute("message", "Error al crear");
            return initClinic(model);
    }else{
            service.createClinic(clinic);
            model.addAttribute("message", "Creaci??n completada");
            return "redirect:/clients/clinics";
        }
    }

    @GetMapping("/clinics/{id}/edit")
    public String editClinic(ModelMap model, @PathVariable("id") Integer id){
        Clinica clinica = service.getClinicaById(id);
        if(clinica == null){
            model.addAttribute("message", "Cl??nica no encontrada");
            return listClinics(model);
        }else{
            model.addAttribute("clinic", clinica);
            return initClinic(model);
        } 
    }

    @PostMapping("/clinics/{id}/edit")
    public String updateClinic(RedirectAttributes redirect, @Valid Clinica clinic,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            model.addAttribute("message", "Error al editar");
            return initClinic(model);
    }else{
            service.createClinic(clinic);
            model.addAttribute("message", "Edicion completa");
            return "redirect:/clients/clinics";
        }
    }

    @GetMapping("/clinics/{id}/delete")
    public String deleteClinic(ModelMap model, @PathVariable("id") Integer id){
        Clinica clinica = service.getClinicaById(id);
        if(clinica == null){
            model.addAttribute("message", "Cl??nica no encontrada. Compruebe si ya ha sido eliminada");
        }else if(service.getAllTrabajosByClinica(clinica).size() != 0){
            model.addAttribute("message", "Esta cl??nica tiene trabajos asociados. No se puede eliminar");
        }else{
            service.deleteClinic(clinica);
            model.addAttribute("message", "Cl??nica eliminada");
        }

        return listClinics(model);
    }


    @GetMapping("/clinics/{clinicId}/doctors")
    public String listDoctorsOfClinic(ModelMap model, @PathVariable("clinicId") Integer id){
        Clinica clinica = service.getClinicaById(id);
        model.addAttribute("doctors", service.getDoctorsOfClinic(clinica));
        model.addAttribute("clinica", clinica);
        return VIEW_LIST_DOCTORES_OF_CLINIC;
    }

    @GetMapping("/clinics/{clinicId}/doctors/new")
    public String createDoctorOfClinic(ModelMap model, @PathVariable("clinicId") Integer id){
        Clinica clinica = service.getClinicaById(id);
        List<Doctor> doctors = service.getAllDoctors();
        doctors.removeAll(clinica.getDoctores());

        model.addAttribute("doctors", doctors);
        model.addAttribute("clinica", clinica);

        return VIEW_CREATE_DOCTOR_OF_CLINIC;
    }

    @RequestMapping(value = "/clinics/{clinicId}/doctors/new", method = RequestMethod.POST)
    public String createDoctorOfClinic(ModelMap model, @RequestParam("doctor") Integer doctorId, HttpServletResponse response, @PathVariable("clinicId") Integer clinicId){

        Doctor doctor = service.getDoctorById(doctorId);
        Clinica clinica = service.getClinicaById(clinicId);

        if(clinica.getDoctores().contains(doctor)){
            model.addAttribute("message", "Esta cl??nica ya contiene a este doctor. Compruebe si el doctor est?? a??adido ya.");
        }else{
            model.addAttribute("message", "Doctor a??adido");
            clinica.getDoctores().add(doctor);
            service.createClinic(clinica);
        }
        
        return listDoctorsOfClinic(model, clinicId);
    }
    

    @GetMapping("/clinics/{clinicaId}/doctors/{doctorId}/delete")
    public String deleteDoctorOfClinic(ModelMap model, @PathVariable("clinicaId") Integer clinicId, @PathVariable("doctorId") Integer doctorId){
        Clinica clinica = service.getClinicaById(clinicId);
        Doctor doctor = service.getDoctorById(doctorId);
        if(!clinica.getDoctores().contains(doctor)){
            model.addAttribute("message", "Doctor no encontrado en esta cl??nica, compruebe si ya ha sido retirado");
        }else{
            service.deleteDoctorFromClinic(clinica, doctor);
            model.addAttribute("message", "Doctor retirado de la cl??nica");
        }

        return listDoctorsOfClinic(model, clinicId);
    }

    @GetMapping("/laboratories/new")
    public String initLaboratory(ModelMap model) {
        if(!model.containsAttribute("laboratory"))
            model.addAttribute("laboratory", new Laboratorio());
    	return VIEW_CREATE_LABORATORIOS;
    }

    @PostMapping("/laboratories/new")
    public String createLaboratory(RedirectAttributes redirect, @Valid Laboratorio l, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("message", "Error al crear");
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            return "redirect:/clients/laboratories";
        }
            
        else{
            service.createLaboratory(l);
            model.addAttribute("message", "Creaci??n completada");
            return listLaboratories(model);
        }
    }

    @GetMapping("/laboratories/{id}/edit")
    public String editLaboratory(ModelMap model, @PathVariable("id") Integer id){
        Laboratorio laboratorio = service.getLaboratoryById(id);
        if(laboratorio == null){
            model.addAttribute("message", "Laboratorio no encontrado");
            return listLaboratories(model);
        }else{
            model.addAttribute("laboratory", laboratorio);
            return initLaboratory(model);
        } 
    }

    @PostMapping("/laboratories/{id}/edit")
    public String updateLaboratory(RedirectAttributes redirect, @Valid Laboratorio laboratory,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            model.addAttribute("message", "Error al editar");
            return initLaboratory(model);
    }else{
            service.createLaboratory(laboratory);
            model.addAttribute("message", "Edicion completa");
            return "redirect:/clients/laboratories";
        }
    }

    @GetMapping("/laboratories/{id}/delete")
    public String createLaboratory(@PathVariable("id") Integer id, ModelMap model){
        Laboratorio laboratorio = service.getLaboratoryById(id);
        if(laboratorio == null){
            model.addAttribute("message", "Laboratorio no encontrado. Compruebe si ya se ha eliminado.");
            return listLaboratories(model);
        }else if(service.getAllTrabajosByLaboratorio(laboratorio).size() != 0){
            model.addAttribute("message", "Este laboratorio tiene trabajos asociados. Elim??nelos antes de eliminar este laboratorio");
            return listLaboratories(model);
        }else{
            service.deleteLaboratorio(laboratorio);
            model.addAttribute("message", "Laboratorio eliminado");
            return listLaboratories(model);
        }
    }

    @GetMapping("/patients/new")
    public String initPatient(ModelMap model) {
        if(!model.containsAttribute("patient"))
    	    model.addAttribute("patient", new Paciente());
    	return VIEW_CREATE_PACIENTES;
    }

    @PostMapping("/patients/new")
    public String createPatient(RedirectAttributes redirect, @Valid Paciente p,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("message", "Error al crear");
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            return initPatient(model);
        }
            
        else{
            service.createPatient(p);
            model.addAttribute("message", "Creaci??n completada");
            return "redirect:/clients/patients";
        }
    }

    @GetMapping("/patients/{id}/edit")
    public String editPatient(ModelMap model, @PathVariable("id") Integer id){
        Paciente patient = service.getPacienteById(id);
        if(patient == null){
            model.addAttribute("message", "Paciente no encontrado");
            return listPatients(model);
        }else{
            model.addAttribute("patient", patient);
            return initPatient(model);
        } 
    }

    @PostMapping("/patients/{id}/edit")
    public String updatePatient(RedirectAttributes redirect, @Valid Paciente patient,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            model.addAttribute("message", "Error al editar");
            return initPatient(model);
    }else{
            service.createPatient(patient);
            model.addAttribute("message", "Edicion completa");
            return "redirect:/clients/patients";
        }
    }

    @GetMapping("/patients/{id}/delete")
    public String deletePatient(@PathVariable("id") Integer id, ModelMap model){
        Paciente p = service.getPacienteById(id);

        if(p == null){
            model.addAttribute("message", "Paciente no encontrado. Compruebe si ya ha sido eliminado");
        }else if(service.getAllTrabajosByPaciente(p).size() != 0){
            model.addAttribute("message", "Este paciente tiene trabajos asociados. No se puede eliminar");
        }else{
            service.deletePaciente(p);
            model.addAttribute("message", "Paciente eliminado");
        }

        return listPatients(model);
    }

    @GetMapping("/doctors")
    public String listDoctors(ModelMap model) {
    	model.addAttribute("doctors", service.getAllDoctors());
    	return VIEW_LIST_DOCTORES;
    }

    @GetMapping("/doctors/new")
    public String initDoctor(ModelMap model) {
        if(!model.containsAttribute("doctor"))
    	    model.addAttribute("doctor", new Doctor());
    	return VIEW_CREATE_DOCTORES;
    }
    @PostMapping("/doctors/new")
    public String createDoctor(RedirectAttributes redirect, @Valid Doctor doctor,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("message", "Error al crear");
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            return initDoctor(model);
        }
        else{
            service.createDoctor(doctor);
            model.addAttribute("message", "Creaci??n completada");
            return "redirect:/clients/doctors";
        }
    }

    @GetMapping("/doctors/{id}/edit")
    public String editDoctor(ModelMap model, @PathVariable("id") Integer id){
        Doctor doctor = service.getDoctorById(id);
        if(doctor == null){
            model.addAttribute("message", "Doctor no encontrado");
            return listDoctors(model);
        }else{
            model.addAttribute("doctor", doctor);
            return initDoctor(model);
        } 
    }

    @PostMapping("/doctors/{id}/edit")
    public String updateDoctor(RedirectAttributes redirect, @Valid Doctor doctor,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            model.addAttribute("message", "Error al editar");
            return initDoctor(model);
    }else{
            service.createDoctor(doctor);
            model.addAttribute("message", "Edicion completa");
            return "redirect:/clients/doctors";
        }
    }

    @GetMapping("/doctors/{id}/delete")
	public String deleteDoctor(RedirectAttributes redirect,ModelMap model, @PathVariable("id") int id) {
		Doctor doctor = service.getDoctorById(id);
        if(doctor==null){
            model.addAttribute("message", "Doctor no encontrado");
            return listDoctors(model);
        }   
        if(service.getAllTrabajosByDoctor(doctor).size() != 0){
            model.addAttribute("message", "Hay trabajos a nombre de este doctor. No se puede eliminar.");
            return listDoctors(model);
        }

        List<Clinica> clinicasDeDoctor = service.getAllClinicsByDoctor(doctor);
        clinicasDeDoctor.forEach(clinica -> {
            List<Doctor> docs = clinica.getDoctores();
            docs.remove(doctor);
            clinica.setDoctores(docs);
            service.createClinic(clinica);
        });
		service.deleteDoctor(service.getDoctorById(id));
        model.addAttribute("message", "Doctor eliminado");
        return listDoctors(model);

	}
}
