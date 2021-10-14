package com.itwillbs.admin.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.order.db.AdminOrderDAO;
import com.itwillbs.order.db.OrderDAO;
import com.itwillbs.order.db.OrderDTO;

public class AdminOrderModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println(" M : AdminOrderModifyAction_execute() 호출");
		
		// 세션제어(생략)
		
		// 전달된 정보 저장(주문번호,운송장번호,주문상태)
		// => DTO 객체에 저장
		OrderDTO ordto = new OrderDTO();
		ordto.setO_trade_num(request.getParameter("trade_num"));
		ordto.setO_trans_num(request.getParameter("trans_num"));
		ordto.setO_status(Integer.parseInt(request.getParameter("status")));
		
		// DAO 객체 - updateOrder(DTO)
		AdminOrderDAO aodao = new AdminOrderDAO();
		aodao.updateOrder(ordto);
		
		// 페이지이동 - AdminOrderList.ao
		ActionForward forward = new ActionForward();
		forward.setPath("./AdminOrderList.ao");
		forward.setRedirect(true);
		return forward;
	}

}
