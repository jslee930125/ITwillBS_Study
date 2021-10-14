package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnectionTest {

	// 드라이버 주소
	public static String DRIVER = "com.mysql.cj.jdbc.Driver";
	// 디비명
	public static String DBURL = "jdbc:mysql://localhost:3306/springdb?serverTimezone=Asia/Seoul";
	// 계정(ID)
	public static String DBID = "root";
	// 계정(PW)
	public static String DBPW = "1234";

	// @Test
	public void testCon() throws Exception {
		// 1.드라이버 로드
		Class.forName(DRIVER);

		// 2.디비연결
		Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
		System.out.println("디비연결정보: " + con);

	}

	/*
	 * @Test public void testCon2() {
	 * 
	 * //try-catch구문
	 * 
	 * try { 
	 * 	 	1.드라이버 로드 
	 * 		Class.forName(DRIVER); 
	 *  
	 *   	2.디비연결 Connection con =
	 * 		DriverManager.getConnection(DBURL,DBID,DBPW);
	 * 
	 * 		System.out.println("디비연결정보: "+con);
	 * 
	 * } catch (Exception e) { 
	 * 		e.printStackTrace(); 
	 * }
	 * 
	 * try { 
	 * 		1.드라이버 로드 
	 * 		Class.forName(DRIVER); 
	 * } catch (Exception e) {
	 * 		e.printStackTrace(); 
	 * }
	 * 
	 * try ~ with 구문 (JDK 1.7 이후 사용가능) 
	 * finally 블럭을 제거한 예외처리 구문 
	 * -> 자원해제 구문을 포함한 예외처리구문 
	 * try(AutoCloseable 인터페이스를 구현한 객체 작성/사용 - 디비관련 대부분의 객체들) 
	 * 예외 처리 끝나고 자동으로 자원해제 

	 * try(Connection con = DriverManager.getConnection(DBURL,DBID,DBPW)) { 
	 * 	System.out.println("디비연결정보: "+con); 
	 * } catch (Exception e) {
	 * 	e.printStackTrace(); 
	 * } 
	 */

}