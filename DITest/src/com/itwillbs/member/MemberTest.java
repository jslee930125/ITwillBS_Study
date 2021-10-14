package com.itwillbs.member;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MemberTest {

	public static void main(String[] args) {

		// MemberService 인터페이스 객체를 구현하는 
		// MemberServiceImpl 객체를 생성
		// MemberDAO 객체의 정보를 저장가능, 객체의 정보는 set메서드로 초기화 가능
		// listMembers() - "회원정보 출력"
		// * 회원정보 리스트를 출력하는 프로그램을 생성하시오.
		// * 객체의 생성은 member.xml에서 생성하시오
		
		BeanFactory fac = new XmlBeanFactory(new FileSystemResource("member.xml"));
				
		MemberService action = fac.getBean("memberService",MemberService.class);
		
		action.listMembers();
				
		
		
		
	}

}
