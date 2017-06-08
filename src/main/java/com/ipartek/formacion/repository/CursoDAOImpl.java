package com.ipartek.formacion.repository;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
		private static final String SQL_GET_ALL = "SELECT `id`, `nombre`, `codigo` FROM `curso` ORDER BY `id` DESC LIMIT 1000;";
		private static final String SQL_ADD_CURSO ="INSERT INTO `curso` (`nombre`,`codigo`) VALUES (?)";
		private static final String SQL_GET_BY_ID ="SELECT `id`, `nombre`, `codigo` FROM `cursos` WHERE `id`= ?";
	
	@Override
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
	public boolean insert(final Curso curso) {
		boolean insertado = false;
		int lineasInsertadas = 0;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		lineasInsertadas = this.jdbctemplate.update(new PreparedStatementCreator() {
			@Override()
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement prepared = connection.prepareStatement(SQL_ADD_CURSO,
						Statement.RETURN_GENERATED_KEYS);
				prepared.setString(2, curso.getNombre());
				prepared.setString(3, curso.getCodigo());
				return prepared;
			}
		}, keyHolder);
		if (lineasInsertadas != 0) {
			insertado = true;
			curso.setId(keyHolder.getKey().intValue());
		}

		return insertado;
	}

	@Override
	public Curso getById(int idCurso) {
		Curso curso = this.jdbctemplate.queryForObject(SQL_GET_BY_ID,
				new Object[] { idCurso }, new CursoMapper());
		return curso;
	}
	
	@Override
	public boolean update(Curso c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
