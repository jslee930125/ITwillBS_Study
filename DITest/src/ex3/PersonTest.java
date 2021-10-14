package ex3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {

		// PersonService 객체를 생성해서 sayHello() 호출
		// 스프링을 통한 객체 의존관계 주입해서 사용
		BeanFactory fac = new XmlBeanFactory(new FileSystemResource("beans2.xml"));
		
		// 업캐스팅 => 약한결합
		//PersonService ps = fac.getBean("person",PersonService.class);
		PersonService ps = (PersonService)fac.getBean("person");
		// 자신객체 => 강한결합
		//PersonServiceImpl psI = (PersonServiceImpl)fac.getBean("person");
		
		ps.sayHello();
		//psI.sayHello();
		
		/////////////////////////////////////////////////////////////////
		// 생성자를 사용한 객체 의존 주입
		
		PersonService ps2 = fac.getBean("person2",PersonService.class);
		ps2.sayHello();
		
		
		
		
		
		
		
		
		
		
		
	}

}
