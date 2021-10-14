package com.itwillbs.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	// 공통의 멤버변수(전역변수,인스턴스변수)
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";

	// 공통의 멤버 메서드
	// 디비 연결 (커넥션풀)
	private Connection getCon() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/model2");
		return ds.getConnection();
		
		// con = ds.getConnection();
		// return con;
	}
	// 자원 해제
	public void closeDB(){
		try {
			if(rs != null)	 rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// insertMember(mdto)
	public void insertMember(MemberDTO mdto){
		
		try {
			// 1.2. 디비연결
			con = getCon();
			// 3. sql 작성 & pstmt생성
			sql = "insert into itwill_member (id,pass,name,age,gender,email,reg_date) "
					+ "values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			// 3-1. ? 처리
			pstmt.setString(1, mdto.getId());
			pstmt.setString(2, mdto.getPass());
			pstmt.setString(3, mdto.getName());
			pstmt.setInt(4, mdto.getAge());
			pstmt.setString(5, mdto.getGender());
			pstmt.setString(6, mdto.getEmail());
			pstmt.setTimestamp(7, mdto.getReg_date());
			// 4. sql 실행
			pstmt.executeUpdate();
			
			System.out.println("DAO : 회원가입 성공!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
	}
	// insertMember(mdto)
	
	
	// loginCheck(id,pass)
	public int loginCheck(String id,String pass){
		int result = -1;
		try {
			// 1.2. 디비연결
			con = getCon();
			// 3. sql 구문작성 & pstmt객체 
			sql ="select pass from itwill_member where id=?";
			pstmt = con.prepareStatement(sql);
			
			// ? 
			pstmt.setString(1, id);
			// 4 sql 실행
			rs = pstmt.executeQuery();
			// 5 데이터 처리
			
			if(rs.next()){ // sql 결과가 있을때
				// 회원
				if(pass.equals(rs.getString("pass"))){
					// 본인
					System.out.println("DAO : 로그인 성공! ");
					result = 1;
				}else{
					// 비밀번호 오류
					System.out.println("DAO : 비밀번호 오류! ");
					result = 0;
				}
			}else{ // sql 결과가 없을때
				// 비회원
				System.out.println("DAO : 비회원! ");
				result = -1;
			}
			
			System.out.println("DAO : 로그인 체크 완료! "+result);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return result;
	}
	
	// loginCheck(id,pass)
	
	// getMember(id)
	public MemberDTO getMember(String id){
		MemberDTO mdto = null;
		try {
			// 1.2. 디비 연결
			con = getCon();
			// 3 sql 
			sql = "select * from itwill_member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			// 4 sql 실행
			rs = pstmt.executeQuery();
			// 5 데이터 처리
			if(rs.next()){
				mdto = new MemberDTO();
				
				mdto.setAge(rs.getInt("age"));
				mdto.setEmail(rs.getString("email"));
				mdto.setGender(rs.getString("gender"));
				mdto.setId(rs.getString("id"));
				mdto.setName(rs.getString("name"));
				mdto.setPass(rs.getString("pass"));
				mdto.setReg_date(rs.getTimestamp("reg_date"));
			}
			
			System.out.println(" DAO : id에 해당하는 회원정보 저장 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return mdto;
	}
	// getMember(id)
	
	// updateMember(mdto)
	public int updateMember(MemberDTO mdto){
		int check = -1;
		
		try {
			// 1.2. 디비 연결
			con = getCon();
			// 3. sql
			sql = "select pass from itwill_member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getId());
			
			// 4. sql 실행
			rs = pstmt.executeQuery();
			
			// 5. 데이터 처리 
			if(rs.next()){
				// 아이디 있는경우
				if(mdto.getPass().equals(rs.getString("pass"))){
					// 본인 - 회원정보 수정
					// 3. sql
					sql = "update itwill_member set "
							+ "name=?,age=?,gender=?,email=? "
							+ "where id=? ";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, mdto.getName());
					pstmt.setInt(2, mdto.getAge());
					pstmt.setString(3, mdto.getGender());
					pstmt.setString(4, mdto.getEmail());
					pstmt.setString(5, mdto.getId());
					
					// 4.sql 실행
					check = pstmt.executeUpdate();
					//check = 1;
				}else{
					// 비밀번호 오류
					check = 0;
				}				
			}else{
				// 아이디 없음
				check = -1;
			}
			
			System.out.println("DAO : 정보 수정완료! "+check);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
		return check;		
	}
	// updateMember(mdto)
	
	// deleteMember(id,pass)
	public int deleteMember(String id,String pass){
		int check = -1;
		
		try {
			// 1.2. 디비 연결
			con = getCon();
			// 3 sql
			sql = "select pass from itwill_member where id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			// 4 sql 실행
			rs = pstmt.executeQuery();
			// 5 데이터 처리
			if(rs.next()){
				// 회원
				if(pass.equals(rs.getString("pass"))){
					// 본인 -> 삭제
					// 3
				    sql = "delete from itwill_member where id=?";
				    pstmt  = con.prepareStatement(sql);
				    pstmt.setString(1, id);
					// 4
				    check = pstmt.executeUpdate();
				}else{
					// 오류
					check = 0;					
				}				
			}else{
				// 비회원
			   check = -1;	
			}	
			
			System.out.println(" DAO : 회원 탈퇴처리 완료 "+check);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return check;
	}
	// deleteMember(id,pass)

	// getMemberList()
	public List<MemberDTO> getMemberList(){
		ArrayList<MemberDTO> memberList
                       = new ArrayList<MemberDTO>();
		try {
			// 1.2 디비 연결
			con = getCon();
			// 3 sql
			sql = "select * from itwill_member where id != ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "admin");
			
			// 4 sql 실행
			rs = pstmt.executeQuery();
			
			// 5 데이터 처리
			while(rs.next()){
				// 회원 1명의 정보를 저장
				MemberDTO dto = new MemberDTO();
				
				dto.setAge(rs.getInt("age"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPass(rs.getString("pass"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				
				// 1명의 정보 -> 리스트 1칸에 저장
				memberList.add(dto);				
			}// while끝
			
			System.out.println(" DAO : 회원 목록을 저장 완료! ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return memberList;
	}
	// getMemberList()
	

	
	
	
	
	
	
	
	
	

}
