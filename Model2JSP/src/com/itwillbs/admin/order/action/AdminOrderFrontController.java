package com.itwillbs.admin.order.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("*.ao")
public class AdminOrderFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminOrderFrontController_doProcess()");
		
		//////////////////1. 가상주소를 계산 /////////////////////////
		System.out.println("");
		System.out.println(" C : 가상주소 계산 시작");
		String requestURI = request.getRequestURI();
		System.out.println(" C : requestURI : "+requestURI);
		String ctxPath = request.getContextPath();
		System.out.println(" C : ctxPath : "+ctxPath);
		String command = requestURI.substring(ctxPath.length());
		System.out.println(" C : command : "+command);
		
		System.out.println(" C : 가상주소 계산 끝");
		//////////////////2. 가상주소를 매핑 /////////////////////////
		
		Action action = null;
		ActionForward forward = null;
		
		System.out.println();
		System.out.println(" C : 가상주소 매핑 시작");
		
		if(command.equals("/AdminOrderList.ao")){
			System.out.println(" C : /AdminOrderList.ao 호출 ");
			System.out.println(" C : DB정보를 조회해서 view 출력");
			// AdminOrderListAction() 객체 생성
			action = new AdminOrderListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/AdminOrderDetail.ao")){
			System.out.println(" C : /AdminOrderDetail.ao 호출");
			System.out.println(" C : DB정보를 view에 출력");
			
			// AdminOrderDetailAction() 객체 생성
			action = new AdminOrderDetailAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/AdminOrderModify.ao")){
			System.out.println(" C: /AdminOrderModify.ao 호출");
			System.out.println(" C : 전달받은 정보로 DB내용을 수정 ");
			// AdminOrderModifyAction() 객체
			
			action = new AdminOrderModifyAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println(" C : 가상주소 매핑 끝");
		
		
		//////////////////3. 페이지 이동 ////////////////////////////
		System.out.println();
		System.out.println(" C : 페이지 이동 시작 ");
		if(forward != null){
			if(forward.isRedirect()){ // true
				System.out.println(" C : 방식-sendRedirect, 주소-"+forward.getPath());
				response.sendRedirect(forward.getPath());
			}else{ //false
				RequestDispatcher dis =
						request.getRequestDispatcher(forward.getPath());
				
				System.out.println(" C : 방식-forward, 주소-"+forward.getPath());
				dis.forward(request, response);				
			}		
		}
		System.out.println(" C : 페이지 이동 끝 \n\n\n\n");
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminOrderFrontController_doGET()");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminOrderFrontController_doPOST()");
		doProcess(request, response);
	}	
	
}
