package com.ipartek.formacion.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ipartek.formacion.services.CursoService;


/**
 * Controllador de Curso
 * @author Eneko
 *
 */
@Controller()
public class CursoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CursoController.class);
	
	@Autowired()
	private CursoService cursoService;
	
	/**
	 * Mapping principal
	 * @param model 
	 * @return home
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		LOG.info("Listado de los diez ultimos cursos creados");
		model.addAttribute("curso", this.cursoService.listarhome());
	
		return "home";
	}
	
	/**
	 * Mapping backoffice
	 * @param model 
	 * @return backoffice
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String backoffice(Model model) {
		LOG.info("Listado de todos los cursos");
		model.addAttribute("curso", this.cursoService.listar());
	
		return "admin/backoffice";
	}
	

}
