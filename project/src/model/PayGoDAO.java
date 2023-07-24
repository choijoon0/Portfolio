package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.PayCardVO;
import model.rec.PayGoVO;

public class PayGoDAO {
	private Connection conn = null;
	private String jdbc_url = "jdbc:oracle:thin:@192.168.0.85:1521:ORCL";
	private String db_id = "pass";
	private String db_pw = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	ArrayList list = null;

	public PayGoDAO() throws Exception {
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

	public void ingopay(PayGoVO vo) throws Exception {
		String sql = "INSERT INTO GOPAY (GOPAY_CODE, GOPAY_NAME, GOPAY_BANK, GOPAY_ACCOUNT, JUMUN_CODE) VALUES (seq_gopay_gopay_code.nextval, ?, ?, ?, ?)";

		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getGoname());
		ps.setString(2, vo.getBankname());
		ps.setString(3, vo.getGonum());
		ps.setInt(4, vo.getJcode());

		ps.executeUpdate();

	}

	// 주문테이블 업뎃
	public void upjumun(PayGoVO vo) throws Exception {
		String sql = "select sum(buy_cnt) from buyinfo where jumun_code = " + vo.getJcode();
		int sum = 0;
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if (rs.next()) {
			sum = rs.getInt(1);
		}

		String sql2 = "update jumun set mem_code = ?, jumun_date = sysdate, jumun_cnt= ?, jumun_req = ? ,howpay_code = 2 where jumun_code = ?";
		ps = conn.prepareStatement(sql2);
		ps.setInt(1, vo.getMemcode());
		ps.setInt(2, sum);
		ps.setString(3, vo.getReq());
		ps.setInt(4, vo.getJcode());
		ps.executeUpdate();
		st.close();
		rs.close();
		ps.close();

	}
	public ArrayList buyTable(int jpk) throws Exception{
		ArrayList list = new ArrayList();
		String sql = "select g.goods_name, g.goods_jungprice, b.buy_cnt, g.goods_jungprice*b.buy_cnt from goods g, buyinfo b,jumun j where j.jumun_code = b.jumun_code and b.goods_code = g.goods_code and b.jumun_code = "+jpk;
		
		st = conn.createStatement();
		rs  = st.executeQuery(sql);
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString(1));
			temp.add(rs.getInt(2));
			temp.add(rs.getInt(3));
			temp.add(rs.getInt(4));
			list.add(temp);
		}
		rs.close();
		st.close();
		
		return list;
	}
}
