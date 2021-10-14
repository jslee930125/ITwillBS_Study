package com.itwillbs.test;

// * 패키지명은 회사의 도메인 주소를 반대로 사용
// test.itwillbs.com
// www.itwillbs.com


public class Main {
	
	// mySum(k,e,m)
	public double mySum(int k,int e,int m){
		int sum = k+e+m;
		return sum;
		//return k+e+m;
	}
	public void mySum(int k,int e,int m,String name){
		System.out.println(name+"님 총점 : "+(k+e+m));
	}
	public void mySum(Student kim){
		
		System.out.println(kim.getName()+"님 총점 : "+
		    (kim.getKor()+kim.getEng()+kim.getMath())   );
		
	}
	
	
	
	// myAVG(k,e,m)
	public static void myAVG(int k,int e,int m){
		System.out.println("평균 : "+(k+e+m)/3.0);
		//System.out.println("평균 : "+mySum(k+e+m)/3.0);
	}
	

	public static void main(String[] args) {
		
		// 학생정보 -> 점수 총합,평균 출력
		// (이름,국,영,수)	
		String name = "홍길동";
		int kor = 80;
		int eng = 90;
		int math = 89;
		
		System.out.println(name+"님의  총합 : "+(kor+eng+math));
		System.out.println(name+"님의 평균 : "+ (kor+eng+math)/3.0);
		
		System.out.println("-----------------------------------");
		// 총합 계산하는 메서드 mySum(k,e,m) 값을 리턴 - 인스턴스 메서드
		Main m = new Main();
		System.out.println("총합 : "+ m.mySum(kor,eng,math));
		
		// 평균 계산하는 메서드 myAVG(k,e,m) 출력 - 스테틱 메서드
		myAVG(kor, eng, math);
		
		System.out.println("-----------------------------------");
		
		// 학생의 정보를 저장하는 객체를 생성
		Student kim = new Student();
		//kim.test=100;
		//kim.name="홍길동";
		kim.setName("홍길동");
		kim.getName();
		
		// "김학생 국:77,영:88,수:99" 총점 계산
		// 위 학생정보를 사용해서 총점을 출력하는 메서드를 오버로딩
		
		Student jung = new Student();
		
		jung.setName("정학생");
		jung.setKor(77);
		jung.setEng(88);
		jung.setMath(99);
		
		
		m.mySum(jung);
		m.mySum(jung.getKor(), jung.getEng(),jung.getMath(), jung.getName());
		
		// 동작 분리 -> 계산하는 메서드 동작을 분리
		
		// Cal 객체 - 총점/평균메서드 구현
		
		// 계산기 객체 
		Cal c = new Cal();
		System.out.println(c.Cal_Sum("홍길동", 100, 50, 70));
		
		Student stu = new Student();
		stu.setName("홍길동");
		stu.setKor(100);
		stu.setEng(50);
		stu.setMath(70);
		
		System.out.println(c.Cal_Sum(stu));
		
		c.Cal_AVG(stu);
		
		
		
		
		
	}

}
