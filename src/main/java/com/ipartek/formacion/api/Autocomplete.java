package com.ipartek.formacion.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.services.CursoService;

@Controller
@RequestMapping(value = "/api/")
public class Autocomplete {

	@Autowired
	CursoService cursoService;
	
	@RequestMapping(value="cursos", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> autocomplete(@RequestParam(value = "filtro", required = false) String filtro){

		List<Curso> cursos = null;
		if (filtro != null){
			cursos = this.cursoService.autocomplete(filtro);
		} else {
			cursos = this.cursoService.listar();
		}
		return cursos;
	}
	
}
