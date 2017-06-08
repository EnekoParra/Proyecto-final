package com.ipartek.formacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.services.CursoService;

@Controller()
public class CursoController {
	
	@Autowired()
	private CursoService cursoService;
	
	/**
	 * Mapping principal
	 * @param model 
	 * @return home
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
	
		return "home";
	}
	
	/**
	 * Mapping backoffice
	 * @param model 
	 * @return backoffice
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String backoffice(Model model) {
		
		model.addAttribute("curso", cursoService.listar());
	
		return "admin/backoffice";
	}
}
