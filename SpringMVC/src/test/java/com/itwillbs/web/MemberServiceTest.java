package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberServiceTest {
	
	// 서비스 동작을 호출 테스트
	
	// 서비스 객체 (DI) - Bean그래프에서 연결된 것은 다 연결됨 - rootcontext랑 serviceImpl도 연결됨
	@Inject
	private MemberService service;
	
	// 회원가입 처리 서비스메서드를 호출
	@Test
	public void testMemberJoin() {
		
		MemberVO vo = new MemberVO();
		vo.setUserid("itwill03");
		vo.setUserpw("1234");
		vo.setUsername("서비스");
		vo.setUseremail("itwill03@naver.com");
		
		service.memberJoin(vo);
		// 단계가 한 단계 늘어남 결합도 약화
		
	}
	
	

}
