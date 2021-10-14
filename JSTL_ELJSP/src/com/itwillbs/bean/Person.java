package com.itwillbs.bean;

//Person 사람 - 이름,나이,휴대폰(객체)
public class Person {

	private String name;
	private int age;
	private Phone phone;

	// alt shift s + r
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}
