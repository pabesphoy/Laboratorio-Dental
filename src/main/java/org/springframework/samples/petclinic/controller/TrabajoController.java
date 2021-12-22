package org.springframework.samples.petclinic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Trabajo;
import org.springframework.samples.petclinic.service.ServicesAux;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/works")
public class TrabajoController {

    private static final String VIEW_LIST_TRABAJOS = "trabajos/listTrabajos";
    private static final String VIEW_CREATE_TRABAJOS = "trabajos/createTrabajos";
    
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
    	model.addAttribute("trabajo", trabajo);
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
            return listTrabajos(model);
        }
    }

    
}
