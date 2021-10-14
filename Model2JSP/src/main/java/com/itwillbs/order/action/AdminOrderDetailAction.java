package com.itwillbs.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.order.action.Action;
import com.itwillbs.admin.order.action.ActionForward;
import com.itwillbs.admin.order.db.AdminOrderDAO;

public class AdminOrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println(" M : AdminOrderDetailAction_execute() 호출");

		// 관리자 로그인 세션제어(생략)

		// 전달된 파라미터값 저장(trade_num)
		String trade_num = request.getParameter("trade_num");

		// DAO 객체생성 - getAdminOrderDetailList(trade_num);
		AdminOrderDAO aodao = new AdminOrderDAO();

		// request영역에 저장
		request.setAttribute("aodList", aodao.getAdminOrderDetailList(trade_num));

		// 페이지 이동 (view - ./admin_order/admin_order_detail.jsp)
		ActionForward forward = new ActionForward();
		forward.setPath("./admin_order/admin_order_detail.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
