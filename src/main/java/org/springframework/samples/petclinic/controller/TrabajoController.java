package org.springframework.samples.petclinic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Trabajo;
import org.springframework.samples.petclinic.model.TrabajosProductos;
import org.springframework.samples.petclinic.service.ServicesAux;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/works")
public class TrabajoController {

    private static final String VIEW_LIST_TRABAJOS = "trabajos/listTrabajos";
    private static final String VIEW_CREATE_TRABAJOS = "trabajos/createTrabajos";
    private static final String VIEW_LIST_PRODUCTS_OF_WORK = "products/listProductosDeTrabajo";
    
    @Autowired
    ServicesAux service;

    @GetMapping()
    public String listTrabajos(ModelMap model){
        model.addAttribute("works", service.getAllTrabajos());
        return VIEW_LIST_TRABAJOS;
    }

    @GetMapping("/new")
    public String initWork(ModelMap model) {
        Trabajo trabajo = new Trabajo();
        List<Object> organizacion = new ArrayList<>();
        organizacion.addAll(service.getAllClinics());
        organizacion.addAll(service.getAllLaboratories());
    	model.addAttribute("trabajo", trabajo);
        model.addAttribute("doctores", service.getAllDoctors());
        model.addAttribute("pacientes", service.getAllPatients());
        model.addAttribute("clinicas", organizacion);
    	return VIEW_CREATE_TRABAJOS;
    }
    @PostMapping("/new")
    public String createWork(RedirectAttributes redirect, @Valid Trabajo t,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("message", "Error al crear");
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            return initWork(model);
        }
            
        else{
            service.createTrabajo(t);
            model.addAttribute("message", "Creación completada");
            return "redirect:/works";
        }
    }

    @GetMapping("/{workId}/delete")
    public String deleteWork(ModelMap model, @PathVariable("workId") Integer id){
        Trabajo t = service.getTrabajoById(id);
        if(t == null){
            model.addAttribute("message", "Trabajo no encontrado, compruebe si ya ha sido borrado");
            return listTrabajos(model);
        }
        service.deleteTrabajo(t);
        model.addAttribute("message", "Trabajo borrado");
        return listTrabajos(model);
    }

    @GetMapping("/{workId}/products")
    public String listProductsOfWork(ModelMap model, @PathVariable("workId") Integer workId){
        Trabajo trabajo = service.getTrabajoById(workId);
        model.addAttribute("patient", trabajo.getPaciente());
        model.addAttribute("doctor", trabajo.getDoctor());
        model.addAttribute("clinica", trabajo.getClinica());
        model.addAttribute("productsworks", service.getAllProductosWorksOf(trabajo));

        return VIEW_LIST_PRODUCTS_OF_WORK;
    }

    @GetMapping("/{workId}/products/{pwId}/delete")
    public String deleteProductsOfWork(ModelMap model, @PathVariable("workId") Integer workId, @PathVariable("pwId") Integer pwId){

        
        TrabajosProductos tp = service.getTrabajoProductoById(pwId);
        if(tp == null){
            model.addAttribute("message", "No se puede desasignar ese producto de este trabajo, compruebe si ya ha sido eliminado");
            return listProductsOfWork(model, workId);
        }
        service.deleteTrabajosProductos(tp);
        model.addAttribute("message", "Producto retirado de este trabajo");
        return listProductsOfWork(model, workId);
    }

    
}
