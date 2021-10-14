package com.itwillbs.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// 어드바이스
public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invo) throws Throwable {
		// 보조기능 (로그출력)
		System.out.println("[메서드 호출 전] : LoggingAdvice 클래스-invoke() ");
		System.out.println(invo.getMethod()+" 메서드 호출전!! ");
		
		Object obj = invo.proceed(); //  주기능 수행	

		// 보조기능 (로그출력)
		System.out.println("[메서드 호출 후] : LoggingAdvice 클래스-invoke() ");
		System.out.println(invo.getMethod()+" 메서드 호출후!! ");
		
		return obj;
	}

}
