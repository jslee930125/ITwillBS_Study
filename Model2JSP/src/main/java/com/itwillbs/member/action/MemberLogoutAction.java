package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("M : MemberLogoutAction_execute()");
		// 세션정보 초기화
		HttpSession session = request.getSession();
		session.invalidate();
		
		// 페이지 이동-JS
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print(" alert('로그아웃!'); ");
		out.print(" location.href='./Main.me'; ");
		out.print("</script>");
		out.close();
		
		return null;
	}

}
