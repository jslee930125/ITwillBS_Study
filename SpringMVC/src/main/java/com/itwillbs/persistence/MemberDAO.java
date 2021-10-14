package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	// 구현동작 - 추상메서드
	
	// 현 DB 시간정보를 가져오기
	public String getTime();
	
	// 회원정보 가입(Create)
	public void insertMember(MemberVO vo);
	
	// 회원정보 조회(Read)
	public MemberVO getMember(String userid);
	
	// 회원정보 수정(Update)
	public void updateMember(MemberVO updateVO);
	
	// 회원정보 삭제(Delete)
	public void deleteMember(String userid, String userpw);
	
	// 로그인체크 (loginCK)
	public MemberVO loginCK(MemberVO vo);
	
	// 회원정보 수정 (modify)
	public int modify(MemberVO uvo);
	
	// 회원목록 조회 (select-list)
	public List getMemberList(String id);
	
}
