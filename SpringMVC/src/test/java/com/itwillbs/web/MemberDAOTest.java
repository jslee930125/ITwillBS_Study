package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {
	// 컨트롤러 + 뷰페이지 역할 => 추후변경
	
	// MemberDAO 객체 생성
	// MemberDAO mdao = new MemberDAO(); 인터페이스고 강한 결합 사용불가
	// MemberDAO mdao = new MemberDAOImpl(); 약한 결합이지만 직접 객체 생성이므로 좋지 않음
	
	// => 객체와 의존관계 주입 (root-context.xml의 bean)
	@Inject
	MemberDAO mdao;	
	
	// DAO 객체 확인
	@Test
	public void testDAO() throws Exception {
		System.out.println("testDAO() 실행!!!");
		
		System.out.println("DAO 객체 주입!!");
		System.out.println("DAO: " +mdao);
		
		System.out.println("종료~!");
		
	}
	
	// 시간 확인 메서드 호출
	// test -> daoimpl -> mapper -> mysql -> mapper -> daoimpl -> test
	// view -> 컨트롤러 -> 서비스 -> daoimpl -> mapper -> mysql -> mapper -> daoimpl -> 서비스 -> 컨트롤러 -> 뷰 
	// (test가 하는 역할        )
	@Test
	public void testGetTime() throws Exception {
		
		System.out.println("testGetTime()-----------------------------------");
		
		System.out.println("디비 시간 정보: ");
		System.out.println(mdao.getTime());
		
		System.out.println("testGetTime()-----------------------------------");
	}
	
	//회원가입 동작
	//@Test : 다른 테스트 할 때는 주석처리
	//@Test
	public void testInsert() throws Exception{
		
		// 회원정보 - 현재 입력 불가능(x) -> 강제 생성
		MemberVO vo = new MemberVO();
		vo.setUserid("itwill02");
		vo.setUsername("홍길동");
		vo.setUserpw("1234");
		vo.setUseremail("itwill02@itwill.com");
		
		System.out.println("외부 화면에서 회원정보가 전달");
		System.out.println(vo);
		
		// 회원정보를 DB에 저장
		// DAO객체를 생성(이미 객체가 주입되어져서 존재하고 있음) - insertMember()
		mdao.insertMember(vo);
		
		System.out.println("TEST : 회원 가입 성공! ");
	}
	
	// 회원정보 조회 - getMember()
	// 회원의 id를 사용하여 회원 모든 정보를 출력하는 동작
	
	//정보조회
	//@Test
	public void testGetMember() throws Exception{
			
		// 회원정보 아이디 입력받아서 -> 디비로 전달
		MemberVO vo = mdao.getMember("itwill01");
		System.out.println("TEST : 회원 출력 성공! ");
		System.out.println(vo);
	}
	
	// 회원정보를 사용해서 정보 수정(이름,이메일)
	//@Test
	public void testUpdateMember() throws Exception{
		
		// 수정할 객체 정보 생성
		MemberVO uvo = new MemberVO();
		uvo.setUserid("itwill01");
		uvo.setUserpw("1234");

		uvo.setUsername("수정이름");
		uvo.setUseremail("uitwill@naver.com");
		
		// DAO - updateMember()
		//mdao.udpateMember(uvo);
		System.out.println(mdao.getMember(uvo.getUserid()));
		System.out.println("TEST : 회원 수정 성공! ");
	}
	
	@Test
	public void testDeleteMember() throws Exception{
		
		mdao.deleteMember("itwill01", "1234");		
		System.out.println("TEST : 회원 삭제 성공! ");
		
		
	}
	
	
		

}
