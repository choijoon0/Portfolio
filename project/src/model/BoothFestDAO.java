package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BoothFestDAO {
	private Connection conn = null;
	private String jdbc_url = "jdbc:oracle:thin:@192.168.0.85:1521:ORCL";
	private String db_id = "pass";
	private String db_pw = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs =null;
	ResultSet rs2 = null;
	ArrayList list = null;
	
	public BoothFestDAO() throws Exception{
		connectDB();
	}
	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록
		 * 2. 연결 객체 얻어오기
		 */

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(jdbc_url, db_id, db_pw);
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("드라이버 못찾음");

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("드라이버 못찾음1");
		}
	}
	//전체 축제 리스트 뽑
	public ArrayList searchFest() throws Exception {

		list = new ArrayList();
		
		String sql = "select fest_code, fest_name, fest_stdate, fest_enddate, fest_company, fest_maxbth, fest_location from festival";
		
		st = conn.createStatement();
		
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int num = 0;
			int code = rs.getInt(1);
		
			String sql2 = "select count(booth_resok) a from booth where booth_resok='Y' and fest_code = ?";
			ps  = conn.prepareStatement(sql2);
			ps.setInt(1, code);
			
			rs2= ps.executeQuery();
			if(rs2.next()) {
				num = rs2.getInt("a");
			}
			
			
			
			ArrayList temp = new ArrayList();
			
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("fest_stdate"));
			temp.add(rs.getString("fest_enddate"));
			temp.add(rs.getString("fest_company"));
			temp.add(rs.getInt("fest_maxbth")-num);
			temp.add(rs.getString("fest_location"));
			
			list.add(temp);
			
		}
		
		rs.close();
		st.close();
		
		return list;
		
	}
	
	//검색한 축제 뽑
	public ArrayList searchBtn(int sel, String text) throws Exception {
		String[] selCol = {"fest_name", "fest_location", "fest_stdate", "fest_enddate", "fest_company"};
		String sql = "select fest_code, fest_name, fest_stdate, fest_enddate, fest_company, fest_maxbth, fest_location from festival"
					+ " where " + selCol[sel] + " like '%" + text + "%'";
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);

		
		while(rs.next()) {
			int num = 0;
			int code = rs.getInt(1);
		
			String sql2 = "select count(booth_resok) a from booth where booth_resok='Y' and fest_code = ?";
			ps  = conn.prepareStatement(sql2);
			ps.setInt(1, code);
			
			rs2= ps.executeQuery();
			if(rs2.next()) {
				num = rs2.getInt("a");
			}
			
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("fest_stdate"));
			temp.add(rs.getString("fest_enddate"));
			temp.add(rs.getString("fest_company"));
			temp.add(rs.getInt("fest_maxbth")-num);
			temp.add(rs.getString("fest_location"));
		
			list.add(temp);
		}
		rs.close();
		st.close();
		
		
		return list;
	}
	
}
