package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Curso;

/**
 * Mapper de Curso
 * @author Eneko
 *
 */
public class CursoMapper implements RowMapper<Curso> {

	@Override()
	public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
		Curso c = new Curso();

		c.setId(rs.getLong("id"));
		c.setNombre(rs.getString("nombre"));
		c.setCodigo(rs.getString("codigo"));
		

		return c;
	}
	
	

}
