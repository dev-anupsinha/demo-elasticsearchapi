package com.tcgmetis.demotcgmetis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysql")
public class MySqlDbController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/emp")
	public List<String> getEmployeeDetails() {
		/*
		 * String sqlSelectAllPersons = "SELECT * FROM tbl_employee"; String
		 * connectionUrl = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		 * 
		 * try (Connection conn = DriverManager.getConnection(connectionUrl, "root",
		 * "P@ssword@12"); PreparedStatement ps =
		 * conn.prepareStatement(sqlSelectAllPersons); ResultSet rs = ps.executeQuery())
		 * {
		 * 
		 * while (rs.next()) { long id = rs.getLong("emp_id"); String name =
		 * rs.getString("emp_name"); String add = rs.getString("emp_add");
		 * System.out.println("out :"+id+""+name+""+add); // do something with the
		 * extracted data... } } catch (SQLException e) { // handle the exception }
		 */
		String queryStr = "SELECT * FROM tbl_employee";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(queryStr);
		for (Map row : rows) {
			int id = (int) row.get("emp_id");
			String name = (String) row.get("emp_name");
			String add = (String) row.get("emp_add");
			System.out.println("out :" + id + "" + name + "" + add); // do something with the
		}
		return jdbcTemplate.query("select * from tbl_employee", (rs, rowNum) -> new String(rs.getString("emp_name")));
	}

}
