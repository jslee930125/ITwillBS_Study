package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller : 해당 클래스를 MVC 컨트롤러로 사용하겠다.

@Controller
public class SampleController1 {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleController1.class);
	// Logger 객체 생성 system.out을 대신할 것.
	
	// * 메서드 리턴타입이 없을경우(void) 요청한 주소.jsp 페이지 호출
	
	// http://localhost:8080/web/doA
	@RequestMapping("doA")
	public void doA(@ModelAttribute("msg") String msg) {
		logger.info("doA()메서드 호출!!! ");
	}
	
	// doB 주소를 호출해서 해당 페이지를 생성
	// http://localhost:8080/web/doB
	@RequestMapping("doB")
	public void doB() {
		logger.info("doB()메서드 호출!!! ");
	}
}
