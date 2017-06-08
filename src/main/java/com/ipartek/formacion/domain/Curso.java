package com.ipartek.formacion.domain;

public class Curso  {
	
	private long id;
	private String nombre;
	private String codigo;
	
	
	public Curso() {
		super();
		this.id = -1;
		this.nombre = "";
		this.codigo = "";
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}


	

	


	





	
	
	
	
}
