package com.itwillbs.basket.action;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.basket.db.BasketDAO;

public class BasketListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("M : BasketListAction_execute() 호출");

		// 세션값 제어
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		ActionForward forward = new ActionForward();
		
		if (id == null) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		// BasketDAO 객체를 생성해서 -> 해당 장바구니 정보를 가져오기
		// 구매수량 + 상품자체 정보
		
		BasketDAO bkdao = new BasketDAO();
		Vector totalList = bkdao.getBasketList(id);
		
		// request영역에 저장
		// request.setAttribute("totalList", totalList); 
		// List basketList = (List)totalList.get(0);
		// 뷰에서 꺼내쓰기 좋은 형태로 보내기, 벡터로 보내면 이중 for문으로 돌아야 함
		request.setAttribute("basketList", totalList.get(0));
		request.setAttribute("goodsList", totalList.get(1));
		
		// 페이지 이동(view - ./basket/goods_basket_list.jsp)
		
		forward.setPath("./basket/goods_basket_list.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
