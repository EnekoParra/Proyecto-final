package com.ipartek.formacion.services;

import java.util.List;

import com.ipartek.formacion.domain.Curso;

/**
 * Servicio de Curso
 * @author Eneko
 *
 */
public interface CursoService {

	/**
	 * Listado de todos los Cursos
	 * 
	 * @return List<Curso> 
	 */
	List<Curso> listar();
	
	/**
	 * Listado de todos los cursos limitado a 10
	 * @return List<Curso>
	 */
	List<Curso> listarhome();
	
	/**
	 * Buscar curso por ID
	 * @param idCurso
	 * 			idCurso
	 * @return	Curso
	 */
	Curso getById(int idCurso);
	
	/**
	 *  Crear curso
	 * @param c
	 * 		c
	 * @return boolean
	 */
	boolean crear(Curso c);

	/**
	 * Modificar un curso
	 * @param c
	 * 			c
	 * @return boolean
	 */
	boolean modificar(Curso c);

	/**
	 * Eliminar un curso
	 * @param id
	 * 			id
	 * @return boolean
	 */
	boolean eliminar(long id);
	
	/**
	 * Autocomplete para el buscador
	 * @param filtro
	 * 			filtro
	 * @return List<Curso>
	 */
	List<Curso> autocomplete(String filtro);
	
	/**
	 * Migrar datos de BBDD
	 */
	void migrar();

}
