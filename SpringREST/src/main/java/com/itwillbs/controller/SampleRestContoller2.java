package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestContoller2 {
	// @RestController => 데이터를 문자열/JSON 형태로 리턴
	// 	=> VIEW 페이지가 없음 (서비스의 처리가 정상처리인지 판단이 어렵다)
	//  => HTTP 상태 코드
		
	@RequestMapping(value="/sendErrAuth")
	public ResponseEntity<Void> sendListAuth(){
		
		return new ResponseEntity<Void>(HttpStatus.OK);	
	}

	@RequestMapping(value = "sendErrAuth2")
	public ResponseEntity<List<SampleVO>> sendList2() {

		List<SampleVO> list = new ArrayList<SampleVO>();

		for (int i = 0; i < 10; i++) {

			SampleVO vo = new SampleVO();
			vo.setNum(i);
			vo.setName("학생" + i);
			vo.setTel("010-1234-567" + i);

			list.add(vo);
		}
		// 서비스 동작에서 가져온 동작 + http상태도 같이 넘김
		
		return new ResponseEntity<List<SampleVO>>(list,HttpStatus.NOT_FOUND);
	}
	
	// http://localhost:8088/sendErrAuth3
	@RequestMapping(value = "sendErrAuth3")
	public ResponseEntity<String> sendList3() {

		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		String msg = "";
		msg += "<script>";
		msg += " alert( '정상처리 완료!' );";
		msg += "</script>";
		
		// 레스트 방식으로 데이터도 메세지도 보낼 수 있다
		
		return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
	}
	
	//@RequestMapping(value="/board/100")
	@RequestMapping(value="/board/{num}") // 보드 뒤에 {num} 들어오면 리턴값으로 전달하겠다
	public int testRest1(@PathVariable("num") int num ) {
		// 주소줄에 작성된 정보를 매개변수로 사용가능
		
		//return 0;
		return num;	
	}
		
}
