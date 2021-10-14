package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController3 {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleController3.class);
	
	// http://localhost:8080/web/doD
	// doD 주소를 통해서 페이지 호출 (view : productDetail.jsp페이지)
	// itwill 변수(파라미터)에 저장되어 있는 값을 전달 (뷰페이지에서 출력)
	
	@RequestMapping("doD")
	public String doD(Model model, @ModelAttribute("itwill") String itwill ) {
		// Model 객체: 스프링 MVC에서 정보를 전달하기 위한 목적으로 기본 제공하는 객체
		//            데이터 전달 컨테이너의 역할
		// 주소줄의 정보 한 개는  @ModelAttribute를 사용, 두개는 ,쓰고 2개 적으면 됨.
		// 객체를 가져갈 땐 Model 사용
		
		logger.info("doD()메서드 호출!!!");
		logger.info("ProductVO 객체 생성");
		
		ProductVO vo = new ProductVO("phone",100);
		
		//request.setAttribute();
		
		//model.addAttribute("vo", vo);
		// key값을 명시하는 경우
		
		model.addAttribute(vo);
		// key값을 명시하지 않고 바로 사용하는 경우
		// 이렇게 사용하면 el표현식에서 바로 받아쓰지 못함
		
		logger.info("productDetail.jsp 페이지를 호출(페이지 이동)");
		
		return "productDetail";
	}
}