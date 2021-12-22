package org.springframework.samples.petclinic.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class Proveedor extends BaseEntity{

    String nombre;

    String direccion;

    String DNI;
    
}
