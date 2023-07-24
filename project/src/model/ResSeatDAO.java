package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.ResSeatVO;

public class ResSeatDAO {
	private Connection conn = null;
	private String jdbc_url = "jdbc:oracle:thin:@192.168.0.85:1521:ORCL";
	private String db_id = "pass";
	private String db_pw = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs =null;
	ResultSet rs2 = null;
	ResSeatVO vo;
	ArrayList list = null;
	
	public ResSeatDAO() throws Exception{
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

	public int concertRes(ResSeatVO vo) throws Exception{
		int resnum = 0;
		String sql = "select seq_reservation_res_code.nextval from dual";
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if(rs.next()) {
			resnum = rs.getInt(1);
		}
		
		String sql2 = "INSERT INTO RESERVATION (RES_CODE, RES_SEATCNT, RES_DATE, MEM_CODE, FEST_CODE, RES_CANCELOK, HOWPAY_CODE) VALUES(?, ?, sysdate, ?, ?, 'N', ?)";
		ps = conn.prepareStatement(sql2);
		ps.setInt(1, resnum);
		ps.setInt(2, vo.getSeatchoice());
		ps.setInt(3, vo.getMemcode());
		ps.setInt(4, vo.getFestcode());
		ps.setInt(5, vo.getPaycode());
		
		ps.executeUpdate();
		st.close();
		rs.close();
		ps.close();

		
		
		return resnum;
	}
	
	//이미 예약된 좌석 추출
	public ArrayList alreadySelectSeat(int festcode) throws Exception{
		ArrayList list = new ArrayList();
		String sql = "select l.rloc_loc from reslocation l, reservation r where l.res_code = r.res_code and r.fest_code="+festcode;
		
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("rloc_loc"));
			list.add(temp);
		}
		rs.close();
		st.close();
		
		
		return list;
	}
	
	public int leftSeat(int festcode) throws Exception{
		String sql="select fest_seatcnt from festival where fest_code ="+festcode;
		int num = 0;
		int tot = 0;
		
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		if(rs.next()) {
			
			tot = rs.getInt("fest_seatcnt");
			
			String sql2 = "select sum(res_seatcnt) from reservation where fest_code = ?";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, festcode);
			rs2 = ps.executeQuery();
			if(rs2.next()) {
				num = rs2.getInt(1);
			}
			
		}
		int result = tot-num;

		return result;
	}
	
	public int maxseat(int festcode) throws Exception {
		int max=0;
		String sql ="select fest_seatcnt from festival where fest_code = "+festcode;
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if(rs.next()) {
			max = rs.getInt(1);
		}
		return max;
		
	}


}
