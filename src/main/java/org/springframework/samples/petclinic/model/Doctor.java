package org.springframework.samples.petclinic.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Doctor extends Cliente{

    Integer numeroColegiado;

    String DNI;
    
}
