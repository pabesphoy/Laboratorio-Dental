package org.springframework.samples.petclinic.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Trabajo extends BaseEntity{

    //TipoOdontograma odontograma;
    @ManyToOne
    Clinica clinica;

    @ManyToOne
    Doctor doctor;

    @ManyToOne
    Laboratorio laboratorio;

    @ManyToOne
    Paciente paciente;
    /*
    @ManyToMany
	@JoinTable(name = "games_markets",
		joinColumns = {@JoinColumn(name = "fk_game")},
		inverseJoinColumns = {@JoinColumn(name = "fk_market")})
	private List<MarketCard> items;		
    */

    @ManyToMany
    @JoinTable(name = "trabajos_productos",
        joinColumns = {@JoinColumn(name="trabajo_id")},
        inverseJoinColumns = {@JoinColumn(name = "producto_id")})
    List<Producto> productos;


    /*
    public Albaran getAlbaran(){
        return null;
    }
    */
    
}
