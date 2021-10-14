package com.itwillbs.admin.order.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.order.db.OrderDTO;

public class AdminOrderDAO {
	
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
			
			//getAdminOrderList();
			public List getAdminOrderList(){
				
				List adminOrderList = new ArrayList();
				
				try {
					// 1.2. 디비연결
					con = getCon();
					// 3.sql
					sql = "select o_trade_num,o_g_name,o_g_amount,o_g_size,o_g_color,sum(o_sum_money) as o_sum_money, "
							+ "o_trans_num,o_date,o_trade_type,o_status,o_m_id "
							+ "from itwill_order "
							+ "group by o_trade_num "
							+ "order by o_trade_num desc";
					pstmt = con.prepareStatement(sql);
					
					// 4. sql 실행
					rs = pstmt.executeQuery();
					
					// 5. 데이터처리
					while(rs.next()) {
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
						ordto.setO_m_id(rs.getString("o_m_id"));
						ordto.setO_trade_type(rs.getString("o_trade_type"));
						
						adminOrderList.add(ordto);
						
					}//while
					
					System.out.println("DAO : 관리자 - 주문 전체목록 저장");
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeDB();
				}
				return adminOrderList;
			}
			// getAdminOrderList();
			
			// getAdminOrderDetailList(trade_num);
			public List getAdminOrderDetailList(String trade_num){
				
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
					
					// 5. 데이터처리
					while(rs.next()) {
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
						
						ordto.setO_r_name(rs.getString("o_r_name"));
						ordto.setO_r_phone(rs.getString("o_r_phone"));
						ordto.setO_r_addr1(rs.getString("o_r_addr1"));
						ordto.setO_r_addr2(rs.getString("o_r_addr2"));
						ordto.setO_r_msg(rs.getString("o_r_msg"));
						
						orderDetailList.add(ordto);
						
					}//while
					
					System.out.println("DAO : 관리자 - 상세 주문 리스트 저장 완료");
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeDB();
				}
				return orderDetailList;
				
			} // getAdminOrderDetailList(trade_num);
			
			// updateOrder(ordto);
			public void updateOrder(OrderDTO ordto){
				
				try {
					// 1.2. 디비연결
					con = getCon();
					// 3.sql
					sql = "update itwill_order set o_trans_num=?,o_status=? where o_trade_num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, ordto.getO_trans_num());
					pstmt.setInt(2, ordto.getO_status());
					pstmt.setString(3, ordto.getO_trade_num());
					
					// 4. sql 실행
					pstmt.executeUpdate();
					
					System.out.println("DAO : 관리자 - 주문상태, 운송장번호 수정 완료!");
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeDB();
				}
			}			
			// updateOrder(ordto);
}