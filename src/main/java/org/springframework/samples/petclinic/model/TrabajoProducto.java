package org.springframework.samples.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "trabajos_productos")
public class TrabajoProducto extends BaseEntity{
    
    public Integer unidades;

    public Double precioPorUnidad;

    public Double descuento;
}
