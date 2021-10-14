package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// @Controller (x)
// @ControllerAdvice : 컨트롤러에서 발생하는 모든 예외를 처리하는 객체
//      => servlet-context.xml 파일에서 객체를 인식 (bean)

@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

//	@ExceptionHandler(NullPointerException.class)
//	public String commons2(Exception e) {
//
//		logger.info(e.toString());
//
//		return "";
//	}

//	// 예외처리 동작 -> 메서드
//	@ExceptionHandler(Exception.class)
//	public String commons(Exception e) {
//
//		logger.info(e.toString());
//
//		return "err_commons";
//	}
	// => 위 방식은 컨트롤러가 아니기 때문에 view로 정보를 전달해주는 객체
	//  Model 객체를 사용할 수 없음.
	
	
	// ModelAndView 객체 : Model객체의 데이터와 view페이지 처리를 동시에 처리하는 객체
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView errModelAndView(Exception e){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/err_commons"); // err_commons.jsp 페이지
		mav.addObject("err", e);
		mav.addObject("itwill", "에러발생 당직자 출근!");
		
		return mav;
	}
	
	

}
