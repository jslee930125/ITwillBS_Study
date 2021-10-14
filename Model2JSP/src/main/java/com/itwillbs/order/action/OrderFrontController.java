package com.itwillbs.order.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// @WebServlet("*.or")
// web.xml 파일에서 서블릿 매핑을 대시처리하는 작업
@WebServlet("*.or")
public class OrderFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderFrontController_doProcess()");
		
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
		
		if(command.equals("/OrderStart.or")){
			System.out.println(" C : /OrderStart.or 호출 ");
			System.out.println(" C : DB정보를 화면에 보여주기 (주문창)");
			// OrderStartAction() 객체 생성
			action  = new OrderStartAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		else if(command.equals("/OrderAddAction.or")){
			System.out.println(" C : /OrderAddAction.or 호출 ");
			System.out.println(" C : 전달된 정보를 db에 저장 후 이동");
			// OrderAddAction() 객체 생성
			
			action  = new OrderAddAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		else if(command.equals("/OrderList.or")){
			System.out.println(" C : /OrderList.or 호출 ");
			System.out.println(" C : DB정보를 가져와서 VIEW 출력");
			// OrderListAction() 객체 생성
			
			action  = new OrderListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		else if(command.equals("/OrderDetail.or")){
			System.out.println(" C : /OrderDetail.or 호출 ");
			System.out.println(" C : DB정보를 가져온 주문벙보를 VIEW 출력");
			// OrderDetailAction() 객체 생성
			
			action  = new OrderDetailAction();
			
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
		System.out.println("OrderFrontController_doGET()");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderFrontController_doPOST()");
		doProcess(request, response);
	}	

}
