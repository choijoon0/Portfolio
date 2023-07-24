package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.rec.LoginVO;
import view.SignUpView;

public class LoginDAO {
	private Connection conn = null;
	private String jdbc_url = "jdbc:oracle:thin:@192.168.0.85:1521:ORCL";
	private String db_id = "pass";
	private String db_pw = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	SignUpView my;

	public LoginDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
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

	// 회원코드 비교해서 로그인
	public int login(String id, String pw, int ctnum) throws Exception {

		String sql = "select * from member where mem_id = ? and mem_pw = ? and MCT_CODE = ?";

		ps = conn.prepareStatement(sql);

		ps.setString(1, id);
		ps.setString(2, pw);
		ps.setInt(3, ctnum);

		rs = ps.executeQuery();

		if (rs.next()) {
			return 1;
		}

		ps.close();

		return -1;
	}

	// id,pw로 회원코드찾아 담기
	public int searchMemberPk(LoginVO vo) throws Exception {
		int pk = 0;

		String sql = "select mem_code from member where mem_id = ? and mem_pw = ?";

		ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPw());

		rs = ps.executeQuery();

		if (rs.next()) {
			pk = rs.getInt("mem_code");
		}

		return pk;
	}

}
