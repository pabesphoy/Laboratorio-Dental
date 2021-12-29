package org.springframework.samples.petclinic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.CategoriaMaterial;
import org.springframework.samples.petclinic.model.Material;
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
@RequestMapping("/materials")
public class MaterialController {

    private static final String VIEW_LIST_MATERIALES = "materiales/listMateriales";
    private static final String VIEW_CREATE_MATERIALES = "materiales/createMateriales";

    private static final String VIEW_LIST_CATEGORIAS_MATERIALES = "materiales/listCategoriasMateriales";
    private static final String VIEW_CREATE_CATEGORIA_MATERIALES = "materiales/createCategoriaMateriales";
    
    @Autowired
    ServicesAux service;

    @GetMapping()
    public String listMaterials(ModelMap model){
        model.addAttribute("materials", service.getAllMateriales());
        return VIEW_LIST_MATERIALES;
    }

    @GetMapping("/new")
    public String initMaterial(ModelMap model) {
        Material m = new Material();
    	model.addAttribute("material", m);
        model.addAttribute("proveedores", service.getAllProveedores());
    	return VIEW_CREATE_MATERIALES;
    }
    @PostMapping("/new")
    public String createMaterial(RedirectAttributes redirect, @Valid Material m,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("message", "Error al crear");
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            return "redirect:";
        }
            
        else{
            service.createMaterial(m);
            model.addAttribute("message", "Creación completada");
            return listMaterials(model);
        }
    }

    @GetMapping("/{materialId}/delete")
    public String deleteMaterial(ModelMap model, @PathVariable("materialId") Integer id){
        Material m = service.getMaterialById(id);
        if(m == null){
            model.addAttribute("message", "Material no encontrado, compruebe si ya ha sido borrado");
            return listMaterials(model);
        }

        service.deleteMaterial(m);
        model.addAttribute("message", "Material eliminado");
        return listMaterials(model);
    }

    @GetMapping("/categoriasMateriales")
    public String listCategoriasMateriales(ModelMap model){

        model.addAttribute("categorias", service.getAllCategoriasMateriales());
        return VIEW_LIST_CATEGORIAS_MATERIALES;
    }

    @GetMapping("/categoriasMateriales/new")
    public String initCategoriaMateriales(ModelMap model) {
        CategoriaMaterial cat = new CategoriaMaterial();
    	model.addAttribute("categoria", cat);
    	return VIEW_CREATE_CATEGORIA_MATERIALES;
    }
    @PostMapping("/categoriasMateriales/new")
    public String createCategoriaMateriales(RedirectAttributes redirect, @Valid CategoriaMaterial cat, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("message", "Error al crear");
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            return initCategoriaMateriales(model);
        }
            
        else{
            service.createCategoriaMaterial(cat);
            model.addAttribute("message", "Creación completada");
            return "redirect:/materials/categoriasMateriales";
        }
    }

    @GetMapping("/categoriasMateriales/{categoriaMaterialId}/delete")
    public String deleteCategoriaMateriales(ModelMap model, @PathVariable("categoriaMaterialId") Integer id){
        CategoriaMaterial cat = service.getCategoriaMaterialById(id);
        if(cat == null){
            model.addAttribute("message", "Categoria material no encontrada, compruebe si ya ha sido borrada");
            return listCategoriasMateriales(model);
        }

        service.deleteCategoriaMaterial(cat);
        model.addAttribute("message", "Categoria eliminada");
        return listCategoriasMateriales(model);
    }

    
}
