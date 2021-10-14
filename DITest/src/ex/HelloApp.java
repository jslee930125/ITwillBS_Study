package ex;

public class HelloApp {
	
	public static void sayGoodBye() {
		System.out.println(" GoodBye ~! ");
	}

	public static void main(String[] args) {
		
		// HelloApp 객체는 MsgBean 객체가 필요하다.
		// HelloApp 객체는 MsgBean 객체를 의존하고있다.
		sayGoodBye();
		
		MsgBean mb = new MsgBean(); //의존관계가 있음 => 강한결합
		mb.sayHello("학생");

	}

}
