package com.itwillbs.admin.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.goods.db.AdminGoodsDAO;
import com.itwillbs.admin.goods.db.GoodsDTO;
import com.sun.jdi.connect.Connector.IntegerArgument;

public class AdminGoodsModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("M : AdminGoodsModifyAction_execute() 호출");
		
		// 한글처리
		request.setCharacterEncoding("utf-8");
		// 전달된 정보를 저장(DTO)
		GoodsDTO gdto = new GoodsDTO();
		gdto.setNum(Integer.parseInt(request.getParameter("num")));
		gdto.setCategory(request.getParameter("category"));
		gdto.setName(request.getParameter("name"));
		gdto.setPrice(Integer.parseInt(request.getParameter("price")));
		gdto.setColor(request.getParameter("color"));
		gdto.setAmount(Integer.parseInt(request.getParameter("amount")));
		gdto.setSize(request.getParameter("size"));
		gdto.setContent(request.getParameter("content"));
		gdto.setBest(Integer.parseInt(request.getParameter("best")));
		
		
		//수정할 정보를 출력
		System.out.println(" M :  수정할 정보" + gdto);
		
		// 상품정보 DB에 수정
		// dao - modifyGoods(gdto)
		AdminGoodsDAO agdao = new AdminGoodsDAO();
		agdao.modifyGoods(gdto);
		
		// 페이지 이동(./AdminGoodsList.ag)
		ActionForward forward = new ActionForward();
		forward.setPath("./AdminGoodsList.ag");
		forward.setRedirect(true);
		return forward;
	}

}
