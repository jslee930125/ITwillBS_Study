package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// * 테스트 전용 파일을 생성시
// @RunWith()
// @ContextConfiguration
// => spring으로 테스트 하겠다. (웹에대한 정보가 없음)

// @RunWith()
// @ContextConfiguration
// @WebAppConfiguration
// => spring MVC로 테스트 하겠다. (웹에 대한 정보가 있음)

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
						// 해당 주소에 있는 .xml파일을 모두 가져와서 설정파일로 사용한다.
		)
public class SampleControllerTest {
	// 테스트파일을 사용해서 WAS의 동작 수행 (스프링3.2~ 이후 가능)
	
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	// 테스트 도구를 가지고 있는 객체
	
	private MockMvc mockMVC;
	// 페이지 request(요청), response(응답) 역할하는(처리하는) 객체
	
	// @Before : @Test 동작이 수행되기 전에 먼저 실행하는 동작
	@Before
	public void setup() {
		logger.info("setup() 메서드 호출 (테스트 전에 준비되는 동작)");
		
		this.mockMVC = MockMvcBuilders.webAppContextSetup(this.wac).build();
	
		logger.info("MockMVC 객체 준비 완료! ");
		
	}
	
	@Test
	public void testDoA() throws Exception {
		logger.info("testDoA() 메서드 호출 : 컨트롤러 역할");
		
		mockMVC.perform(MockMvcRequestBuilders.get("/doA"));
		// GET방식으로 요청을 부르는 것
		
	}

}
