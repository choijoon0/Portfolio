package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MyBoothDAO {
	private Connection conn = null;
	private String jdbc_url = "jdbc:oracle:thin:@192.168.0.85:1521:ORCL";
	private String db_id = "pass";
	private String db_pw = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	ArrayList list=null;
	
	public MyBoothDAO() throws Exception{
		
		connectDB();
	}
	
	void connectDB() throws Exception {
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
	
	
	
	public ArrayList recentList() throws Exception{
		
		list = new ArrayList();
		String sql = "select f.fest_name, b.booth_name, b.booth_opentime, b.booth_closetime, b.booth_tel, b.booth_yn, b.booth_resok from festival f, booth b where f.fest_code = b.fest_code";
		
		st = conn.createStatement();
		
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString(1));
			temp.add(rs.getString(2));
			temp.add(rs.getInt(3));
			temp.add(rs.getInt(4));
			temp.add(rs.getString(5));
			temp.add(rs.getString(6));
			temp.add(rs.getString(7));
			
			list.add(temp);
		}
		rs.close();
		st.close();
		
		return list;
		
	}
	
}
