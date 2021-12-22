package org.springframework.samples.petclinic.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto extends BaseEntity{

    private String nombre;

    private String codigo;

    private Double precioBase;

    private Double IVA;

    
    @ManyToMany
    @JoinTable(name = "productos_materiales")
    List<Material> materiales;


    @ManyToOne
    private Color color;

    @ManyToOne
    private CategoriaProducto categoria;




    
}
