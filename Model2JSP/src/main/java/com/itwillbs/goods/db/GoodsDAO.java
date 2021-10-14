package com.itwillbs.goods.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.admin.goods.db.GoodsDTO;
import com.itwillbs.basket.db.BasketDTO;

public class GoodsDAO {
	
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
			
			//getGoodsList()
			public List<GoodsDTO> getGoodsList(){
				
				List<GoodsDTO> goodsList = new ArrayList<GoodsDTO>();
				// list는 박스같은 것, 밖에서 미리 만들고 
				// bean형태들은 필요할때 while문 안에서 생성
				
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
					 
					 System.out.println("DAO : 일반-상품목록 저장완료");
					 
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeDB();
				}
				
				return goodsList;
			}
			
			//getGoodsList()
			
			// String과 StringBuffer의 차이점
			// String = 메서드를 통한 실행정보 저장x => 바로 사용해야 함, 기존값 변경x
			// StringBuffer = 메서드를 통한 실행정보 저장o => 기본값 변경o
			
			// String str = "abcde";
			// str출력시 : abcde
			// str.toUpperCase(); 대문자로 변경
			// str 출력시 여기서도 abcde 대문자로 나오지 않음, 메서드 종료 후에도 저장하지 않음
			// str.toUpperCase()로 출력해야 그렇게 나옴
			
			// StringBuffer의 경우
			// StringBuffer sb = new StringBuffer();
			// sb.append("abcde");
			// sb 출력시 abcde
			// sb.reverse(); 문자열 뒤집기
			// sb 출력시 edcba로 출력이 됨
			// 여기서 sb.reverse 출력시 다시 abcde로 출력이 됨
			
			// getGoodsList(item)
			public List<GoodsDTO> getGoodsList(String item){
				
				List<GoodsDTO> goodsList = new ArrayList<GoodsDTO>();
				
				StringBuffer SQL = new StringBuffer();
				
				try {
					// 1.2. 디비연결
					con = getCon();
					// 3. sql (item값에 따른 구문변경)
					// sql = "select * from itwill_goods";
					SQL.append("select * from itwill_goods ");
					if(item.equals("ALL")){	}
					else if(item.equals("best")){
						//sql = "select * from itwill_goods where best=?";
						SQL.append("where best=?");
					}else{
						SQL.append("where category=?");
					}
					
					//pstmt = con.prepareStatement(SQL.toString());
					pstmt = con.prepareStatement(SQL+"");
					
					// ?
					if(item.equals("ALL")){}
					else if(item.equals("best")){
						pstmt.setInt(1, 1);
						// select * from itwill_goods where best=1
					}else{// 카테고리
						pstmt.setString(1, item);
						// select * from itwill_goods where category=?
					}
					
					
					// 4. sql 실행
					rs = pstmt.executeQuery();
					// 5. 데이터 처리
					while(rs.next()){
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
						
						// 리스트 한칸에 DTO 객체 하나를 저장
						goodsList.add(gdto);
					}// while
					
					System.out.println(" DAO : "+item+"정보 리스트 조회 완료");
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeDB();
				}
				return goodsList;
			}
			// getGoodsList(item)
			
			//getGoods(num);
			public GoodsDTO getGoods(int num){
				
				GoodsDTO gdto = null;
				
				try {
					 // 1.2.디비연결
					 con = getCon();
					 // 3. sql
					 sql = "select * from itwill_goods where num=?";
					 pstmt = con.prepareStatement(sql);
					 pstmt.setInt(1, num);
					 // sql 실행
					 rs = pstmt.executeQuery();
					 // 데이터 처리(상품정보를 모두 저장)
					 
					 if(rs.next()) {
						 // 상품 1개의 정보를 DTO에 저장
						 gdto = new GoodsDTO();
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
						 
					 }
					 
					 System.out.println("DAO : " + num+ "번 상품정보 저장완료");
					 System.out.println("DAO : " + gdto);
					 
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeDB();
				}
				
				return gdto;
			}
			
			//getGoods(num);
			
			//updateAmount(basketList);
			public void updateAmount(List basketList) {
				// 판매된 상품들의 수량을 제거			
				
				try {
					 // 1.2.디비연결
					 con = getCon();
					 
					 for(int i=0; i<basketList.size(); i++) {
						 BasketDTO bkdto = (BasketDTO) basketList.get(i);
						 
					 // 3. sql(기존의 수량 - 판매수량)
					 sql = "update itwill_goods set amount = amount-? where num=?";
					 pstmt = con.prepareStatement(sql);
					 // ?
					 pstmt.setInt(1, bkdto.getB_g_amount());
					 pstmt.setInt(2, bkdto.getB_g_num());
					 
					 // 4. sql 실행
					 pstmt.executeUpdate();
					 
					 } // for
					
					 System.out.println("DAO : 구매 후 상품 수량 변경 완료!");
					 
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeDB();
				}
				
			}
			
			//updateAmount(basketList);
			
}
