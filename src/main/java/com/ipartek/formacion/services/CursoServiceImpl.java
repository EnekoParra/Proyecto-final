package com.ipartek.formacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.repository.CursoDAO;

@Service(value="cursoService")
public class CursoServiceImpl implements CursoService {
	
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private CursoDAO daoCurso;

	@Override
	public List<Curso> listar() {
		logger.trace("listar cursos");
		return daoCurso.getAll();
	}
	
	@Override
	public Curso getById(int idCurso) {
		logger.trace("Coger curso por id");
		return this.daoCurso.getById(idCurso);
	}

	@Override
	public boolean crear(Curso c) {
		logger.trace("Creando curso: " + c);
		return daoCurso.insert(c);
	}

	@Override
	public boolean modificar(Curso c) {
		logger.trace("Modificando curso: " + c);
		return daoCurso.update(c);
	}

	@Override
	public boolean eliminar(long id) {
		logger.trace("Eliminando por id: " + id);
		return daoCurso.delete(id);
	}

}
