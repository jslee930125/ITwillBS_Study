package com.itwillbs.admin.goods.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.goods.db.AdminGoodsDAO;
import com.itwillbs.admin.goods.db.GoodsDTO;

public class AdminGoodsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println(" M : AdminGoodsListAction_execute 호출");
		
		// DAO 객체 생성 - getGoodsList();
		AdminGoodsDAO agdao = new AdminGoodsDAO();
		List<GoodsDTO> goodsList = agdao.getGoodsList();
		// view페이지 전달 => request영역에 저장
		request.setAttribute("goodsList", goodsList);
		//request.setAttribute("goodsList", agdao.getGoodsList()); 이 페이지에서 데이터를 쓰지 않는 경우 이렇게 가능 데이터 토스의 의미
		
		// 페이지 이동(forward)
		// ./admin_goods/admin_goods_list.jsp
		ActionForward forward = new ActionForward();
		forward.setPath("./admin_goods/admin_goods_list.jsp");
		forward.setRedirect(false);
		return forward;
		
	}

}
