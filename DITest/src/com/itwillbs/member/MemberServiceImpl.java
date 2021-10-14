package com.itwillbs.member;

public class MemberServiceImpl implements MemberService{

	// MemberListAction파일
	
	// MemberDAO 객체 생성
	// MemberDAO mdao = new MemberDAOImpl();
	
	private MemberDAO mdao;
	
	// MemberDAO 객체를 의존 주입(setter사용)
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}
	
	@Override
	public void listMembers() {
		// DAO - listMembers() 메서드 호출 
		mdao.listMembers();
	}

	

}
