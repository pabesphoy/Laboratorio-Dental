package org.springframework.samples.petclinic.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.CategoriaProducto;
import org.springframework.samples.petclinic.model.Material;
import org.springframework.samples.petclinic.model.Producto;
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
@RequestMapping("/products")
public class ProductoController {

    private static final String VIEW_LIST_PRODUCTOS = "products/listProductos";
    private static final String VIEW_CREATE_PRODUCTOS = "products/createProductos";

    private static final String VIEW_LIST_CATEGORIAS_PRODUCTOS = "products/listCategoriaProductos";
    private static final String VIEW_CREATE_CATEGORIA_PRODUCTOS = "products/createCategoriaProductos";

    private static final String VIEW_LIST_MATERIALS_OF_PRODUCT = "products/listMaterialsOfProduct";
    private static final String VIEW_CREATE_MATERIAL_OF_PRODUCT = "products/createMaterialOfProduct";
    
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
        if(!model.containsAttribute("product"))
    	    model.addAttribute("product", p);
        model.addAttribute("colores", service.getAllColors());
        model.addAttribute("categorias", service.getAllCategoriasProductos());
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
            return "redirect:";
        }
    }

    @GetMapping("/{id}/edit")
    public String editProducto(ModelMap model, @PathVariable("id") Integer id){
        Producto p = service.getProductoById(id);
        if(p == null){
            model.addAttribute("message", "Producto no encontrado");
            return listProductos(model);
        }

        model.addAttribute("product", p);
        return initProduct(model);
    }

    @PostMapping("/{id}/edit")
    public String updateProducto(RedirectAttributes redirect, @Valid Producto producto, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            model.addAttribute("message", "Error al editar");
            return initProduct(model);
    }else{
            service.createProduct(producto);
            model.addAttribute("message", "Edicion completa");
            return "redirect:/products";
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(ModelMap model, @PathVariable("id") Integer id){
        Producto p = service.getProductoById(id);
        if(p == null){
            model.addAttribute("message", "Producto no encontrado, compruebe si ya ha sido borrado");
            return listProductos(model);
        }

        service.deleteProduct(p);
        model.addAttribute("message", "Producto eliminado");
        return listProductos(model);
    }

    @GetMapping("{id}/materials")
    public String listMaterialsOfProduct(ModelMap model, @PathVariable("id") Integer id){
        Producto p = service.getProductoById(id);
        model.addAttribute("materials", service.getAllMaterialesOf(p));
        model.addAttribute("product", p);
        return VIEW_LIST_MATERIALS_OF_PRODUCT;
    }

    @GetMapping("{id}/materials/new")
    public String newMaterialOfProduct(ModelMap model, @PathVariable("id") Integer id){
        Producto p = service.getProductoById(id);
        model.addAttribute("materials", service.getAllNotMaterialesOf(p));
        model.addAttribute("product", p);
        return VIEW_CREATE_MATERIAL_OF_PRODUCT;
    }

    @RequestMapping(value = "/{id}/materials/new", method = RequestMethod.POST)
    public String addMaterialToProduct(ModelMap model, @RequestParam("material") Integer materialId, HttpServletResponse response, @PathVariable("id") Integer id){
        Producto producto = service.getProductoById(id);
        Material material = service.getMaterialById(materialId);

        if(producto.getMateriales().contains(material)){
            model.addAttribute("message", "Este material ya pertenece a este producto. Compruebe si ya está añadido.");
        }else{
            model.addAttribute("message", "Material añadido");
            producto.getMateriales().add(material);
            service.createProduct(producto);
        }

        return listMaterialsOfProduct(model, id);
    }

    @GetMapping("/{id}/materials/{materialId}/delete")
    public String deleteMaterialFromProduct(ModelMap model, @PathVariable("id") Integer id, @PathVariable("materialId") Integer materialId){

        Producto producto = service.getProductoById(id);
        Material material = service.getMaterialById(materialId);

        if(producto.getMateriales().contains(material)){
            producto.getMateriales().remove(material);
            service.createProduct(producto);
            model.addAttribute("message", "Material retirado del producto");
        }else{
            model.addAttribute("message", "Error al retirar material del producto, confirme si ya fue retirado");
        }

        return listMaterialsOfProduct(model, id);
    }

    @GetMapping("/categoriasProductos")
    public String listCategoriasProductos(ModelMap model){

        model.addAttribute("categorias", service.getAllCategoriasProductos());
        return VIEW_LIST_CATEGORIAS_PRODUCTOS;
    }

    @GetMapping("/categoriasProductos/new")
    public String initCategoriaProducto(ModelMap model) {
        CategoriaProducto cat = new CategoriaProducto();
        if(!model.containsAttribute("categoria"))
    	    model.addAttribute("categoria", cat);
    	return VIEW_CREATE_CATEGORIA_PRODUCTOS;
    }
    @PostMapping("/categoriasProductos/new")
    public String createCategoriaProducto(RedirectAttributes redirect, @Valid CategoriaProducto cat, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("message", "Error al crear");
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            return initCategoriaProducto(model);
        }
            
        else{
            service.createCategoriaProducto(cat);
            model.addAttribute("message", "Creación completada");
            return "redirect:/products/categoriasProductos";
        }
    }

    @GetMapping("/categoriasProductos/{id}/edit")
    public String editCategoriaProducto(ModelMap model, @PathVariable("id") Integer id){
        CategoriaProducto c = service.getCategoriaProductosById(id);
        if(c == null){
            model.addAttribute("message", "Categoria de producto no encontrado");
            return listCategoriasProductos(model);
        }

        model.addAttribute("categoria", c);
        return initCategoriaProducto(model);
    }

    @PostMapping("/categoriasProductos/{id}/edit")
    public String updateCategoriaProducto(RedirectAttributes redirect, @Valid CategoriaProducto categoriaProducto, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            model.addAttribute("message", "Error al editar");
            return initCategoriaProducto(model);
    }else{
            service.createCategoriaProducto(categoriaProducto);
            model.addAttribute("message", "Edicion completa");
            return "redirect:/products/categoriasProductos";
        }
    }

    @GetMapping("/categoriasProductos/{categoriaProductoId}/delete")
    public String deleteCategoriaProducto(ModelMap model, @PathVariable("categoriaProductoId") Integer id){
        CategoriaProducto cat = service.getCategoriaProductosById(id);
        if(cat == null){
            model.addAttribute("message", "Categoria producto no encontrada, compruebe si ya ha sido borrada");
            return listCategoriasProductos(model);
        }

        service.deleteCategoriaProducto(cat);
        model.addAttribute("message", "Categoria eliminada");
        return listCategoriasProductos(model);
    }
    
}
