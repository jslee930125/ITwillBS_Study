package com.itwillbs.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MybatisTest {

	// SqlSessionFactory 객체 생성(직접생성x - 의존주입)
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFac() throws Exception{
		System.out.println("@@@@@:"+sqlFactory);
	}
	
	@Test
	public void testSqlSession() throws Exception{
		System.out.println("@@@@@@ :" + sqlFactory.openSession());
		SqlSession session = sqlFactory.openSession();
		System.out.println("@@@@@@ :" + session);
		
	}
}
