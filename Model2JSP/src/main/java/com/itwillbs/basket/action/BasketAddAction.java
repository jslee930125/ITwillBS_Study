package com.itwillbs.basket.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.basket.db.BasketDAO;
import com.itwillbs.basket.db.BasketDTO;

public class BasketAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("M : BasketAddAction_execute() 호출");
		// 장바구니 저장하는 테이블 생성 - itwill_basket
		
		// 세션값 제어
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id==null) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		// 전달된 정보를 저장(num,amount,size,color,id)
		// BasketDTO 생성 후 정보 저장
		BasketDTO bkdto = new BasketDTO();
		bkdto.setB_g_num(Integer.parseInt(request.getParameter("num")));
		bkdto.setB_g_amount(Integer.parseInt(request.getParameter("amount")));
		bkdto.setB_g_size(request.getParameter("size"));
		bkdto.setB_g_color(request.getParameter("color"));
		bkdto.setB_m_id(id);
		
		// DAO 객체 생성
		// - 기존에 장바구니에 동일상품이 있는지 체크 
		//   있을 때 수량변경(update)
		//   없을 때 상품등록(insert)
		
		BasketDAO bkdao = new BasketDAO();
		int result = bkdao.checkGoods(bkdto);
		
		System.out.println("M : 장바구니 체크 결과(0:상품없음, 1:상품있음) : " + result);
		
		//상품중복여부 체크
		if(result != 1) {
			// 장바구니에 상품 등록
			bkdao.basketAdd(bkdto);
		}
		
		// 페이지 이동
		forward.setPath("./BasketList.ba");
		forward.setRedirect(true);
		return forward;		
	}

}
