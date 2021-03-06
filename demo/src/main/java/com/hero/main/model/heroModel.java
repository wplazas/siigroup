package com.hero.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_heroes")
public class heroModel {	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String poderes;

    public heroModel(){}

    public heroModel (String nombre,String poderes){
          this.nombre=nombre;
          this.poderes=poderes;
    }

    public Long getId(){
        return id;
    }

	public String getnombre() {
		return nombre;
	}
    
    public String getpoderes(){
        return poderes;
    }

    public void setnombre(String nombre){
        this.nombre = nombre;
    }

    public void setpoderes(String poderes){
        this.poderes = poderes;
    }
    

	

}
