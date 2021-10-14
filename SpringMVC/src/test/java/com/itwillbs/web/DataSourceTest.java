package com.itwillbs.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// @RunWith(SpringJUnit4ClassRunner.class)
// => 해당 클래스를 스프링 Junit4 사용해서 테스트용으로 설정

// @ContextConfiguration(
// 		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
// 		)
// => 해당 클래스를 스프링 Junit4 사용해서 테스트용으로 설정 + 스프링의 정보를 가져오는 역할

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {
	
	// 디비 연결테스트(root-context.xml에 있는 dataSource객체를 사용)
	
	// 디비 연결정보를 저장하는 객체를 생성(DataSource)
	// DataSource ds = new DataSource(); (x)
	
	// @Inject 없으면 객체 정보 null로 됨
	// 객체 의존주입 : 스프링이 생성(root-context.xml파일)객체를 주입, 별도의 객체 생성 필요 없음
	//             (DataSource ds = new DataSource();와 같은 것 root-context.xml에서 가져다가 주입)	
	
	@Inject
	private DataSource ds;
	
	@Test
	public void testCon() throws Exception {
		System.out.println("DataSource 객체 정보:" +ds);
		
		// ds안에 정보 다 들어있음
		Connection con = ds.getConnection();
		System.out.println("디비연결 정보:" + con);		
	}
}
