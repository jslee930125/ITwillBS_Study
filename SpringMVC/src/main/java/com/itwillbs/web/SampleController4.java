package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleController4.class);
	
	// http://localhost:8080/web/doE1
	// http://localhost:8080/web/doE1?msg=itwill
	
	// doE1 주소 호출로 doE 뷰페이지 호출
	@RequestMapping("/doE1")
	public String doE1(RedirectAttributes rttr /* @ModelAttribute("msg") String msg */) {		

		logger.info("doE1()메서드 실행! ");
		
		rttr.addFlashAttribute("msg", "1234ABC");
		
		logger.info("doE.jsp 페이지 이동");
		
		// doE로 페이지 이동 
		// return "/doE"(X); 페이지 이동되지 않음
		
		return "redirect:/doE";
		// send redirect 방식- 주소가 바뀌면서 화면도 바뀌는 방식

		// return "forward:/doE";
		// forward 방식 - 주소는 바뀌지 않지만 화면은 바뀌는 방식
	}
	
	@RequestMapping("/doE")
	public void doE(@ModelAttribute("msg") String msg) {
		// redirect/forward 방식으로 정보를 넘겼을 때 둘 다 정보가 넘어간다.
		
		logger.info("@@@@ doE() 메서드 실행 ");
		logger.info("@@@@ doE.jsp 페이지 이동");
	}
	
	// doE1 주소호출의 결과로 doE.jsp 페이지에 정보 출력
	// msg 변수의 값을 전달
	
	// => @ModelAttribute 사용해서 페이지 이동시 데이터 전달 가능
	// => 단점: 주소줄에 계속 정보가 사라지지 않고 남아있게 된다.
	// => RedirectAttributes를 사용해서 해결, 단 redirect 시에만 사용 가능함.
	
	// redirect 방식의 경우
	
	// addAttribute() : 페이지 이동방식에 상관없이 사용가능(@ModelAttribute,Model 사용)
	// 		- URI에 데이터 표시 O
	//		- F5(새로고침)시 데이터 유지
	
	// addFlashAttribute() : redirect 방식일때만 사용가능 (RedirectAttributes 사용)
	//		- URI에 데이터 표시 X, (값은 넘어감)
	//		- F5(새로고침)시 데이터 소멸 (1회성 데이터)
}