package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FeAllListDAO {
	private Connection conn = null;
	private String url = "jdbc:oracle:thin:@192.168.0.85:1521:ORCL";
	private String id = "pass";
	private String pw = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	Statement st=null;
	ArrayList list = null;

	public FeAllListDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pw);
	}
	
	
	public ArrayList allfestSearch() throws Exception{
		
		//-------------------------------
		//전체리스트 출력
		String sql="select  fest_code,fest_name,fest_location,fest_stdate,fest_enddate,fest_sttime,fest_endtime,fest_company from festival";
		st=conn.createStatement();
		
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			
			temp.add(rs.getInt("fest_code"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("fest_location"));
			temp.add(rs.getString("fest_stdate"));
			temp.add(rs.getString("fest_enddate"));
			temp.add(rs.getString("fest_sttime"));
			temp.add(rs.getString("fest_endtime"));
			temp.add(rs.getString("fest_company"));
			list.add(temp);
		}
		rs.close();
		st.close();
		
		return list;
	}
	
	

	public ArrayList festSearch(int sel, String text) throws Exception {
		// ----------------------------
		// 축제 검색하기

		String[] selCol = { "fest_name", "fest_location", "fest_stdate", "fest_enddate", "fest_company" };
		String sql = "select fest_code,fest_name,fest_location,fest_stdate,fest_enddate,fest_sttime,fest_endtime,fest_company from festival where " + selCol[sel] + " like '%" + text + "%'";
		list = new ArrayList();
		st = conn.createStatement();
		
		ResultSet rs = st.executeQuery(sql);
 
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			
			temp.add(rs.getInt("fest_code"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("fest_location"));
			temp.add(rs.getString("fest_stdate"));
			temp.add(rs.getString("fest_enddate"));
			temp.add(rs.getString("fest_sttime"));
			temp.add(rs.getString("fest_endtime"));
			temp.add(rs.getString("fest_company"));
			list.add(temp);
		}
		rs.close();
		st.close();
		return list;
	}

}
