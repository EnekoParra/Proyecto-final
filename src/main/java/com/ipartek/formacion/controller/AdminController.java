package com.ipartek.formacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.services.CursoService;

@Controller()
public class AdminController {
	
	@Autowired()
	private CursoService cursoService;
	
	/**
	 * Mapping para listar todos los cursos
	 * @param model
	 * @return admin/backoffice
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("curso", cursoService.listar());
		
		return "admin/backoffice";
	}
	
	/**
	 * Mapping para seleccionar curso por id
	 * @param curso 
	 * @return admin/curso
	 */
	@RequestMapping(value = "admin/detalle/{idCurso}", method = RequestMethod.GET)
	public String consultar(@PathVariable() int idCurso, Model model) {
		if(idCurso!=-1){
			model.addAttribute("curso", this.cursoService.getById(idCurso));
		}else{
			Curso curso = new Curso();
			model.addAttribute("curso", curso);
		}
		return "admin/curso";
	}
	
	/**
	 * Mapping para crear un nuevo curso
	 * @param curso 
	 * @return admin/backoffice
	 */
	@RequestMapping(value = "/admin/crear", method = RequestMethod.POST)
	public String crear(Curso curso, Model model, BindingResult bindingResult) {
		this.cursoService.crear(curso);
		model.addAttribute("curso", this.cursoService.listar());
		return "admin/backoffice";
	}
	
	
	/**
	 * Mapping para modificar un curso
	 * @param curso 
	 * @return admin/curso
	 */
	@RequestMapping(value = "/admin/modificar", method = RequestMethod.POST)
	public String modificar(Curso curso, Model model) {
		this.cursoService.modificar(curso);
		model.addAttribute("cursos", this.cursoService.listar());
		return "admin/backoffice";
	}
	
	/**
	 * Mapping para eliminar un curso
	 * @param curso 
	 * @return admin/curso
	 */
	
	@RequestMapping(value = "/admin/eliminar/{idCurso}", method = RequestMethod.GET)
	public String eliminar(@PathVariable() int idCurso, Model model) {
		this.cursoService.eliminar(idCurso);
		model.addAttribute("cursos", this.cursoService.listar());
		return "admin/backoffice";
	}
}
