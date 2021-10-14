package com.itwillbs.member;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public void getCon() {
		System.out.println(" 디비 연결 성공! ");
	}

	@Override
	public void listMembers() {
		getCon();
		System.out.println(" SQL 작성 - select ");
		System.out.println(" SQL 실행 ");
		System.out.println(" 회원 목록 출력! ");		
	}

}
