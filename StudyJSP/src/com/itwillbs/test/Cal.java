package com.itwillbs.test;

public class Cal {
	// 계산기 객체
	
	// 총합 => 결과 리턴
	//  전달인자 4개 (이름,국,영,수)
	public double Cal_Sum(String name,int k,int e, int m){
		return k+e+m;		
	}
	//  전달인자 1개 (학생객체)
	public double Cal_Sum(Student stu){
		return stu.getKor()+stu.getEng()+stu.getMath();		
	}
	// 평균 => 결과 출력
	//  전달인자 4개 (이름,국,영,수)
	public void Cal_AVG(String name,int k,int e,int m){
		System.out.println(name+"님 평균 : "+((k+e+m)/3.0));
		System.out.println(name+"님 평균 : "+(Cal_Sum(name, k, e, m)/3.0));
	}
	//  전달인자 1개 (학생객체)
	public void Cal_AVG(Student stu){
		System.out.println(stu.getName()+"님 평균 : "
	                 +((stu.getKor()+stu.getEng()+stu.getMath())/3.0));
	}

}






