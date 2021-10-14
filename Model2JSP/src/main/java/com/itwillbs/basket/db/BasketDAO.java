package com.itwillbs.basket.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.admin.goods.db.GoodsDTO;

public class BasketDAO {
	
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
				
				// checkGoods(bkdto);
				public int checkGoods(BasketDTO bkdto){
					
					int result = 0;
					
					try {
						 // 1.2.디비연결
						 con = getCon();
						 // 3. sql - id,num,size,color 옵션이 동일한 정보를 조회
						 sql = "select * from itwill_basket "
						 		+ "where b_m_id=? and b_g_num=? and "
						 		+ "b_g_size=? and b_g_color=?";
						 
						 pstmt = con.prepareStatement(sql);
						 
						 pstmt.setString(1, bkdto.getB_m_id());
						 pstmt.setInt(2, bkdto.getB_g_num());
						 pstmt.setString(3, bkdto.getB_g_size());
						 pstmt.setString(4, bkdto.getB_g_color());
						 
						 // sql 실행
						 rs = pstmt.executeQuery();
						 
						 // 데이터 처리(상품정보를 모두 저장)
						 if(rs.next()) {
							 // 이미 장바구니에 들어있는 상품 => 기존의 상품 수량만 변경
							 result = 1;
							 // 3.sql
							 sql = "update itwill_basket set b_g_amount=b_g_amount+?"
							 		+ "where b_m_id=? and b_g_num=? and b_g_size=? and b_g_color=?";
							 pstmt = con.prepareStatement(sql);
							 
							 //?
							 pstmt.setInt(1, bkdto.getB_g_amount());
							 pstmt.setString(2, bkdto.getB_m_id());
							 pstmt.setInt(3, bkdto.getB_g_num());
							 pstmt.setString(4, bkdto.getB_g_size());
							 pstmt.setString(5, bkdto.getB_g_color());
							 
							 // sql 실행
							 result = pstmt.executeUpdate();
							 
						 }//if
						 
						 System.out.println("DAO : 장바구니 상품 체크");
						 
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						closeDB();
					}
					
					return result;
				}
				//checkGoods(bkdto);
				
				//basketAdd(bkdto);
				public void basketAdd(BasketDTO bkdto){
					
					int b_num = 0;
					
					try {
						 // 1.2.디비연결
						 con = getCon();
						 // 3. sql - 장바구니 번호 계산
						 sql = "select max(b_num) from itwill_basket";	 
						 pstmt = con.prepareStatement(sql);
						 
						 // sql 실행
						 rs = pstmt.executeQuery();
						 
						 if(rs.next()) {
							 b_num = rs.getInt(1)+1;
							 //b_num = rs.getInt(max(b_num))+1;
						 }
						 
						 System.out.println("DAO : b_num :" + b_num);
						 
						 // sql (insert)
						 sql = "insert into itwill_basket "
						 		+ "values(?,?,?,?,?,?,now())";
						 
						 pstmt = con.prepareStatement(sql);
						 pstmt.setInt(1, b_num);
						 pstmt.setString(2, bkdto.getB_m_id());
						 pstmt.setInt(3, bkdto.getB_g_num());
						 pstmt.setInt(4, bkdto.getB_g_amount());
						 pstmt.setString(5, bkdto.getB_g_size());
						 pstmt.setString(6, bkdto.getB_g_color());
						 
						 //sql 실행
						 pstmt.executeUpdate();
						 
						 System.out.println("DAO : 장바구니 - 상품등록완료");
						 
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						closeDB();
					}
					
				}
				//basketAdd(bkdto);
				
				// getBasketList(id);
				// Vector는 설정값에 따라 자동 동기화 - 백엔드 서버단에서 자주 사용
				// Arraylist는 자동 동기화 하지 않음 - 클라이언트단에서 자주 사용
				// 같은 List 계열
				
