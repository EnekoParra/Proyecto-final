 package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Curso;

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
	
	List<Curso> getAllhome();
	
	Curso getById(int idCurso);
	
	boolean insert(Curso c);

	boolean update(Curso c);
	
	boolean delete(long id);
	
	List<Curso> autocomplete(String filtro);

	


}
