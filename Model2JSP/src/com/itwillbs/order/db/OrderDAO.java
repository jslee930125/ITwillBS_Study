package com.itwillbs.order.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.admin.goods.db.GoodsDTO;
import com.itwillbs.basket.db.BasketDTO;

public class OrderDAO {
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
	
	// addOrder(ordto,basketList,goodsList)
	public void addOrder(OrderDTO ordto,List basketList,List goodsList){
		int o_num = 0; // 일련번호
		int trade_num = 0; //주문번호
		
		// 시스템 시간정보(객체)를 가져온다. 
		Calendar cal = Calendar.getInstance();
		// 포멧팅 객체
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		
		try {
			// 1.2. 디비연결
			con = getCon();
			// 3. sql 구문 o_num (일련번호)
			sql = "select max(o_num) from itwill_order";
			pstmt = con.prepareStatement(sql);
			
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			if(rs.next()){
				o_num = rs.getInt(1) + 1;
			}
			System.out.println(" DAO : 일련변호 : "+o_num);
			
			trade_num = o_num;
			System.out.println(" DAO : 주문번호 : "+trade_num);
			
			// 주문정보를 저장(구매 수량만큼 반복)
			for(int i=0;i<basketList.size();i++){
				BasketDTO bkdto = (BasketDTO) basketList.get(i);
				GoodsDTO gdto = (GoodsDTO) goodsList.get(i);
				
				// 3. sql 준비
				sql = "insert into itwill_order "
						+ "values(?,?,?,?,?,?,?,?,?,?,"
							   + "?,?,?,?,?,?,now(),?,now(),?)";
				pstmt = con.prepareStatement(sql);
				
				// ?
				pstmt.setInt(1, o_num); //일련번호
				pstmt.setString(2, sdf.format(cal.getTime())+"-"+trade_num); // 주문번호
				pstmt.setInt(3, bkdto.getB_g_num()); // 구매상품번호
				pstmt.setString(4, gdto.getName());
				pstmt.setInt(5, bkdto.getB_g_amount()); // 구매수량
				pstmt.setString(6, bkdto.getB_g_size()); // 구매옵션
				pstmt.setString(7, bkdto.getB_g_color()); // 구매옵션
				pstmt.setString(8, ordto.getO_m_id()); // 구매자
				
				pstmt.setString(9, ordto.getO_r_name());
				pstmt.setString(10, ordto.getO_r_addr1());
				pstmt.setString(11, ordto.getO_r_addr2());
				pstmt.setString(12, ordto.getO_r_phone());
				pstmt.setString(13, ordto.getO_r_msg());
				
				pstmt.setInt(14, gdto.getPrice() * bkdto.getB_g_amount()); // 해당 상품의 구매금액
				
				pstmt.setString(15, ordto.getO_trade_type());
				pstmt.setString(16, ordto.getO_trade_payer());
				
				pstmt.setString(17, ""); //운송장 번호 (추후 변경)
				pstmt.setInt(18, 0); // 주문상태
				
				// 4.sql 실행
				pstmt.executeUpdate();
				
				// 일련번호 1씩 증가
				o_num++;			
			}// for
			System.out.println(" DAO : 주문정보 저장완료! ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}
	// addOrder(ordto,basketList,goodsList)
	
	// getOrderList(id)
	public List getOrderList(String id){
		List orderList = new ArrayList();
		try {
			//1.2. 디비연결
			con = getCon();
			// 3. sql
			// o_trade_num,o_g_name,o_g_amount,o_g_size,o_g_color,
			// o_sum_money, o_trans_num,o_date,o_trade_type,o_status
			// => 특정 회원일때 , o_trade_num(그룹), o_trade_num(정렬,내림차순)
			sql ="select o_trade_num,o_g_name,o_g_amount,o_g_size,o_g_color,"
					+ "sum(o_sum_money) as o_sum_money, o_trans_num,o_date,o_trade_type,o_status "
					+ "from itwill_order "
					+ "where o_m_id=? "
					+ "group by o_trade_num "
					+ "order by o_trade_num desc";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터처리 
			while(rs.next()){
				OrderDTO ordto = new OrderDTO();
				ordto.setO_date(rs.getDate("o_date"));
				ordto.setO_g_amount(rs.getInt("o_g_amount"));
				ordto.setO_g_color(rs.getString("o_g_color"));
				ordto.setO_g_name(rs.getString("o_g_name"));
				ordto.setO_g_size(rs.getString("o_g_size"));
				ordto.setO_trade_num(rs.getString("o_trade_num"));
				ordto.setO_trans_num(rs.getString("o_trans_num"));
				ordto.setO_sum_money(rs.getInt("o_sum_money"));
				ordto.setO_status(rs.getInt("o_status"));
				ordto.setO_trade_type(rs.getString("o_trade_type"));
				
				orderList.add(ordto);
			} //while
			System.out.println(" DAO : 주문목록 정보(개인)를 저장 완료!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return orderList;		
	}
	// getOrderList(id)
	
	
	// getOrderDetailList(trade_num)
	public List getOrderDetailList(String trade_num){
		List orderDetailList = new ArrayList();
		
		try {
			// 1.2. 디비연결
			con = getCon();
			// 3. sql
			sql = "select * from itwill_order where o_trade_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, trade_num);
			
			// 4. sql 실행
			rs = pstmt.executeQuery();
			
			// 5. 데이터 처리 
			while(rs.next()){
				OrderDTO ordto = new OrderDTO();
				ordto.setO_date(rs.getDate("o_date"));
				ordto.setO_g_amount(rs.getInt("o_g_amount"));
				ordto.setO_g_color(rs.getString("o_g_color"));
				ordto.setO_g_name(rs.getString("o_g_name"));
				ordto.setO_g_size(rs.getString("o_g_size"));
				ordto.setO_trade_num(rs.getString("o_trade_num"));
				ordto.setO_trans_num(rs.getString("o_trans_num"));
				ordto.setO_sum_money(rs.getInt("o_sum_money"));
				ordto.setO_status(rs.getInt("o_status"));
				ordto.setO_trade_type(rs.getString("o_trade_type"));
				
				orderDetailList.add(ordto);
			} // while

			System.out.println(" DAO : 상세 주문 리스트 저장완료! ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}		
		return orderDetailList;
	}
	// getOrderDetailList(trade_num)
	
	
	
	
	
	
}
