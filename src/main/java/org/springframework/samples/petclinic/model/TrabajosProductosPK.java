package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TrabajosProductosPK {

    @Column(name = "trabajo_id")
    private Long trabajo_id;

     @Column(name = "producto_id")
    private Long producto_id;
    
}
