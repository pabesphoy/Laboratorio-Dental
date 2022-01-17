package org.springframework.samples.petclinic.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Material extends BaseEntity{

    String nombre;

    @Column(unique = true)
    String codigo;

    String marcaFabricante;

    Integer numeroDeLote;

    @ManyToOne
    CategoriaMaterial categoria;

    @ManyToMany
    List<Proveedor> proveedores;
    
}
