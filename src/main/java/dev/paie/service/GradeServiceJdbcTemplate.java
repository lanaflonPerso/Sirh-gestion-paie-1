package dev.paie.service;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import dev.paie.entite.Grade;

public class GradeServiceJdbcTemplate implements GradeService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {

		String sql = "INSERT INTO grade VALUES (NULL, ?, ?, ?)";
		jdbcTemplate.update(sql, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());
	}

	@Override
	public void mettreAJour(Grade grade) {
		// TODO Auto-generated method stub

		jdbcTemplate.update("UPDATE `sirh-paie`.grade SET code=?, nbHeuresBase=?, tauxBase=?  WHERE id=?;",
				grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), grade.getId());

	}

	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM Grade";
		return jdbcTemplate.query(sql, new GradeMapper());
	}

	public class GradeMapper implements RowMapper<Grade> {

		@Override
		public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
			Grade grade = new Grade();
			grade.setId(rs.getInt("id"));
			grade.setCode(rs.getString("code"));
			return grade;
		}

	}

}
