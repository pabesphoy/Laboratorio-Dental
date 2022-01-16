package org.springframework.samples.petclinic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Proveedor;
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
@RequestMapping("/suppliers")
public class ProveedorController {

    private static final String VIEW_LIST_PROVEEDORES = "proveedores/listProveedores";
    private static final String VIEW_CREATE_PROVEEDORES = "proveedores/createProveedores";
    
    @Autowired
    ServicesAux service;

    @GetMapping()
    public String listProveedores(ModelMap model){
        model.addAttribute("proveedores", service.getAllProveedores());
        return VIEW_LIST_PROVEEDORES;
    }

    @GetMapping("/new")
    public String initProveedor(ModelMap model) {
        Proveedor p = new Proveedor();
        if(!model.containsAttribute("proveedor"))
    	    model.addAttribute("proveedor", p);
    	return VIEW_CREATE_PROVEEDORES;
    }
    @PostMapping("/new")
    public String createMaterial(RedirectAttributes redirect, @Valid  Proveedor p ,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("message", "Error al crear");
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            return initProveedor(model);
        }
            
        else{
            service.createProveedor(p);
            model.addAttribute("message", "Creación completada");
            return "redirect:";
        }
    }

    @GetMapping("/{id}/edit")
    public String editProveedor(ModelMap model, @PathVariable("id") Integer id){
        Proveedor p = service.getProveedorById(id);
        if(p == null){
            model.addAttribute("message", "Proveedor no encontrado");
            return listProveedores(model);
        }

        model.addAttribute("proveedor", p);
        return initProveedor(model);
    }

    @PostMapping("/{id}/edit")
    public String updateProveedor(RedirectAttributes redirect, @Valid Proveedor proveedor, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            model.addAttribute("message", "Error al editar");
            return initProveedor(model);
    }else{
            service.createProveedor(proveedor);
            model.addAttribute("message", "Edicion completa");
            return "redirect:/suppliers";
        }
    }

    @GetMapping("{proveedorId}/delete")
    public String deleteProveedor(ModelMap model, @PathVariable("proveedorId") Integer id){
        Proveedor p = service.getProveedorById(id);
        if(p == null){
            model.addAttribute("message", "Proveedor no encontrado, compruebe si ya ha sido borrado");
            return listProveedores(model);
        }
        service.deleteProveedor(p);
        model.addAttribute("message", "Proveedor eliminado");
        return listProveedores(model);
    }

    
}
