package ex3;

public class PersonServiceImpl implements PersonService{

	private String name;
	private int age;
	
	// 생성자 오버로딩
	public PersonServiceImpl() {	}
	public PersonServiceImpl(String name) {
		this.name = name;
	}
	
	//setter
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void sayHello() {
		System.out.println("이름 : "+name+", 나이 : "+age);		
	}	
}
