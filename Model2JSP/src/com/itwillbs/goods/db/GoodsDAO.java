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

	// 자원 해제
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
	// 자원해제
	
	
	// getGoodsList()
	public List<GoodsDTO> getGoodsList(){
		List<GoodsDTO> goodsList = new ArrayList<GoodsDTO>();
		try {
			// 1.2. 디비연결
			con = getCon();
			// 3. sql
			sql = "select * from itwill_goods";
			pstmt = con.prepareStatement(sql);
			
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
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return goodsList;
	}
	// getGoodsList()
	
	
	// String -> 메서드를 통한 실행정보 저장 X => 바로 사용, 기존값 변경 X
	// StringBuffer -> 메서드를 통한 실행정보는 저장 O => 기존값 변경 O
	
	// getGoodsList(item)
	public List<GoodsDTO> getGoodsList(String item){
		List<GoodsDTO> goodsList = new ArrayList<GoodsDTO>();
		StringBuffer SQL = new StringBuffer();
		
		try {
			// 1.2. 디비연결
			con = getCon();
			// 3. sql (item값에 따른 구문변경)
			//sql = "select * from itwill_goods";
			SQL.append("select * from itwill_goods ");
			if(item.equals("ALL")){	}
			else if(item.equals("best")){
				//sql = "select * from itwill_goods wherer best=?";
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
				// select * from itwill_goods wherer best=1
			}else{// 카테고리
				pstmt.setString(1, item);
				// select * from itwill_goods wherer category=?
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
		
	// getGoods(num)
	public GoodsDTO getGoods(int num){
		GoodsDTO gdto = null;
		try {
			// 1.2. 디비연결
			con = getCon();
			// 3. sql
			sql = "select * from itwill_goods where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			// 4. sql 실행
			rs = pstmt.executeQuery();
			
			// 5. 데이터 처리
			if(rs.next()){
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
			}	// if
			
			System.out.println(" DAO : "+num+"번 상품정보 저장완료");
			System.out.println(" DAO : "+gdto);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return gdto;
	}
	// getGoods(num)
	
	
	// updateAmount(basketList)
	public void updateAmount(List basketList){
		// 판매된 상품들의 수량을 제거
		try {
			// 1.2. 디비연결
			con = getCon();
			
			for(int i=0;i<basketList.size();i++){
				BasketDTO bkdto = (BasketDTO)basketList.get(i);
				// 3. sql (기존의 수량 - 판매수량)
				sql ="update itwill_goods set amount = amount - ? where num=?";
				pstmt = con.prepareStatement(sql);
				
				//?
				pstmt.setInt(1, bkdto.getB_g_amount());
				pstmt.setInt(2, bkdto.getB_g_num());
				
				// 4. 실행
				pstmt.executeUpdate();
			
			} // for
			
			System.out.println(" DAO : 구매후 상품 수량 변경완료! ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	// updateAmount(basketList)
	
	
	
	
	

}
