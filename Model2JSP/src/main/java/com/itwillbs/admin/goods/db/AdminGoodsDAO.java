package com.itwillbs.admin.goods.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminGoodsDAO {
	
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
		// 디비연결
		
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
		// 자원해제
		
		//insertGoods(DTO)
		public void insertGoods(GoodsDTO gdto) {
			// 게시판 글쓰기와 비슷
			int num = 0;
			try {
				//1.2. 디비연결
				con = getCon();
				// 3. sql & pstmt 객체
				// num(상품번호) 계산 <=> 게시판 글번호 계산
				sql = "select max(num) from itwill_goods";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					num = rs.getInt(1)+1;
				}
				
				System.out.println("DAO : 상품번호 :" +num);
				
				// 3. 상품등록
				sql = "insert into itwill_goods "
						+ "(num,category,name,content,size,color,amount,price,"
						+ "image,best,date) values(?,?,?,?,?,?,?,?,?,?,now())";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setString(2, gdto.getCategory());
				pstmt.setString(3, gdto.getName());
				pstmt.setString(4, gdto.getContent());
				pstmt.setString(5, gdto.getSize());
				pstmt.setString(6, gdto.getColor());
				pstmt.setInt(7, gdto.getAmount());
				pstmt.setInt(8, gdto.getPrice());
				pstmt.setString(9, gdto.getImage());
				pstmt.setInt(10, gdto.getBest());
				
				// 4.sql 실행
				pstmt.executeUpdate();
				
				System.out.println("DAO : 관리자 - 상품등록완료");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			
		}
		//insertGoods(DTO)
		
		//getGoodsList()
		public List<GoodsDTO> getGoodsList(){
			
			List<GoodsDTO> goodsList = new ArrayList<GoodsDTO>();
			
			try {
				 // 1.2.디비연결
				 con = getCon();
				 // 3. sql
				 sql = "select * from itwill_goods";
				 pstmt = con.prepareStatement(sql);
				 // sql 실행
				 rs = pstmt.executeQuery();
				 // 데이터 처리(상품정보를 모두 저장)
				 
				 while(rs.next()) {
					 // 상품 1개의 정보를 DTO에 저장
					 GoodsDTO gdto = new GoodsDTO();
					 gdto.setAmount(rs.getInt("amount"));
					 gdto.setBest(rs.getInt("best"));
					 gdto.setCategory(rs.getString("category"));
					 gdto.setColor(rs.getString("color"));
					 gdto.setContent(rs.getString("content"));
					 gdto.setDate(rs.getString("date"));
					 gdto.setImage(rs.getString("image"));
					 gdto.setName(rs.getString("name"));
					 gdto.setNum(rs.getInt("num"));
					 gdto.setPrice(rs.getInt("price"));
					 gdto.setSize(rs.getString("size"));
					 
					 // DTO를 LIST 한칸에 저장
					 
					 goodsList.add(gdto);
					 
				 }//while
				 
				 System.out.println("DAO : 관리자-상품목록 저장완료");
				 
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			
			return goodsList;
		}
		
		//getGoodsList()
		
		//getAdminGoods(num)
		public GoodsDTO getAdminGoods(int num) {
			
			// 래퍼런스만 준비 - if안에 넣으면 지역변수가 되니까
			GoodsDTO goods = null;
			
			try {
				// 디비연결
				con = getCon();
				// sql 
				sql = "select * from itwill_goods where num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				
				// sql 실행
				rs = pstmt.executeQuery();
				
				// 데이터 제어
				if(rs.next()) {
					// 조회한 상품정보를 저장
					goods = new GoodsDTO();
					
					goods.setAmount(rs.getInt("amount"));
					goods.setBest(rs.getInt("best"));
					goods.setCategory(rs.getString("category"));
					goods.setColor(rs.getString("color"));
					goods.setContent(rs.getString("content"));
					goods.setDate(rs.getString("date"));
					goods.setImage(rs.getString("image"));
					goods.setName(rs.getString("name"));
					goods.setNum(rs.getInt("num"));
					goods.setPrice(rs.getInt("price"));
					goods.setSize(rs.getString("size"));
				} // if
				
				System.out.println("DAO : 상품정보 저장 완료(" +num+ "번)");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			
			return goods;
		}
		
		//getAdminGoods(num)
		
		// modifyGoods(gdto)
		
		public void modifyGoods(GoodsDTO gdto) {
			
			try {
				// 디비연결
				con = getCon();
				// sql - update
				sql = "update itwill_goods set category=?,name=?,color=?, "
						+ "amount=?,size=?,best=?,content=? where num=?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, gdto.getCategory());
				pstmt.setString(2, gdto.getName());
				pstmt.setString(3, gdto.getColor());
				pstmt.setInt(4, gdto.getAmount());
				pstmt.setString(5, gdto.getSize());
				pstmt.setInt(6, gdto.getBest());
				pstmt.setString(7, gdto.getContent());
				pstmt.setInt(8, gdto.getNum());
				
				pstmt.executeUpdate();
				
				System.out.println("DAO : 관리자 - 상품수정완료");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			
		}
		// modifyGoods(gdto)
		
		//deleteGoods(num)
		public void deleteGoods(int num) {
			
			try {
				// 디비연결
				con = getCon();
				// sql - delete
				sql = "delete from itwill_goods where num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				
				// 실행
				pstmt.executeUpdate();
				System.out.println("DAO : 관리자 - 상품 f삭제");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			
		}		
		//deleteGoods(num)
}
