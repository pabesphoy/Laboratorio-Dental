package org.springframework.samples.petclinic.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clients")
public class ClientController {

    public static final String VIEW_LIST_DOCTORES = "clients/listDoctors";
    public static final String VIEW_LIST_PACIENTES = "clients/listPatients";
    public static final String VIEW_LIST_CLINICAS = "clients/listClinics";
    public static final String VIEW_LIST_LABORATORIOS = "clients/listLaboratories";
    public static final String VIEW_CREATE_DOCTORES = "clients/createDoctors";
    public static final String VIEW_CREATE_PACIENTES = "clients/createPatients";
    public static final String VIEW_CREATE_CLINICAS = "clients/createClinics";
    public static final String VIEW_CREATE_LABORATORIOS = "clients/createLaboratories";


    @Autowired
    ServicesAux service;
    
    @GetMapping("/doctors")
    public String listDoctors(ModelMap model) {
    	model.addAttribute("doctors", service.getAllDoctors());
    	return VIEW_LIST_DOCTORES;
    }
    
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

    @GetMapping("/doctors/new")
    public String initDoctor(ModelMap model) {
        Doctor doctor = new Doctor();
    	model.addAttribute("doctor", doctor);
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
            model.addAttribute("message", "Creación completada");
            return listDoctors(model);
        }
    }

    @GetMapping("/clinics/new")
    public String initClinic(ModelMap model) {
        Clinica clinica = new Clinica();
    	model.addAttribute("clinic", clinica);
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
            model.addAttribute("message", "Creación completada");
            return listClinics(model);
        }
    }

    @GetMapping("/laboratories/new")
    public String initLaboratory(ModelMap model) {
        Laboratorio laboratorio = new Laboratorio();
        model.addAttribute("laboratory", laboratorio);
    	return VIEW_CREATE_LABORATORIOS;
    }

    @PostMapping("/laboratories/new")
    public String createLaboratory(RedirectAttributes redirect, @Valid Laboratorio l,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("message", "Error al crear");
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            return initLaboratory(model);
        }
            
        else{
            service.createLaboratory(l);
            model.addAttribute("message", "Creación completada");
            return listLaboratories(model);
        }
    }

    @GetMapping("/patients/new")
    public String initPatient(ModelMap model) {
    	Paciente patient = new Paciente();
    	model.addAttribute("patient", patient);
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
            model.addAttribute("message", "Creación completada");
            return listPatients(model);
        }
    }
}
