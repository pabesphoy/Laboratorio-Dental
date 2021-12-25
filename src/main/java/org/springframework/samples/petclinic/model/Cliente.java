package org.springframework.samples.petclinic.model;

import javax.persistence.*;


import lombok.*;


@MappedSuperclass
@Getter @Setter
public class Cliente {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	Integer id;
	
	String nombre;
	
	String direccion;
	
	String localidad;
	
	Double tarifa;
	
	String telefono;
	
	String email;
	
	
}
