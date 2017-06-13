package com.ipartek.formacion.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.repository.CursoDAO;
import com.ipartek.formacion.services.CursoService;
import com.opencsv.CSVReader;

/**
 * Controlador del admin
 * @author Eneko
 *
 */
@Controller()
public class AdminController {
	
	@Autowired()
	private CursoService cursoService;
	
	@Autowired()
	private CursoDAO daoCurso;
	
	
	private String msg = null;
	
	private static final String CSV= "c:\\Desarrollo\\Proyecto\\Proyecto-final\\deploy\\cursos.csv";

	
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
		Curso curso = null;
		ArrayList<Curso> sinInsertar = new ArrayList<Curso>();
		CSVReader reader = null;
		try {
	         reader = new CSVReader(new FileReader(CSV),';');
	         List<String[]> texto = reader.readAll();
	         boolean primeraLinea=true;

		     for (String[] linea: texto) {
		    	 try{
		        	 if(!primeraLinea){
		        		 curso= new Curso(linea[1],linea[8]);
		        		 this.cursoService.crear(curso);
		        		 this.msg = "Creado nuevo curso";
		        	 }
		        	 primeraLinea=false;
		        	 this.msg = "Creado nuevo curso";
		        	 
		    	 }catch(DuplicateKeyException  e)
	        	 {
	        		 e.printStackTrace();
	        		 sinInsertar.add(curso);
	        	 }
			}
		     reader.close();
	        
		        	
	         
	      }//end primer try
	      catch(Exception e){
       		 e.printStackTrace();
		        	
	      }finally 
	        	 {
    		 if (null != reader) 
    		 {
    			 try {
    				 reader.close();
    				 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    		 } //end if
	     	}//end finally
		this.msg = "No han sido creados "+ sinInsertar.size()+" cursos porque ya estan creados.";
		model.addAttribute("msg", this.msg);
		model.addAttribute("curso", this.cursoService.listar());
		return "admin/backoffice";
	}
}
