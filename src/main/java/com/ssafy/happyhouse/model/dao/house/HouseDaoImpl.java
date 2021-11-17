package com.ssafy.happyhouse.model.dao.house;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.util.DBUtil;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
//
//public class HouseDaoImpl implements HouseDao{
//
//	@Override
//	public List<HouseInfo> queryHouseData(String dong) {
//		
//		List<HouseInfo> list = new ArrayList<>();;
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = DBUtil.getInstance().getConnection();
//			String sql = "select AptName, dealAmount, area, dealYear from housedeal where dong = "
//					+ "\""+dong+"\"";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			System.out.println(sql);
//			while(rs.next()) {
//				String AptName = rs.getString("AptName");
//				String dealAmount = rs.getString("dealAmount");
//				String area = rs.getString("area");
//				String dealYear = rs.getString("dealYear");
//				
//				list.add(new HouseInfo(AptName, dealAmount, area, dealYear));
//			}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.getInstance().close(conn, pstmt, rs);
//		}
//		
//		return list;
//	}
//}
