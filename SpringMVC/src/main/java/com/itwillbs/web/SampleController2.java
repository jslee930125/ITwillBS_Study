package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleController2.class);
	
	// * String을 리턴하는 메서드는 리턴값.jsp 페이지 호출
	// 오직 void와 String 두개 형태만 가능하다.
	// => 요청한 주소와, 뷰페이지명이 같은 경우 메서드를 void로 사용
	// => 호출하는 주소랑 뷰페이지 이름이 다른경우 메서드를 String으로 사용 
	
	// http://localhost:8080/web/doCA
	@RequestMapping("/doCA")
	public String doC() {
		logger.info("doCA() 호출!!!");
		
		return "doC";
		//	jsp 페이지 이름이 return값으로 결정됨
	}
	
	// http://localhost:8080/web/doC1
	// http://localhost:8080/web/doC1?msg=itwill
	// doC1 주소로 페이지 호출( 뷰페이지 : doC.jsp )
	@RequestMapping("doC1")
	public String doCC1(@ModelAttribute("msg") String msg) {
		logger.info("doCC1() 호출!!!");
		System.out.println("doC.jsp 페이지 연결");
		System.out.println("전달값:" + msg);
		return "doC";
	}
}