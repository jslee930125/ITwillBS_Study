package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @RestController : 해당 컨트롤러가 동작(메서드)이 처리되는 
//					 뷰페이지를 REST 형태로 표현
//                   즉, @ResponseBody 생략된 형태 -> 리턴이 전부 @ResponseBody로 바뀐다.

//@Controller
@RestController
public class SampleRestContoller1 {
	// 문자열 데이터를 REST형태로 리턴 Content-Type: text/html;
		
	// http://localhost:8088/rest1
	@RequestMapping(value="/rest1")
	public @ResponseBody String TestRest() {
		
		//@ResponseBody 가 리턴타입에 들어가면 : 처리결과를 REST 형식으로 변환(보통 JSON)
		
		return "TEST REST!!!";
	}
	
	// 406,500 에러 발생시 객체 변환 실패 -> JSON라이브러리 추가
	// http://localhost:8088/rest2
	// 객체 형태를 리턴하는 동작 Content-Type: application/json;
	// jackson-databind 라이브러리 추가해야 인식 가능	
	@RequestMapping(value="/rest2")
	@ResponseBody
	//@ResponseBody 여기에 써도 된다.
	public SampleVO TestRest2(){
		
		System.out.println("객체 리턴");
		
		SampleVO vo = new SampleVO();
		vo.setNum(1);
		vo.setName("itwill");
		vo.setTel("010-1234-5678");
		
		return vo;
		
	}
	
	// 리스트
	@RequestMapping(value="/rest3")
	public List<SampleVO> TestRest3(){
		
		List<SampleVO> list = new ArrayList<SampleVO>();
		
		for(int i=0;i<10;i++) {
			
			SampleVO vo = new SampleVO();
			vo.setNum(i);
			vo.setName("학생"+i);
			vo.setTel("010-1234-567"+i);
			
			list.add(vo);
		}
		
		return list;
	}
	
	// 맵
	
	@RequestMapping(value="/rest4")
	public Map<Integer, SampleVO> TestRest4(){
		
		Map<Integer, SampleVO> map = new HashMap<Integer, SampleVO>();
		
		
		for(int i=0;i<10;i++) {
			
			SampleVO vo = new SampleVO();
			vo.setNum(i);
			vo.setName("학생"+i);
			vo.setTel("010-1234-567"+i);
			
			map.put(i, vo);
			
		}
		
		return map;
	}
}
