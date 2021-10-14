package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("MemberDeleteAction_execute() 호출");
		
		// 세션 제어 - 중복 - 차 후 모듈형태로
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// 전달된 정보를 저장(id,pass)
		String pass = request.getParameter("pass");
		
		// DAO 객체생성 -> deleteMemberK(id,pass)
		// update 동작과 동일하게 처리(-1,0,1)
		MemberDAO mdao = new MemberDAO();
		int check = mdao.deleteMember(id,pass);
		// session에 pass 정보를 담으면 안 된다. 보안상의 문제
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(check == 0) {
			// 비밀번호 오류
			out.print("<script>");
			out.print(" alert('비밀번호 오류 - 탈퇴x'); ");
			out.print(" history.back(); ");
			out.print("</script>");
			out.close();
			return null;
		}
		
		if(check == -1) {
			// 비회원
			out.print("<script>");
			out.print(" alert('회원정보 오류 - 탈퇴x'); ");
			out.print(" history.back(); ");
			out.print("</script>");
			out.close();
			return null;
		}
		
		// 세션값 초기화
		session.invalidate();
		out.print("<script>");
		out.print(" alert('회원탈퇴완료!'); ");
		out.print(" location.href='./Main.me'; ");
		out.print("</script>");
		out.close();
		return null;
	}
}