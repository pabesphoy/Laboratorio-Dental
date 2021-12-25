package org.springframework.samples.petclinic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Producto;
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
@RequestMapping("/products")
public class ProductoController {

    private static final String VIEW_LIST_PRODUCTOS = "products/listProductos";
    private static final String VIEW_CREATE_PRODUCTOS = "products/createProductos";
    
    @Autowired
    ServicesAux service;

    @GetMapping()
    public String listProductos(ModelMap model){
        model.addAttribute("products", service.getAllProductos());
        return VIEW_LIST_PRODUCTOS;
    }

    @GetMapping("/new")
    public String initProduct(ModelMap model) {
        Producto p = new Producto();
    	model.addAttribute("product", p);
    	return VIEW_CREATE_PRODUCTOS;
    }
    @PostMapping("/new")
    public String createProducto(RedirectAttributes redirect, @Valid Producto p,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("message", "Error al crear");
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            return initProduct(model);
        }
            
        else{
            service.createProduct(p);
            model.addAttribute("message", "Creación completada");
            return listProductos(model);
        }
    }

    @GetMapping("/{productoId}/delete")
    public String deleteProduct(ModelMap model, @PathVariable("productoId") Integer id){
        Producto p = service.getProductoById(id);
        if(p == null){
            model.addAttribute("message", "Producto no encontrado, compruebe si ya ha sido borrado");
            return listProductos(model);
        }

        service.deleteProduct(p);
        model.addAttribute("message", "Producto eliminado");
        return listProductos(model);
    }

    
}
