package com.itwillbs.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
	// Data Access Object => itwill_board테이블에 관련된 정보 처리 객체

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";

	// DB연결 메서드-커넥션풀 사용
	// => 디비 연결정보 (Connection)를 미리 생성해서 pool에 저장
	// 사용시 연결정보 대여, 사용후 반납처리 (기본처리 로직은 대기->생성후 반납)

	// 1. 라이브러리 설치
	// 2. context.xml 파일 생성(디비연결정보)
	// 3. 파일을 호출해서 디비 연결

	private Connection getCon() throws Exception {
		// 프로젝트 정보를 초기화
		Context initCTX = new InitialContext();

		// 프로젝트에 있는 디비 연결정보(이름)를 불러오기
		DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/mysqlDB");
		// 디비 연결
		con = ds.getConnection();
		System.out.println("DAO : 디비연결 성공! " + con);

		return con;
	}

	// 자원해제
	public void closeDB() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 글쓰기 메서드() - insertBoard(bb)
	public void insertBoard(BoardBean bb) {
		// final String DRIVER="com.mysql.jdbc.Driver";
		// final String DBURL="jdbc:mysql://localhost:3306/jspdb";
		// final String DBID ="root";
		// final String DBPW ="1234";

		int num = 0; // 계산된 글번호 저장

		try {
			// // 1. 드라이버 로드
			// Class.forName(DRIVER);
			// // 2. 디비연결
			// Connection con
			// = DriverManager.getConnection(DBURL, DBID, DBPW );

			// 1.2 디비연결(CP)
			Connection con = getCon();

			// 3. sql 작성(select) & pstmt 객체 생성
			// select max(num) from itwill_board;
			// => rs.next : true
			// => 함수의 결과는 항상 커서가 존재함(데이터 유무와 상관없음)
			// (화살표 모양)
			// select num from itwill_board;
			// => rs.next : false
			// => 함수의 결과가 데이터의 유무에 따라서 커서유무 결정
			// (원 모양)

			// 게시판 번호 계산
			String sql = "select max(num) from itwill_board";

			PreparedStatement pstmt = con.prepareStatement(sql);

			// 4. sql 실행
			ResultSet rs = pstmt.executeQuery();

			// 5. 데이터 처리
			if (rs.next()) {
				// rs.getInt("max(num)");
				num = rs.getInt(1) + 1;
			}

			System.out.println("DAO : 글번호 : " + num);

			// 3. sql 작성(insert) & pstmt 객체 생성
			sql = "insert into itwill_board(num,name,pass,subject,content,"
					+ "readcount,re_ref,re_lev,re_seq,date,ip,file) " + "values(" + "?,?,?,?,?," + "?,?,?,?,now(),"
					+ "?,?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, num);
			pstmt.setString(2, bb.getName());
			pstmt.setString(3, bb.getPass());
			pstmt.setString(4, bb.getSubject());
			pstmt.setString(5, bb.getContent());
			pstmt.setInt(6, 0); // 조회수 0
			pstmt.setInt(7, num); // re_ref 답글 그룹번호 / 일반글번호 == 그룹번호
			pstmt.setInt(8, 0); // re_lev 답글 들여쓰기 / 일반글 들여쓰기 없음 (0)
			pstmt.setInt(9, 0); // re_seq 답글 순서 / 일반글 0
			pstmt.setString(10, bb.getIp());
			pstmt.setString(11, bb.getFile());

			// 4. sql 실행

			pstmt.executeUpdate();

			System.out.println("DAO :  게시글 작성 완료! ");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DAO : 드라이버 로드 실패! ");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DAO : 디비 연결 실패! ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		}

	}
	// 글쓰기 메서드() - insertBoard(bb)

	// getBoardCount()--------------------------------------------
	public int getBoardCount() {
		int cnt = 0;

		try {
			// 1.2 디비연결
			con = getCon();

			// 3 sql 작성 & pstmt 객체 생성
			// 글의 총 개수를 계산
			sql = "select count(*) from itwill_board";
			pstmt = con.prepareStatement(sql);

			// 4 sql 실행
			rs = pstmt.executeQuery();

			// 5 데이터 처리
			if (rs.next()) {
				cnt = rs.getInt(1); // 인덱스
				// cnt = rs.getInt("count(*)");//컬럼명
			}

			System.out.println("DAO : 글 개수 확인 " + cnt);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return cnt;
	}
	// getBoardCount()--------------------------------------------

	// getBoardList()
	public ArrayList getBoardList() {
		// ArrayList : 가변길이 배열(자동으로 배열의 크기를 지정)

		ArrayList boardList = new ArrayList();
		
		try {
			// 1.2 디비연결
			con = getCon();
			// 3 sql 작성 & pstmt 객체
			sql = "select * from itwill_board";
			pstmt = con.prepareStatement(sql);

			// 4 sql 실행
			rs = pstmt.executeQuery();

			// 5 데이터처리
			while(rs.next()){
				// 글 1개의 정보 저장
				BoardBean bb = new BoardBean();
				bb.setContent(rs.getString("content"));
				bb.setDate(rs.getDate("date"));
				bb.setFile(rs.getString("file"));
				bb.setIp(rs.getString("ip"));
				bb.setName(rs.getString("name"));
				bb.setNum(rs.getInt("num"));
				bb.setPass(rs.getString("pass"));
				bb.setRe_lev(rs.getInt("re_lev"));
				bb.setRe_ref(rs.getInt("re_ref"));
				bb.setRe_seq(rs.getInt("re_seq"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setSubject(rs.getString("subject"));
				
				// 글정보를 배열에 1칸 저장
				boardList.add(bb);
			}//while
			
			System.out.println("DAO : 글목록 저장완료!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return boardList;
	}
	// getBoardList()
	
	// getBoardList(startRow,pageSize)
	public ArrayList getBoardList(int startRow,int pageSize){
		
		ArrayList boardList = new ArrayList();
		
		try {
			// 1.2 디비연결
			con = getCon();
			
			// 3 sql 작성  & pstmt 객체
			//  re_ref 내림차순 정렬, re_seq 오름차순
			//  limit 시작행-1,개수 => 원하는 개수만큼 짤라서 처리 
			sql ="select * from itwill_board "
					+ "order by re_ref desc, re_seq asc "
					+ "limit ?,?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);

			// 4 sql 실행
			rs = pstmt.executeQuery();
			// 5 데이터 처리
			
			while(rs.next()){
				// 글 1개의 정보 저장
				BoardBean bb = new BoardBean();
				bb.setContent(rs.getString("content"));
				bb.setDate(rs.getDate("date"));
				bb.setFile(rs.getString("file"));
				bb.setIp(rs.getString("ip"));
				bb.setName(rs.getString("name"));
				bb.setNum(rs.getInt("num"));
				bb.setPass(rs.getString("pass"));
				bb.setRe_lev(rs.getInt("re_lev"));
				bb.setRe_ref(rs.getInt("re_ref"));
				bb.setRe_seq(rs.getInt("re_seq"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setSubject(rs.getString("subject"));
				
				// 글정보를 배열에 1칸 저장
				boardList.add(bb);
			}//while
			
			System.out.println("DAO : 게시판 글 저장완료(페이징처리)");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return boardList;
	}
	// getBoardList(startRow,pageSize)
	
	//	updateReadcount(num)
	public void updateReadcount(int num){
		
		try {
			// 1.2 디비연결
			con = getCon();
			// 3. sql (기존의 조회수 + 1) & pstmt 객체
			sql = "update itwill_board set readcount = readcount + 1 where num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			// 4. sql 실행
			pstmt.executeUpdate();
			
			System.out.println("DAO : 글 조회수 1증가 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	//	updateReadcount(num)
	
	// getBoard(num)
	public BoardBean getBoard(int num){
		BoardBean bb = null;
		
		try {
			// 1.2 디비 연결
			con = getCon();
			// 3. sql (num에 해당하는 모든 글의 정보가져오기) & pstmt객체
			sql = "select * from itwill_board "
					+ " where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			if(rs.next()){
				bb = new BoardBean();
				
				bb.setContent(rs.getString("content"));
				bb.setDate(rs.getDate("date"));
				bb.setFile(rs.getString("file"));
				bb.setIp(rs.getString("ip"));
				bb.setName(rs.getString("name"));
				bb.setNum(rs.getInt("num"));
				bb.setPass(rs.getString("pass"));
				bb.setRe_lev(rs.getInt("re_lev"));
				bb.setRe_ref(rs.getInt("re_ref"));
				bb.setRe_seq(rs.getInt("re_seq"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setSubject(rs.getString("subject"));
			}// if
			
			System.out.println("DAO : 글정보를 저장완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return bb;
	}
	// getBoard(num)
	
	// updateBoard(bb)
	public int updateBoard(BoardBean bb){
		int check = -1;
		
		try {
			//1.2 디비연결
			con = getCon();
			//3. sql 작성 (글이 있는지 판단후 글 수정) & pstmt 객체
			sql = "select pass from itwill_board where num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bb.getNum());
			
			//4. sql 실행
			rs = pstmt.executeQuery();
			
			//5. 데이터처리 
			if(rs.next()){ // 데이터 있을때
				if(bb.getPass().equals(rs.getString("pass"))){
					// 3. sql (데이터 수정) & pstmt 객체
					sql = "update itwill_board set name=?,subject=?,content=? where num=?";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, bb.getName());
					pstmt.setString(2, bb.getSubject());
					pstmt.setString(3, bb.getContent());
					pstmt.setInt(4, bb.getNum());
					
					// 4. sql 실행				
					pstmt.executeUpdate();
					
					check = 1;
					System.out.println("DAO : 회원정보 수정완료!");
					
				}else{
					// 비밀번호 오류 (본인 X)
					check = 0;
				}
			}else{
			   	// 데이터 없을때 (글정보 X)
				check = -1;
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return check;
	}	
	// updateBoard(bb)
	
	// deleteBoard(num,pass)
	public int deleteBoard(int num,String pass){
		int check = -1;
		try {
			// 1.2 디비연결
			con = getCon();
			// 3. sql작성(select) & pstmt 객체
			sql = "select pass from itwill_board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			// 4  sql 실행
			rs = pstmt.executeQuery();
			
			// 5. 데이터 처리
			if(rs.next()){
				if(pass.equals(rs.getString("pass"))){
					// 3. sql(delete)
					sql = "delete from itwill_board where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					// 4. sql 실행
					pstmt.executeUpdate();
					check = 1;
					System.out.println("DAO: 글 삭제 완료!");
					
				}else{
					// 비밀번호 오류
					check = 0;
				}				
			}else{
				// 글없음
				check = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return check;
	}
	// deleteBoard(num,pass)
	
	
	// reInsertBoard(bb)
	public void reInsertBoard(BoardBean bb){
		int num = 0;
		
		try {
			con = getCon();
			
			/////////////////////////////////////////////////////
			// 글번호 계산  
			sql = "select max(num) from itwill_board";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				num = rs.getInt(1)+1;
			}
			System.out.println("DAO : 답글 번호 계산 "+num);
			
			/////////////////////////////////////////////////////
			// 답글 순서 재배치 (update)
			// re_ref 같은 그룹에 있으면서, 기존의 re_seq 값보다 큰값이 있을때
			// re_seq값을 1증가
			
			sql ="update itwill_board set re_seq = re_seq + 1 "
					+ "where re_ref=? and re_seq>?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bb.getRe_ref());
			pstmt.setInt(2, bb.getRe_seq());
			
			pstmt.executeUpdate();
			
			/////////////////////////////////////////////////////
			// 답글을 저장 (insert)
			
			sql="insert into itwill_board "
					+ "values(?,?,?,?,?,?,?,?,?,now(),?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, bb.getName());
			pstmt.setString(3, bb.getPass());
			pstmt.setString(4, bb.getSubject());
			pstmt.setString(5, bb.getContent());
			pstmt.setInt(6, bb.getReadcount());
			pstmt.setInt(7, bb.getRe_ref()); // re_ref : 원글의 그룹번호와 동일
			pstmt.setInt(8, bb.getRe_lev()+1); // re_lev : 원글의 들여쓰기 + 1
			pstmt.setInt(9, bb.getRe_seq()+1); // re_seq : 순서대로 기존의값 +1
			pstmt.setString(10, bb.getIp());
			pstmt.setString(11, bb.getFile());			
			
			pstmt.executeUpdate();
			
			System.out.println("DAO : 답글 작성완료! ");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
	}
	// reInsertBoard(bb)
	
	
	
	
	
	
	
	
	
	
	

}
