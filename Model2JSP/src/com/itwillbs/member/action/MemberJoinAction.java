package com.itwillbs.member.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberJoinAction implements Action {
	//회원가입 처리 객체 

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// 회원가입 처리 후 페이지 이동정보를 생성
		System.out.println(" M : MemberJoinAction_execute() 호출");
		
		// 한글처리 
		request.setCharacterEncoding("UTF-8");
		// 전달된 파라미터값 저장=> 자바빈 객체생성
		// MemberDTO
		MemberDTO mdto = new MemberDTO();
		
		mdto.setId(request.getParameter("id"));
		mdto.setPass(request.getParameter("pass"));
		mdto.setName(request.getParameter("name"));
		mdto.setAge(Integer.parseInt(request.getParameter("age")));
		mdto.setGender(request.getParameter("gender"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		System.out.println("M : "+mdto);
		
		// 전달된 정보를 DB에 저장
		// MemberDAO 객체 - 메서드 insertMember
		MemberDAO mdao = new MemberDAO();
		mdao.insertMember(mdto);
		
		System.out.println("M : DB처리 완료!");
		
		// 페이지 이동	=>페이지 이동정보를 생성해서 컨트롤러로 전달
		ActionForward forward 
		    = new ActionForward();
		forward.setPath("./MemberLogin.me");
		forward.setRedirect(true);	
		return forward;
	}
}
