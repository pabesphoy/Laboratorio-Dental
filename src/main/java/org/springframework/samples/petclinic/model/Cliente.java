package org.springframework.samples.petclinic.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.*;


@MappedSuperclass
@Getter @Setter
public class Cliente extends BaseEntity{
	
	String nombre;
	
	String direccion;
	
	String localidad;
	
	@Min(0)
	@Max(100)
	Double tarifa;
	
	String telefono;
	
	String email;
	
	
}
