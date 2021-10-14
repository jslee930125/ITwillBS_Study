package com.itwillbs.member;

public interface MemberDAO {
	
	// 디비연결
	public void getCon();
	
	// 회원리스트 출력
	public void listMembers();

}
