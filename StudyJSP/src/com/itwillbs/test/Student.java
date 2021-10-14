package com.itwillbs.test;

public class Student {
	// 학생의 정보를 저장 (이름,국,영,수)

	private String name;
	private int kor;
	private int eng;
	private int math;
	//int test;
	
	//public Student() {  }
	// 기본생성자는 컴파일러가 오버로딩된 생성자가 없을경우 자동으로 기본생성자를 생성
	

	// set/get()생성
	// alt + shift + s +r
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

}
