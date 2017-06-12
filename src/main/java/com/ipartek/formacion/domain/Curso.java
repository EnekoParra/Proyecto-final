package com.ipartek.formacion.domain;

/**
 * Pojo de Curso
 * @author Eneko
 *
 */
public class Curso  {
	
	private long id;
	private String nombre;
	private String codigo;
	
	
	/**
	 * Consctuctor Curso
	 */
	public Curso() {
		super();
		this.id = -1;
		this.nombre = "";
		this.codigo = "";
	}


	/**
	 * Getter getId
	 * @return id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Setter setId
	 * @param id
	 * 			id
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * Getter Nombre
	 * @return nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Setter Nombre
	 * @param nombre
	 * 			nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter getCodigo
	 * @return codigo
	 */
	public String getCodigo() {
		return this.codigo;
	}

	/**
	 * Setter setCodigo
	 * @param codigo
	 * 			codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Override()
	public String toString() {
		return "Curso [id=" + this.id + ", nombre=" + this.nombre + ", codigo=" + this.codigo + "]";
	}


	

	


	





	
	
	
	
}
