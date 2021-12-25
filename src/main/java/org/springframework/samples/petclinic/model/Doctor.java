package org.springframework.samples.petclinic.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Doctor extends Cliente{

    Integer numeroColegiado;

    String DNI;

    @ManyToMany
    List<Clinica> clinica;
    
}
