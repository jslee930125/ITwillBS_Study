package com.itwillbs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController5 {
	
	@RequestMapping("/dojson")
	public @ResponseBody ProductVO doJson() {
		// 자동으로 json형태로 만들어주는 애너테이션 - 객체를 보내는 것보다 빠른 처리 속도
		// 내장 브라우저로 실행시 다운로드 가능한 형태가 된다. 
		// 내장파서가 없어서 파싱이 되지 않아서 볼 수 없고 다운로드 형태
		
		System.out.println(" @@@@ doJson() 호출 ");
		
		return new ProductVO("컴퓨터",100);
	}
	

}