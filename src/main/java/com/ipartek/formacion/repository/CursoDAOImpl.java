package com.ipartek.formacion.repository;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.repository.mapper.CursoMapper;

/**
 * Implementacion del DAO de curso
 * @author Eneko
 *
 */
@Repository(value="cursoDAO")
public class CursoDAOImpl implements CursoDAO {
	
	private final Log LOG = LogFactory.getLog(getClass());

	@Autowired()
	private DataSource dataSource;	
	private JdbcTemplate jdbctemplate;

	@Autowired()
	@Override()
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(this.dataSource);

	}

	// Sentencias SQL
		private static final String SQL_GET_ALL = "SELECT `id`, `nombre`, `codigo` FROM `curso` ORDER BY `id` DESC";
		private static final String SQL_GET_ALL_HOME = "SELECT `id`, `nombre`, `codigo` FROM `curso` ORDER BY `id` DESC LIMIT 10;";
		private static final String SQL_ADD_CURSO ="INSERT INTO `curso` (`nombre`,`codigo`) VALUES (?,?) ";
		private static final String SQL_GET_BY_ID ="SELECT `id`, `nombre`, `codigo` FROM `curso` WHERE `id`= ? ";
		private static final String SQL_UPDATE = "UPDATE `curso` SET `nombre`= ? , `codigo`= ?  WHERE `id`= ? ";
		private static final String SQL_DELETE = "DELETE FROM `curso` WHERE `id`= ? ";
		private static final String SQL_AUTOCOMPLETE = "SELECT `id`, `nombre`, `codigo` FROM `curso` WHERE `nombre` LIKE '%' ? '%' OR `codigo` LIKE '%' ? '%' ;";		
		
	@Override()
	public List<Curso> getAll() {
		ArrayList<Curso> lista = new ArrayList<Curso>();
		this.LOG.trace("Recuperando usuarios");
		try {
			lista = (ArrayList<Curso>) this.jdbctemplate.query(SQL_GET_ALL, new CursoMapper());
		
		} catch (EmptyResultDataAccessException e) {

			this.LOG.warn("No existen cursos todavia",e);

		} catch (Exception e) {

			this.LOG.error("Excepcion inesperada",e);

		}

		return lista;
	}

	@Override()
	public List<Curso> getAllhome() {
		ArrayList<Curso> lista = new ArrayList<Curso>();
		this.LOG.trace("Recuperando 10 usuarios");
		try {

			lista = (ArrayList<Curso>) this.jdbctemplate.query(SQL_GET_ALL_HOME, new CursoMapper());

		} catch (EmptyResultDataAccessException e) {

			this.LOG.warn("No existen cursos todavia",e);

		} catch (Exception e) {

			this.LOG.error("Excepcion inesperada",e);

		}

		return lista;
	}
	
	@Override()
	public boolean insert(final Curso curso) throws DuplicateKeyException {
		boolean insertado = false;
		try{
		
		int lineasInsertadas = 0;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		lineasInsertadas = this.jdbctemplate.update(new PreparedStatementCreator() {
			@Override()
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement prepared = connection.prepareStatement(SQL_ADD_CURSO,
						Statement.RETURN_GENERATED_KEYS);
				prepared.setString(1, curso.getNombre());
				prepared.setString(2, curso.getCodigo());
				return prepared;
			}
		}, keyHolder);
		if (lineasInsertadas != 0) {
			insertado = true;
			curso.setId(keyHolder.getKey().intValue());
		}
		}catch(DuplicateKeyException e){
			throw new DuplicateKeyException("Curso ya insertada.");
		}

		return insertado;
	}

	@Override()
	public Curso getById(int idCurso) {
		Curso curso = this.jdbctemplate.queryForObject(SQL_GET_BY_ID,
				new Object[] { idCurso }, new CursoMapper());
		return curso;
	}
	
	@Override()
	public boolean update(Curso curso) {
		boolean modificado = false;
		int lineasModificadas = 0;
		lineasModificadas = this.jdbctemplate.update(SQL_UPDATE, curso.getNombre(),curso.getCodigo(), curso.getId());
		if (lineasModificadas != 0) {
			modificado = true;
		}
		return modificado;
	}

	@Override()
	public boolean delete(long idCurso) {
		boolean borrado = false;
		int lineasBorradas = 0;
		lineasBorradas = this.jdbctemplate.update(SQL_DELETE, idCurso);
		if (lineasBorradas != 0) {
			borrado = true;
		}
		return borrado;
	}

	@Override()
	public List<Curso> autocomplete(String filtro) {
		List<Curso> cursos = this.jdbctemplate.query(
				SQL_AUTOCOMPLETE, 
				new Object[] { filtro , filtro}, new CursoMapper());
		
		return cursos;
	}


}
