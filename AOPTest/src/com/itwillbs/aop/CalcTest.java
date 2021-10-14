package com.itwillbs.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		
		// Calculator 객체를 생성 -> 계산
		// Calculator 객체와 의존 관계
		
		// 외부(스프링)에서 생성된 객체정보를 사용
		ApplicationContext appCTX 
		    = new ClassPathXmlApplicationContext("aoptest.xml");
		
		// 의존 주입 (의존관계의 객체를 가져와서 사용)
		//		Calculator c = appCTX.getBean("calTarget",Calculator.class);
		//		c.add(100, 200);
		
		//  AOP 
		Calculator cAOP = appCTX.getBean("proxyCal",Calculator.class);
		cAOP.add(500, 300);
		
		
		
		
		

	}

}
