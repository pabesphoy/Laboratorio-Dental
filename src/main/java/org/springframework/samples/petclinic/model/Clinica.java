package org.springframework.samples.petclinic.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Clinica extends Cliente{

    @ManyToMany
    @JoinTable(name = "clinicas_doctores",
         joinColumns = @JoinColumn(name = "clinica_id"), inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    List<Doctor> doctores;
    
}
