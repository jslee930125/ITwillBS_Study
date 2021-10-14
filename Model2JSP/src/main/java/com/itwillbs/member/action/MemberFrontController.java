package com.itwillbs.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("\n\n\n C : MemberFrontController_doProcess() 호출");

		// --------------------1.가상주소 계산-------------------------
		// System.out.println("C : URI-"+request.getRequestURI());
		// System.out.println("C : URL-"+request.getRequestURL());
		// URI 정보
		String requestURI = request.getRequestURI();
		System.out.println(" C requestURI : "+requestURI);
		// Context 정보(프로젝트명)
		String ctxPath = request.getContextPath();
		System.out.println(" C ctxPath : "+ctxPath);
		// URI - CTX => command
		String command = requestURI.substring(ctxPath.length());
		System.out.println(" C command : "+command);
		
		System.out.println(" C : 1. 가상주소 계산 완료! \n\n");
		// --------------------1.가상주소 계산-------------------------

		// --------------------2.가상주소 매핑-------------------------

		Action action = null;
	    ActionForward forward = null;
		
		// 회원가입
		if(command.equals("/MemberJoin.me")){
			System.out.println(" C : /MemberJoin.me 호출 ");
			System.out.println(" C : 정보입력페이지(view페이지로 이동)");
			
			// 페이지 이동객체생성 후 정보만 저장
			forward = new ActionForward();
			forward.setPath("./member/insertForm.jsp");
			forward.setRedirect(false);
			
		}else if(command.equals("/MemberJoinAction.me")){
			System.out.println(" C : /MemberJoinAction.me 호출 ");
			System.out.println(" C : 회원정보를 DB에 저장 처리 ");
			
			// DB동작을 대신 처리하는 객체 (model)
			// MemberJoinAction() 객체 생성
			// MemberJoinAction mja = new MemberJoinAction();
			action = new MemberJoinAction();
			try {
				 forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberLogin.me")){
			System.out.println(" C : /MemberLogin.me 호출! ");
			System.out.println(" C : view페이지로 이동 ");
			
			forward = new ActionForward();
			forward.setPath("./member/loginForm.jsp");
			forward.setRedirect(false);			
			
		}else if(command.equals("/MemberLoginAction.me")){
			System.out.println(" C : /MemberLoginAction.me 호출");
			System.out.println(" C : DB에 이동해서 로그인체크 (model 이동) ");
			
			// MemberLoginAction() 객체 생성
			action = new MemberLoginAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/Main.me")){
			System.out.println(" C : /Main.me 호출 ");
			System.out.println(" C : main.jsp (view페이지로 이동)");
			
			forward = new ActionForward();
			forward.setPath("./member/main.jsp");
			forward.setRedirect(false);
		}
		else if(command.equals("/MemberLogout.me")){
			System.out.println(" C : /MemberLogout.me 호출 ");
			System.out.println(" C : 처리동작 (model) ");
			
			// MemberLogoutAction 객체 생성
			action = new MemberLogoutAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberInfo.me")){
			System.out.println(" C : /MemberInfo.me 호출 ");
		    System.out.println(" C : DB정보를 가져와서 view페이지 출력");
		    
		    // MemberInfoAction() 객체 생성
		    action = new MemberInfoAction();
		    
		    try {
//		    	forward 
//		    	 = new MemberInfoAction().execute(request, response);
		    	// 이 방식은 안쓰는 게 좋다. garbage 값
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/MemberUpdate.me")) {
			System.out.println("C : /MemberUpdate.me 호출");
			System.out.println("C : DB의 회원정보를 가져다가 VIEW출력");
			//MemberUpdateAction 객체 생성, action 인터페이스에 저장
			action = new MemberUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/MemberUpdateProAction.me")) {
			System.out.println(" C : /MemberUpdateProAction.me 호출");
			System.out.println(" C : 전달정보 저장 -> DB가서 수정");
			
			// MemberUpdateProAction() 객체 생성
			
			action = new MemberUpdateProAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
		else if(command.equals("/MemberDelete.me")){
			System.out.println(" C : /MemberDelete.me 호출! ");
			System.out.println(" C : 비밀번호를 입력받는 view 페이지로 이동 ");
			
			forward = new ActionForward();
			forward.setPath("./member/deleteForm.jsp");
			forward.setRedirect(false);		
			
		}
		else if(command.equals("/MemberDeleteAction.me")) {
			System.out.println(" C : /MemberDeleteAction.me 호출");
			System.out.println(" C : DB로 이동해서 회원정보 삭제");
			
			// MemberDeleteAction() 객체 생성
			action = new MemberDeleteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/MemberListAction.me")) {
			System.out.println(" C : /MemberListAction.me 호출");
			System.out.println(" C : DB정보를 가져와서 View 페이지 출력");
			
			// MemberListAction() 객체 생성
			action = new MemberListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(" C : 2. 가상주소 매핑 완료 ");
		
		// --------------------2.가상주소 매핑-------------------------

		// --------------------3.페이지 이동---------------------------
		
		if(forward != null){
			//페이지 이동정보가 있다.
			if(forward.isRedirect()){//true
				System.out.println(" C : "+forward.getPath()+"경로 이동(sendRedirect)");
				response.sendRedirect(forward.getPath());
			}else{//false
				System.out.println(" C : "+forward.getPath()+"경로 이동(forward)");
				RequestDispatcher dis =
						request.getRequestDispatcher(forward.getPath());
				
				dis.forward(request, response);		
			}
			
			System.out.println(" C : 3. 페이지 이동 완료 ");
			
		}
		
		// --------------------3.페이지 이동---------------------------
	}// doProcess()

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("C : MemberFrontController_doGet() 호출");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("C : MemberFrontController_doPost() 호출");
		doProcess(request, response);
	}

}
