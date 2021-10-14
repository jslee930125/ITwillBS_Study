package com.itwillbs.beantest;

public class JavaBean1 {

	// 테이블의 컬럼명 == 자바빈 변수명 == 파라미터명
	private String id;

	// public JavaBean1() { }

	// alt shift s + r
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// 메서드 오버라이딩
	// alt shift s + v
	// @Override
	// public String toString() {
	// return "메서드 오버라이딩!";
	// }
	
	// alt shift s + s
	@Override
	public String toString() {
		return "JavaBean1 [id=" + id + "]";
	}

	
	
	
	
	
	

}
