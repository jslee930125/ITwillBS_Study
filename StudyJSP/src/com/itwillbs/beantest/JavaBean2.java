package com.itwillbs.beantest;

public class JavaBean2 {
	
	private String id;
	private String pass;
	private int age;
	private String tel;
	
	// alt shift s + r
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	// alt shift s + s 
	@Override
	public String toString() {
		return "JavaBean2 [id=" + id + ", pass=" + pass + ", age=" + age + ", tel=" + tel + "]";
	}

}
