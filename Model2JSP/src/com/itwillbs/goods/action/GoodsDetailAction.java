package com.itwillbs.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.goods.db.GoodsDTO;
import com.itwillbs.goods.db.GoodsDAO;

public class GoodsDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println(" M :GoodsDetailAction_execute() 호출 ");
		
		// 전달된 정보 (num) 저장
		int num = Integer.parseInt(request.getParameter("num"));
		
		System.out.println(" M : 상품번호 : "+num);
		// DAO 객체 생성 - getGoods(num);
		GoodsDAO gdao = new GoodsDAO();
		GoodsDTO gdto = gdao.getGoods(num);
		
		// DB에서 가져온 상품정보를  request 영역에 저장
		request.setAttribute("gdto", gdto);

		// 페이지 이동(view - ./goods/goods_detail.jsp)
		ActionForward forward = new ActionForward();
		forward.setPath("./goods/goods_detail.jsp");
		forward.setRedirect(false);		
		return forward;
	}

}
