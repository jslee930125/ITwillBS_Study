package com.itwillbs.order.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.order.db.OrderDAO;

public class OrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println(" M : OrderDetailAction_execute() 호출");
		
		// 세션제어
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		ActionForward forward = new ActionForward();
		
		if (id == null) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		// 전달된 파라미터값 저장(trade_num)
		String trade_num = request.getParameter("trade_num");
		
		// OrderDAO 객체생성 - getOrderDetailList();
		OrderDAO ordao = new OrderDAO();
		
		// request영역에 저장 
		request.setAttribute("orderDetailList", ordao.getOrderDetailList(trade_num));
		
		// 페이지 이동 (view - ./goods_order/order_detail.jsp)
		forward.setPath("./goods_order/order_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
