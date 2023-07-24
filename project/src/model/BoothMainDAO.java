package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.BoothMainVO;

public class BoothMainDAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.85:1521:orcl";		//ip:port:DB명
	private String id = "pass";		//DB user
	private String pwd = "pass";		//DB user password
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	ArrayList list = null;
	
	public BoothMainDAO() throws Exception{
		connectDB();
	}
	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록
		 * 2. 연결 객체 얻어오기
		 */

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결 성공입니당");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("드라이버 못찾음");

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("드라이버 못찾음1");
		}
	}
	
	public String selectMemName(int pk) throws Exception {
		System.out.println(pk+"켈켈");
		
		String name=null;
		String sql = "select mem_name from member where mem_code = ?";
		ps= conn.prepareStatement(sql);	
		ps.setInt(1, pk);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			name = rs.getString("mem_name");
		}
		System.out.println(name);
		rs.close();
		ps.close();
		
		return name;
	}
}
