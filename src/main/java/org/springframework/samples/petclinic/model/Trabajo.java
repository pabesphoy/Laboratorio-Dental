package org.springframework.samples.petclinic.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Trabajo extends BaseEntity{

    String codigo;

    //TipoOdontograma odontograma;

    @ManyToMany
    @JoinTable(name = "trabajos_productos")
    List<Producto> productos;


    /*
    public Albaran getAlbaran(){
        return null;
    }
    */
    
}
