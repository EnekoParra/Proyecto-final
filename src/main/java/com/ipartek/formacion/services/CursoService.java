package com.ipartek.formacion.services;

import java.util.List;

import com.ipartek.formacion.domain.Curso;

public interface CursoService {

	/**
	 * Lista los cursos 
	 *

	 * @return
	 */
	List<Curso> listar();
	
	Curso getById(int idCurso);
	
	boolean crear(Curso c);

	boolean modificar(Curso c);

	boolean eliminar(long id);
}
