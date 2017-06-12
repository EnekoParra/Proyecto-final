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

/**
 * Controlador del admin
 * @author Eneko
 *
 */
@Controller()
public class AdminController {
	
	@Autowired()
	private CursoService cursoService;
	
	/**
	 * Mapping para listar todos los cursos
	 * @param model
	 * 			model
	 * @return admin/backoffice
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("curso", this.cursoService.listar());
		
		return "admin/backoffice";
	}
	
	/**
	 * Consultar cursos
	 * @param idCurso
	 * 			idCurso
	 * @param model
	 * 			model
	 * @return admin/curso
	 */
	@RequestMapping(value = "admin/curso/{idCurso}", method = RequestMethod.GET)
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
	 * Crear curso
	 * @param curso
	 * 			curso
	 * @param model
	 * 			model
	 * @param bindingResult
	 * 			bindingResult
	 * @return admin/backoffice
	 */
	@RequestMapping(value = "/admin/crear", method = RequestMethod.POST)
	public String crear(Curso curso, Model model, BindingResult bindingResult) {
		this.cursoService.crear(curso);
		model.addAttribute("curso", this.cursoService.listar());
		return "admin/backoffice";
	}
	
	
	/**
	 * Modificar curso
	 * @param curso
	 * 			curso
	 * @param model
	 * 			model
	 * @return admin/backoffice
	 */
	@RequestMapping(value = "/admin/modificar", method = RequestMethod.POST)
	public String modificar(Curso curso, Model model) {
		this.cursoService.modificar(curso);
		model.addAttribute("curso", this.cursoService.listar());
		return "admin/backoffice";
	}
	
	
	/**
	 * Eliminar curso
	 * @param idCurso
	 * 			idCurso
	 * @param model
	 * 			model
	 * @return admin/backoffice
	 */
	@RequestMapping(value = "/admin/eliminar/{idCurso}", method = RequestMethod.GET)
	public String eliminar(@PathVariable() int idCurso, Model model) {
		this.cursoService.eliminar(idCurso);
		model.addAttribute("curso", this.cursoService.listar());
		return "admin/backoffice";
	}
	

	/**
	 * Migrar datos de BBDD
	 * @param model
	 * 			model
	 * @return admin/backoffice
	 */
	@RequestMapping(value = "/admin/migrar", method = RequestMethod.GET)
	public String migrar(Model model) {
		this.cursoService.migrar();
		model.addAttribute("curso", this.cursoService.listar());
		return "admin/backoffice";
	}
}
