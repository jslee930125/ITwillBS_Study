package com.itwillbs.order.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.order.db.OrderDAO;

public class OrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println(" M : OrderListAction_execute() 호출");
		
		// 세션제어
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		ActionForward forward = new ActionForward();
		
		if (id == null) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		// 주문정보 처리 OrderDAO 객체생성
		OrderDAO ordao = new OrderDAO();
		// getOrderList(id);
		List orderList = ordao.getOrderList(id);
		
		// 정보를 request영역에 저장 
		request.setAttribute("orderList", orderList);
		
		// 페이지 이동 (view - ./goods_order/order_list.jsp)
		forward.setPath("./goods_order/order_list.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
