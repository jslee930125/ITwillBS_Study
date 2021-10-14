package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

// @Service : 스프링에서 해당 객체를 서비스객체(bean)인식하도록 설정
// DAO는 @repository , Service는 @Service

@Service
public class MemberServiceImpl implements MemberService {
	
	//MemberDAO 객체필요 -> 의존 관계 주입
	@Inject
	private MemberDAO mdao;
	
	private int result;

	@Override
	public void memberJoin(MemberVO vo) {
		System.out.println("S: DAO-insertMember(vo) 호출(연결)");
		
		mdao.insertMember(vo);
		
		System.out.println(" S : 회원가입 처리 완료! ");
		
		
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		
		System.out.println(" S : loginCheck(vo) 호출 ");
		// 서비스동작 구현 - DAO 객체
		MemberVO loginResultVO = mdao.loginCK(vo);
		
		System.out.println("S : "+loginResultVO);
		
		System.out.println(" S : 로그인 체크 완료! ");
		
		return loginResultVO;
	}

	@Override
	public MemberVO getMember(String id) {		
		
		System.out.println("S : 컨트롤러에서 -> getMember(id) 호출 !!");
		
		MemberVO vo = mdao.getMember(id);
		
		System.out.println("S : DAO -> 컨트롤러 이동");
		System.out.println("S : ");
		
		return vo;
	}

	@Override
	public int updateMember(MemberVO uvo) {
		
		System.out.println(" S : 컨트롤러에서 -> updateMember(uvo) 호출 !!");
		
		int result = mdao.modify(uvo);
				
		System.out.println("S : update(post) 컨트롤러 이동");
		
		return result;
	}

	@Override
	public void deleteMember(MemberVO dvo) {
		
		System.out.println(" S : 컨트롤러에서 -> deleteMember(dvo) 호출 !!");
		
		mdao.deleteMember(dvo.getUserid(), dvo.getUserpw());
				
		System.out.println("S : update(post) 컨트롤러 이동");
		
	}

	@Override
	public List<MemberVO> getMemberList(String adminID) {
		
		System.out.println(" S : getMemberList(adminID) 호출");
		
		List<MemberVO> memberList = mdao.getMemberList(adminID);
		
		System.out.println(" S : 데이터 저장 후 페이지 이동 ");
		
		return memberList;
	}

	

}
