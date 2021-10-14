package com.itwillbs.admin.goods.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminGoodsFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminGoodsFrontController_doProcess()");
		
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
		if(command.equals("/GoodsAdd.ag")){
			// http://localhost:8088/Model2JSP/GoodsAdd.ag
			System.out.println(" C : /GoodsAdd.ag 호출! ");
			System.out.println(" C : 관리자의 상품정보를 전달받아서 DB에 저장");
			
			// 정보입력받는 view페이지로 이동
			forward = new ActionForward();
			forward.setPath("./admin_goods/admin_goods_add.jsp");
			forward.setRedirect(false);		
		}
		else if(command.equals("/GoodsAddAction.ag")){
			System.out.println(" C : /GoodsAddAction.ag 호출! ");
			System.out.println(" C : 전달받은 정보를 DB에 저장(file)");
			// GoodsAddAction() 객체 생성
			
			action = new GoodsAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/AdminGoodsList.ag")){
			System.out.println(" C : /AdminGoodsList.ag 호출 ");
			System.out.println(" C : DB정보를 view페이지에 출력");
			
			// AdminGoodsListAction() 객체 
			action = new AdminGoodsListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/AdminGoodsModify.ag")){
			System.out.println(" C : /AdminGoodsModify.ag 호출 ");
			System.out.println(" C : DB정보를 가져와서 view 출력 ");
			
			// AdminGoodsModify() 객체 생성
			action = new AdminGoodsModify();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/AdminGoodsModifyAction.ag")){
			System.out.println(" C : /AdminGoodsModifyAction.ag 호출");
			System.out.println(" C : 수정할 정보를 DB에 저장후 이동");
			// AdminGoodsModifyAction() 객체 생성
			action = new AdminGoodsModifyAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/AdminGoodsDelete.ag")){
			System.out.println(" C : /AdminGoodsDelete.ag 호출");
			System.out.println(" C : 상품의 정보를 바로 삭제(DB) ");
			// AdminGoodsDeleteAction() 객체 
			action = new AdminGoodsDeleteAction();
			
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
		System.out.println("AdminGoodsFrontController_doGET()");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminGoodsFrontController_doPOST()");
		doProcess(request, response);
	}

}
