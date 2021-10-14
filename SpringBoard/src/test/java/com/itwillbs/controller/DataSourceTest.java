package com.itwillbs.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {
	
	@Inject
	private DataSource ds;
	
	//@Inject
	@Autowired
	private SqlSession sqlSession;
	
	//@Test
	public void testDS() throws Exception{
		System.out.println("디비 연결객체  : "+ds);
		
		Connection con = ds.getConnection();
		
		System.out.println(" 디비 연결 정보 : "+con);		
	}
	
	@Test
	public void testSession() throws Exception{
		
		System.out.println("\n"+sqlSession+"\n");
		
		Connection con = sqlSession.getConnection();
		
		System.out.println("\n"+con+"\n");
		
	}
	
	
	
	
	
	
	

}
