package org.springframework.samples.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Material extends BaseEntity{

    String nombre;

    String codigo;

    String marcaFabricante;

    Integer numeroDeLote;

    @ManyToOne
    CategoriaMaterial categoria;

    //PROVEEDOR
    
}
