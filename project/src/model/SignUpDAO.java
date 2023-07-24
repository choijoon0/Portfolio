package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpDAO {
	private Connection conn = null;
	private String jdbc_url = "jdbc:oracle:thin:@192.168.0.85:1521:ORCL";
	private String db_id = "pass";
	private String db_pw = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs =null;
	
	public SignUpDAO() throws Exception{
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
	
	
	public void signUp(String name, String tel, String jumin, String id, String pw, int memcode) throws Exception {
		String sql = "insert into member (MEM_CODE, MEM_NAME, MEM_TEL, MEM_JUNUM, MEM_ID, MEM_PW, MCT_CODE, MEM_ORDERCNT) values (seq_member_mem_code.nextval, ?, ?, ?, ?, ?, ?, 0)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, tel);
		ps.setString(3, jumin);
		ps.setString(4, id);
		ps.setString(5, pw);
		ps.setInt(6, memcode);
		
		ps.executeUpdate();
		ps.close();
		
		
	}
	
	
	
	
	
	
}
