package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	// 수행할 동작을 선언(추상메서드)
	// DAO와 컨트롤러의 연결 => DAO객체의 메서드 호출
	// 컨트롤러가 서비스(Action페이지 역할) 호출하고 서비스가 DAO(DB) 호출
	
	// 회원가입
	public void memberJoin(MemberVO vo);
	
	// 로그인 체크
	public MemberVO loginCheck(MemberVO vo);
	
	// 회원정보 조회
	public MemberVO getMember(String id);
	
	// 회원정보 수정
	public int updateMember(MemberVO uvo);
	
	// 회원정보 삭제
	public void deleteMember(MemberVO dvo);
	
	// 회원정보 목록
	public List<MemberVO> getMemberList(String adminID);
	
	
	
	

}
