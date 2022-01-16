package org.springframework.samples.petclinic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Color;
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
@RequestMapping("/colores")
public class ColorController {

    private static String VIEW_LIST_COLORES = "colores/listColores";
    private static String VIEW_CREATE_OR_UPDATE_COLORES = "colores/createOrUpdateColores";

    @Autowired
    private ServicesAux service;

    @GetMapping()
    public String listColors(ModelMap model){
        model.addAttribute("colores", service.getAllColors());
        return VIEW_LIST_COLORES;
    }

    @GetMapping("/new")
    public String initColor(ModelMap model){
        Color color = new Color();
        if(!model.containsAttribute("color"))
            model.addAttribute("color", color);
        return VIEW_CREATE_OR_UPDATE_COLORES;
    }

    @PostMapping("/new")
    public String createColor(RedirectAttributes redirect, @Valid Color color, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("message", "Error al crear");
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            return initColor(model);
        }else{
            service.createColor(color);
            model.addAttribute("message", "Creación completada");
            return "redirect:";
        }
    }

    @GetMapping("/{id}/edit")
    public String editColor(ModelMap model, @PathVariable("id") Integer id){
        Color color = service.getColorById(id);
        if(color == null){
            model.addAttribute("message", "Color no encontrado");
            return listColors(model);
        }else{
            model.addAttribute("color", color);
            return initColor(model);
        } 
    }

    @PostMapping("/{id}/edit")
    public String updateColor(RedirectAttributes redirect, @Valid Color color,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            result.getAllErrors().stream().forEach(error -> System.err.println(error.getDefaultMessage()));
            model.addAttribute("message", "Error al editar");
            return initColor(model);
    }else{
            service.createColor(color);
            model.addAttribute("message", "Edicion completa");
            return "redirect:/colores";
        }
    }


    @GetMapping("{colorId}/delete")
    public String deleteColors(ModelMap modelMap, @PathVariable("colorId") Integer colorId){
        Color color = service.getColorById(colorId);

        if (color == null) {
            modelMap.addAttribute("message", "Este color no existe, comprueba si ya ha sido borrado");
            return listColors(modelMap);
        } else {
            try {
                service.deleteColor(color);
                modelMap.addAttribute("message", "Color borrado");
                return listColors(modelMap);
            } catch (Exception e) {
                modelMap.addAttribute("message", "Error al eliminar color");
                return listColors(modelMap);
            }
        }
    }
    
}
