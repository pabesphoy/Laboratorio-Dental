package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CategoriaProducto extends BaseEntity{

    String nombre;

    @Column(unique = true)
    String codigo;

    public String toString(){
        return nombre;
    }
    
}
