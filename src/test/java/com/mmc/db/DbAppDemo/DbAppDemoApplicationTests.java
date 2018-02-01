package com.mmc.db.DbAppDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbAppDemoApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;


	@Test
	public void contextLoads() {
		System.out.println(jdbcTemplate);
		jdbcTemplate.execute("create table nazwa_tabeli_XXX (id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY)");
	}

}
