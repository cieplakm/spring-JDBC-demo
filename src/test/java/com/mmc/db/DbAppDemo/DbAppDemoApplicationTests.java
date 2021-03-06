package com.mmc.db.DbAppDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration("file:src/main/resources/jdbc-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DbAppDemoApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;


	@Test
	public void contextLoads() {

	}

}
