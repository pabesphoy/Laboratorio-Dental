package org.springframework.samples.petclinic.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "trabajos_productos")
public class TrabajosProductos extends BaseEntity{

    @ManyToOne
    @MapsId("TRABAJO_ID") //This is the name of attr in RecipesIngredientsPK class
    @JoinColumn(name = "TRABAJO_ID")
    public Trabajo trabajo;

    @ManyToOne
    @MapsId("PRODUCTO_ID")
    @JoinColumn(name = "PRODUCTO_ID")
    public Producto producto;
    
    public Integer unidades;

    public Double precioPorUnidad;

    public Double descuento;

}
