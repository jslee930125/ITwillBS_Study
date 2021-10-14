package ex2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {

	public static void main(String[] args) {
		
		// MsgBean객체 -> sayHello()동작 출력   1) 한글 출력 2) 영어 출력
		
		// HelloApp 객체는 MsgBeanKR,MsgBeanEN 객체를 의존하고있다. (필요하다)
		// 한국어
		MsgBeanKR kr = new MsgBeanKR();
		kr.sayHello("홍길동");
		
		// 영어
		MsgBeanEN en = new MsgBeanEN();
		en.sayHello("kim");
		// => 객체를 직접 생성해서 사용 =>  강한결합
		
		System.out.println("------------------------------------------");
		// 상속관계를 통한 업캐스팅
		// HelloApp객체는 MsgBean객체를 의존하고 있다.
		// 객체를 직접 생성 => 강한결합(x)
		// 인터페이스 형태의 부모객체를 생성(업캐스팅) => 약한결합
		
		// 한국어 
		MsgBean mb = new MsgBeanKR();
		mb.sayHello("홍길동");
		// 영어
		MsgBean mb2 = new MsgBeanEN();
		mb2.sayHello("Kim");
		
		System.out.println("------------------------------------------");
		System.out.println(" 스프링을 사용한 의존 주입 ");
		// 강한결합? 약한결합!
		
		BeanFactory fac = new XmlBeanFactory(new FileSystemResource("beans.xml"));
		// MsgBeanEN객체 생성 -> Spring에서 생성(bean)-> 가져와서 사용
		
		// .class는 부모형태로 들고 오는 것
		MsgBean mbs = fac.getBean("msgbeanEn",MsgBean.class);
		mbs.sayHello("스프링");
		
		// 한국어 출력 (스프링을 사용한 의존관계 주입)
		MsgBean mbs2 = fac.getBean("msgbeanKr",MsgBean.class);
		mbs2.sayHello("스프링!!");
		
		
		

	}

}
