package com.ipartek.formacion.services;

import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.repository.CursoDAO;
import com.opencsv.CSVReader;

@Service(value = "cursoService")
public class CursoServiceImpl implements CursoService {

	private static final String CSV= "c:\\Desarrollo\\Proyecto\\Proyecto-final\\src\\main\\resources\\cursos.csv";
	
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private CursoDAO daoCurso;

	@Override
	public List<Curso> listar() {
		logger.trace("listar cursos");
		return daoCurso.getAll();
	}
	
	@Override
	public List<Curso> listarhome() {
		logger.trace("listar 10 ultimos cursos");
		return daoCurso.getAllhome();
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

	@Override
	public List<Curso> autocomplete(String filtro) {
		return this.daoCurso.autocomplete(filtro);
	}

	@Override
	public void migrar() {
		try {
			int cont = 0;
			CSVReader reader = new CSVReader(new FileReader(CSV), ';');
			List<String[]> myEntries = reader.readAll();
			for (String[] linea : myEntries) {
				if (cont != 0) {
					Curso curso = new Curso();
					curso.setNombre(linea[1]);
					curso.setCodigo(linea[8]);
					if (!"".equals(curso.getCodigo()) && !"".equals(curso.getNombre())) {
						this.daoCurso.insert(curso);
					}
				}
				cont++;
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
