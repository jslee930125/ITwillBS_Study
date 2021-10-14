package com.itwillbs.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("M: MemberListAction_execute() 호출");
		
		// 세션제어 (로그인/관리자만)
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null || !id.equals("admin")) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		// DAO 객체 생성 - 회원정보 목록을 가져오는 메서드(관리자 제외)
		// getMemberList();
		MemberDAO mdao = new MemberDAO();
		List<MemberDTO> memberList = mdao.getMemberList();
		// 회원목록(request 영역) 저장
		request.setAttribute("memberList", memberList);
		
		// 위 코드 두 줄이 이 한 줄과 같다. 더 효율적
		// request.setAttribute("memberList", mdao.getMemberList());
		
		// 페이지 이동 (JSP)
		forward.setPath("./member/list.jsp");
		forward.setRedirect(false);
		return forward;		
	}

}
