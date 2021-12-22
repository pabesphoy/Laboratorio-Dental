package org.springframework.samples.petclinic.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CategoriaProducto extends BaseEntity{

    String nombre;

    String codigo;
    
}
