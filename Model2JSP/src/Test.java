
public class Test {

	public static void main(String[] args) {
		
		String str = "abcde";
		System.out.println(str);
		str.toUpperCase(); //대문자로 변경
		System.out.println(str);
		System.out.println(str.toUpperCase());
		
		System.out.println("------------------------");
		
		StringBuffer sb = new StringBuffer();
		sb.append("abcde");
		System.out.println(sb);		
		sb.reverse();// 뒤집기
		System.out.println(sb);	
		System.out.println(sb.reverse());
		
		
		
		

	}

}
