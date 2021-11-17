package com.ssafy.happyhouse.model.dao.interestRegion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.util.DBUtil;
import com.ssafy.happyhouse.model.dto.DongInfo;
//public class InterestRegionDaoImpl implements InterestRegionDao {
//	
//	private Connection conn;
//	private PreparedStatement pstmt;
//	
//	public InterestRegionDaoImpl() {
//		conn = null;
//		pstmt = null;
//		
//	}
//	
//	public void addInterestedRegion(String user_id, int dong_code) {
//		try {
//			conn = DBUtil.getInstance().getConnection();
//				conn.setAutoCommit(false);
//			String sql = "insert into interestRegion (user_id, dong_code) "
//			             + "values (?, ?)";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, user_id);
//			pstmt.setInt(2, dong_code);
//			
//			int cnt = pstmt.executeUpdate();
//			
//			System.out.println(cnt+"개 관심지역 추가 성공 !  ");
//			conn.commit();
//		
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		} finally {
//			DBUtil.getInstance().close(conn, pstmt);
//		}
//	}
//	
//	
//	public void deleteInterestedRegion(String user_id, int dong_code) {
//		
//		try {
//			conn = DBUtil.getInstance().getConnection();
//			conn.setAutoCommit(false);
//			String sql = "delete from interestRegion \n" ;
//			sql += "where user_id = ? and dong_code = ? ";
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, user_id);
//			pstmt.setInt(2, dong_code);
//			
//			// insert 완성. 실행할 차
//			int cnt = pstmt.executeUpdate();
//			System.out.println(cnt+ "개 삭제 성공 !!! ");
//			conn.commit();
//		
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		} finally {
//			DBUtil.getInstance().close(conn, pstmt);
//		}
//	}
//	
//	public List<DongInfo> searchInterestedRegion(String user_id) {
//		
//		List<DongInfo> list = new ArrayList<>();
//		ResultSet rs = null;
//		try {
//			conn = DBUtil.getInstance().getConnection();
//			conn.setAutoCommit(false);
//			
//			String sql = "select d.city, d.gugun, d.dong \n";
//			sql += "from dongInfo as d natural join (select dong_code from interestRegion where user_id = ?) as ir";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1,  user_id);
//			
//			rs = pstmt.executeQuery();
//			
//			// insert 완성. 실행할 차
//			while(rs.next()) {
//				String city = rs.getString("d.city");
//				String gugun = rs.getString("d.gugun");
//				String dong = rs.getString("d.dong");
//				
//				list.add(new DongInfo(city, gugun, dong));
//
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		} finally {
//			DBUtil.getInstance().close(conn, pstmt, rs);
//		}
//		
//		return list;
//	}
//	
//}
