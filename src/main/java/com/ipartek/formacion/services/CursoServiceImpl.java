package com.ipartek.formacion.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.repository.CursoDAO;


/**
 * Implementacion del servicio de curso
 * @author Eneko
 *
 */
@Service(value = "cursoService")
public class CursoServiceImpl implements CursoService {
	
	

	
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired()
	private CursoDAO daoCurso;

	@Override()
	public List<Curso> listar() {
		this.logger.trace("listar cursos");
		return this.daoCurso.getAll();
	}
	
	@Override()
	public List<Curso> listarhome() {
		this.logger.trace("listar 10 ultimos cursos");
		return this.daoCurso.getAllhome();
	}

	@Override()
	public Curso getById(int idCurso) {
		this.logger.trace("Coger curso por id");
		return this.daoCurso.getById(idCurso);
	}

	@Override()
	public boolean crear(Curso c) {
		this.logger.trace("Creando curso: " + c);
		return this.daoCurso.insert(c);
	}

	@Override()
	public boolean modificar(Curso c) {
		this.logger.trace("Modificando curso: " + c);
		return this.daoCurso.update(c);
	}

	@Override()
	public boolean eliminar(long id) {
		this.logger.trace("Eliminando por id: " + id);
		return this.daoCurso.delete(id);
	}

	@Override()
	public List<Curso> autocomplete(String filtro) {
		return this.daoCurso.autocomplete(filtro);
	}

	


}
