package org.springframework.samples.petclinic.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.CategoriaMaterial;
import org.springframework.samples.petclinic.model.Material;
import org.springframework.samples.petclinic.model.Proveedor;
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
@RequestMapping("/materials")
public class MaterialController {

    private static final String VIEW_LIST_MATERIALES = "materiales/listMateriales";
    private static final String VIEW_CREATE_MATERIALES = "materiales/createMateriales";

    private static final String VIEW_LIST_CATEGORIAS_MATERIALES = "materiales/listCategoriasMateriales";
    private static final String VIEW_CREATE_CATEGORIA_MATERIALES = "materiales/createCategoriaMateriales";

    private static final String VIEW_LIST_SUPPLIERS_OF_MATERIAL = "materiales/listProveedoresOfMaterial";
    private static final String VIEW_CREATE_SUPPLIER_OF_MATERIAL = "materiales/createProveedorOfMaterial";
    
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
        if(!model.containsAttribute("material"))
    	    model.addAttribute("material", m);
        model.addAttribute("categorias", service.getAllCategoriasMateriales());
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

    @GetMapping("/{id}/edit")
    public String editMaterial(ModelMap model, @PathVariable("id") Integer id){
        Material m = service.getMaterialById(id);
        if(m == null){
            model.addAttribute("message", "Material no encontrado");
            return listMaterials(model);
        }

        model.addAttribute("material", m);
        return initMaterial(model);
    }

    @PostMapping("/{id}/edit")
    public String updateMaterial(RedirectAttributes redirect, @Valid Material material, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            model.addAttribute("message", "Error al editar");
            return initMaterial(model);
    }else{
            service.createMaterial(material);
            model.addAttribute("message", "Edicion completa");
            return "redirect:/materials";
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
        if(!model.containsAttribute("categoria"))
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

    @GetMapping("/categoriasMateriales/{id}/edit")
    public String editCategoriaMaterial(ModelMap model, @PathVariable("id") Integer id){
        CategoriaMaterial c = service.getCategoriaMaterialById(id);
        if(c == null){
            model.addAttribute("message", "Categoría no encontrada");
            return listCategoriasMateriales(model);
        }

        model.addAttribute("categoria", c);
        return initCategoriaMateriales(model);
    }

    @PostMapping("/categoriasMateriales/{id}/edit")
    public String updateCategoriaMaterial(RedirectAttributes redirect, @Valid CategoriaMaterial categoriaMaterial, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            model.addAttribute("message", "Error al editar");
            return initCategoriaMateriales(model);
    }else{
            service.createCategoriaMaterial(categoriaMaterial);
            model.addAttribute("message", "Edicion completa");
            return "redirect:/materials/categoriasMateriales";
        }
    }

    @GetMapping("/categoriasMateriales/{id}/delete")
    public String deleteCategoriaMateriales(ModelMap model, @PathVariable("id") Integer id){
        CategoriaMaterial cat = service.getCategoriaMaterialById(id);
        if(cat == null){
            model.addAttribute("message", "Categoria material no encontrada, compruebe si ya ha sido borrada");
            return listCategoriasMateriales(model);
        }

        service.deleteCategoriaMaterial(cat);
        model.addAttribute("message", "Categoria eliminada");
        return listCategoriasMateriales(model);
    }

    @GetMapping("/{materialId}/suppliers")
    public String listSuppliersOfMaterial(ModelMap model, @PathVariable("materialId") Integer id){
        Material material = service.getMaterialById(id);
        model.addAttribute("suppliers", service.getAllProveedoresOfMaterial(material));
        model.addAttribute("material", material);
        return VIEW_LIST_SUPPLIERS_OF_MATERIAL;

    }

    @GetMapping("/{materialId}/suppliers/new")
    public String newSupplierOfMaterial(ModelMap model, @PathVariable("materialId") Integer id){
        Material material = service.getMaterialById(id);
        model.addAttribute("suppliers", service.getAllNotProveedoresOfMaterial(material));
        model.addAttribute("material", material);
        return VIEW_CREATE_SUPPLIER_OF_MATERIAL;

    }

    @RequestMapping(value = "/{materialId}/suppliers/new", method = RequestMethod.POST)
    public String addSupplierToMaterial(ModelMap model,@RequestParam("supplier") Integer supplierId, HttpServletResponse response, @PathVariable("materialId") Integer id){
        Material material = service.getMaterialById(id);
        Proveedor proveedor = service.getProveedorById(supplierId);

        if(material.getProveedores().contains(proveedor)){
            model.addAttribute("message", "Este proveedor ya es proveedor de este material. Compruebe si ya está añadido.");
        }else{
            model.addAttribute("message", "Proveedor añadido");
            material.getProveedores().add(proveedor);
            service.createMaterial(material);
        }

        return listSuppliersOfMaterial(model, id);
    }

    @GetMapping("/{materialId}/suppliers/{supplierId}/delete")
    public String deleteSupplierOfMaterial(ModelMap model, @PathVariable("materialId") Integer materialId, @PathVariable("supplierId") Integer supplierId){
        Material material = service.getMaterialById(materialId);
        Proveedor proveedor = service.getProveedorById(supplierId);

        try {

            if(material.getProveedores().contains(proveedor)){
                material.getProveedores().remove(proveedor);
                service.createMaterial(material);
                model.addAttribute("message", "Proveedor eliminado de este material");
            }else{
                model.addAttribute("message", "Este proveedor no es proveedor de este material");
            }   
            
        
        } catch (Exception e) {
            model.addAttribute("message", "Error al eliminar proveedor al material");
            e.printStackTrace();
        }

        return listSuppliersOfMaterial(model, materialId);
    }

    
}