 				public Vector getBasketList(String id){
 					
 					// 장바구니 정보 저장(상품번호, 구매수량, 옵션...)
 					List<BasketDTO> basketList = new ArrayList<BasketDTO>();
 					// 상품정보 저장(상품번호,상품명,가격,이미지....)
 					List<GoodsDTO> goodsList = new ArrayList<GoodsDTO>();
 					// 장바구니 정보 + 상품정보 리스트 모두를 저장하는 벡터(리스트)
 					Vector totalList = new Vector(); 
 					
					try {
						 // 1.2.디비연결
						 con = getCon();
						 // 3. sql - 장바구니 리스트
						 sql = "select * from itwill_basket where b_m_id=?";	 
						 pstmt = con.prepareStatement(sql);
						 pstmt.setString(1, id);
						 
						 // sql 실행
						 rs = pstmt.executeQuery();
						 
						 // 데이터 처리
						 while(rs.next()) { // 장바구니 정보가 있을 때
							 BasketDTO bkdto = new BasketDTO();
							 bkdto.setB_date(rs.getDate("b_date"));
							 bkdto.setB_g_amount(rs.getInt("b_g_amount"));
							 bkdto.setB_g_color(rs.getString("b_g_color"));
							 bkdto.setB_g_num(rs.getInt("b_g_num"));
							 bkdto.setB_g_size(rs.getString("b_g_size"));
							 bkdto.setB_m_id(rs.getString("b_m_id"));
							 bkdto.setB_num(rs.getInt("b_num"));
							 
							 basketList.add(bkdto);
							 
							 // 장바구니에 저장된 상품정보를 조회
							 
							 sql = "select * from itwill_goods where num=?";
							 PreparedStatement pstmt2 = con.prepareStatement(sql);
							 pstmt2.setInt(1, bkdto.getB_g_num());
							 
							 // 실행
							 ResultSet rs2 = pstmt2.executeQuery();
							 // 여기서 rs로 쓰면 rs결과가 1개로 바뀌므로 이대로 놔두면 최종적으로 장바구니 정보를 1개만 들고옴
							 // 새로운 rs2를 만들어야 함
							 
							 if(rs2.next()) {
								 // 해당 num은 pk값이므로 해당하는 값이 1개밖에 없으니까 if문 사용
								 // 장바구니에 저장한 상품정보가 있을 때
								 GoodsDTO gdto = new GoodsDTO();
								 gdto.setPrice(rs2.getInt("price"));
								 gdto.setName(rs2.getString("name"));
								 gdto.setImage(rs2.getString("image"));
								 // 추가정보 필요시 구문 추가
								 
								 goodsList.add(gdto);
							 }// if - 상품정보 저장
							 
						 }// while - 장바구니 정보 저장
						 
						 System.out.println("DAO : 장바구니 정보, 상품정보 저장 완료");
						 System.out.println("DAO: 장바구니 개수: " +basketList.size());
						 System.out.println("DAO: 상품 개수" +goodsList.size());
						 // vector에 정보를 저장
						 
						 totalList.add(basketList);
						 totalList.add(goodsList);
						 
						 System.out.println("DAO : totalList 저장 완료!");
						 
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						closeDB();
					}
					
					return totalList;
				}
				//getBasketList(id);
 				
 				//basketDelete(b_num);
 				public void basketDelete(int b_num){
										
					try {
						 // 1.2.디비연결
						 con = getCon();
						 // 3. sql - 장바구니 번호 계산
						 sql = "delete from itwill_basket where b_num=?";	 
						 pstmt = con.prepareStatement(sql);
						 pstmt.setInt(1, b_num);
						 
						 // sql 실행
						 int result = pstmt.executeUpdate();
						 
						 System.out.println("DAO : 장바구니 삭제" + result);
						 
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						closeDB();
					}
					
				}
 				
 				//basketDelete(b_num);
 				
 				//basketDelete(id); overloading
 				public void basketDelete(String id){
					try {
						 // 1.2.디비연결
						 con = getCon();
						 // 3. sql
						 sql = "delete from itwill_basket where b_m_id=?";	 
						 pstmt = con.prepareStatement(sql);
						 // ?
						 pstmt.setString(1, id);
						 // 4. sql 실행
						 pstmt.executeUpdate();
						 
						 System.out.println("DAO : 구매 후 장바구니 비우기");
						 
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						closeDB();
					}
					
				}
 				
 				//basketDelete(id);
}
