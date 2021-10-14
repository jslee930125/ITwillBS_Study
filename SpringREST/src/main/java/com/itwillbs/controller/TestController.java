package com.itwillbs.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.MemberVO;

@RestController
@RequestMapping("/test/*")
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value="/info", method=RequestMethod.POST)
	public void test(@RequestBody MemberVO vo) {
		
		// json의 형태로 ajax에서 넘어오니까 @RequestBody로 받아줘야 한다.
		// @RequestBody: json형태로 전달된 데이터를 해당 객체의 형태로 전달(변환)
		
		logger.info("TestController_test() 호출!!");
		
		logger.info(vo+"");
		
		
	}
	
	
	

}
