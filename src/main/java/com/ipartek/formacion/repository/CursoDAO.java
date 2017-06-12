 package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Curso;

/**
 * DAO de Curso
 * @author Eneko
 *
 */
public interface CursoDAO {
	

	/**
	 * Conexion a BBDD
	 * @param dataSource pool de conexiones
	 */
	void setDataSource(DataSource dataSource);
	
	/**
	 * Listado de todos los Cursos
	 * 
	 * @return List<Curso> 
	 */
	List<Curso> getAll();
	
	/**
	 * Listado de todos los cursos limitado a 10
	 * @return List<Curso>
	 */
	List<Curso> getAllhome();
	
	/**
	 * Buscar curso por ID
	 * @param idCurso
	 * 			idCurso
	 * @return	Curso
	 */
	Curso getById(int idCurso);
	
	/**
	 *  Insertar curso
	 * @param c
	 * 		c
	 * @return boolean
	 */
	boolean insert(Curso c);

	/**
	 * Actualizar un curso
	 * @param c
	 * 			c
	 * @return boolean
	 */
	boolean update(Curso c);
	
	/**
	 * Borrar un curso
	 * @param id
	 * 			id
	 * @return boolean
	 */
	boolean delete(long id);
	
	/**
	 * Autocomplete para el buscador
	 * @param filtro
	 * 			filtro
	 * @return List<Curso>
	 */
	List<Curso> autocomplete(String filtro);

	


}
