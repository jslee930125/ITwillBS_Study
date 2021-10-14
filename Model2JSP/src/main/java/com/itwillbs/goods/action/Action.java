package com.itwillbs.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
	// => 처리동작이 필요한 객체의 경우 해당인터페이스를 상속해서
	//  반드시 execute()메서드를 구현(오버라이딩)하도록 하는 설계
	 // => 강제적으로 구현하게 만들어서 다형성을 생성
	
	// public abstract ActionForward execute();
	// ActionForward execute();
}
