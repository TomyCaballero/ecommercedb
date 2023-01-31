package org.generation.ecommercedb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
   private String nombre;
   private String descripion;
   private String imagen;
   private double precio;


public Producto(String nombre, String descripion, String imagen, double precio) {
	super();
	this.nombre = nombre;
	this.descripion = descripion;
	this.imagen = imagen;
	this.precio = precio;
}

public Producto() {
}


public Long getId() {
	return id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDescripion() {
	return descripion;
}

public void setDescripion(String descripion) {
	this.descripion = descripion;
}

public String getImagen() {
	return imagen;
}

public void setImagen(String imagen) {
	this.imagen = imagen;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

@Override
public String toString() {
	return "Producto [nombre=" + nombre + ", descripion=" + descripion + ", imagen=" + imagen + ", precio=" + precio
			+ "]";
}


   
   
   
}
