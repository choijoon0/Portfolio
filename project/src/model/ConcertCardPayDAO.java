package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.ConcertCardPayVO;

public class ConcertCardPayDAO {
	private Connection conn = null;
	private String jdbc_url = "jdbc:oracle:thin:@192.168.0.85:1521:ORCL";
	private String db_id = "pass";
	private String db_pw = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	PreparedStatement ps = null;
	Statement stmt = null;
	ResultSet rs =null;
	
	ArrayList list = null;
	
	public ConcertCardPayDAO() throws Exception{
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
	
	public void inResLocation(ArrayList list, int resnum) throws Exception{
		
		for(int i = 0; i < list.size() ; i++) {
			String sql = "INSERT INTO RESLOCATION (RLOC_CODE, RLOC_LOC, RES_CODE) VALUES (seq_reslocation_rloc_code.nextval, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, (String) list.get(i));
			ps.setInt(2, resnum);
			ps.executeUpdate();
		}
		
		ps.close();
		
	}
	
	public void resCardIn(ConcertCardPayVO vo) throws Exception{
		
		String sql = "INSERT INTO RESCARD (RCARD_CODE, RCARD_NAME, RCARD_NUM, RCARD_CVC, RCARD_EXPIRE, RES_CODE) VALUES (seq_rescard_rcard_code.nextval, ?, ?, ?, ?, ?)";
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, vo.getBank());
		ps.setString(2, vo.getCardnum());
		ps.setInt(3, vo.getCvc());
		ps.setString(4, vo.getYuhyo());
		ps.setInt(5, vo.getResnum());
		
		ps.executeQuery();
		
		ps.close();
	}
	
}
