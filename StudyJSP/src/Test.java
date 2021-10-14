
public class Test {

	public static void main(String[] args) {
		
		String name = null;
		
		System.out.println((4<2)&&(name.length()==4));
		// =>  F && F => false 결과를 출력
		//     F && ? => 결과는 항상 false 이기 때문에  뒤에 코드 실행 X
		
		//System.out.println((4>2)&&(name.length()==4));
		// => T && ? => 뒤연산의 결과에 따라서 값이 변경되기 때문에 실행O
		//   => 코드 자체 에러 실행됨
		

	}

}
