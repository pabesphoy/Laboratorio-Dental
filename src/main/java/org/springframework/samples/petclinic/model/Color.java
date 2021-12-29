package org.springframework.samples.petclinic.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Color extends BaseEntity{
    
    String guiaColor;

    String colorName; 

    String codigo;

    public String toString(){
        return colorName;
    }
}
