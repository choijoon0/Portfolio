package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import model.rec.ReservationVO;

public class ReservationDAO {

	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.85:1521:orcl";
	private String id = "pass";
	private String pass = "pass";
	PreparedStatement ps = null;
	Statement stmt = null;
	ReservationVO vo = null;
	ArrayList list = null;
	ResultSet rs = null;
	ResultSet rs2 = null;

	void connectDB() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pass);

	}

	public ReservationDAO() throws Exception {

		connectDB();
	}	
	public ArrayList showFestivalList() throws Exception {		//축제 전체 리스트 출력
		list = new ArrayList();
		
		String sql="select fest_code, fest_name, fest_location, fest_stdate, fest_enddate, fest_price, fest_seatcnt from festival where festct_code =5";
		
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		
		while(rs.next()) {
			int num =0;
			int code = rs.getInt("fest_code");
			
			
			String sql2 = "select sum(res_seatcnt) from reservation where fest_code = ?";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, code);
			rs2 = ps.executeQuery();
			
			if(rs2.next()) {
				num = rs2.getInt(1);
			}
			
			
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("fest_code"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("fest_location"));
			temp.add(rs.getDate("fest_stdate"));
			temp.add(rs.getDate("fest_enddate"));
			temp.add(rs.getInt("fest_price"));
			temp.add(rs.getInt("fest_seatcnt")-num);
			list.add(temp);

		}
		
		rs.close();
		stmt.close();
		
		return list;
	}
	
	public ReservationVO selectFestivallist(int vNum) throws Exception {		// 축제 코드로 리스트 선택
		
		String sql = "select fest_code, festct_code, fest_name, fest_location, fest_stdate, fest_enddate, fest_company, fest_price, fest_seatcnt from festival where fest_code =?";
		
				
		ps = conn.prepareStatement(sql);
		
		
		ps.setInt(1, vNum);
		
		
		ResultSet rs = ps.executeQuery();
		
		vo = new ReservationVO();
		
		if(rs.next()) {
			vo.setFestcode(rs.getInt("fest_code"));
			vo.setCtcode(rs.getInt("festct_code"));
			vo.setFestname(rs.getString("fest_name"));
			vo.setLoc(rs.getString("fest_location"));
			vo.setStartday(rs.getString("fest_stdate"));
			vo.setEndday(rs.getString("fest_enddate"));
			vo.setPrice(rs.getInt("fest_price"));
			vo.setCompany(rs.getString("fest_company"));
			vo.setSeatcnt(rs.getInt("fest_seatcnt"));
			
		}
		
		rs.close();
		ps.close();
		
		return vo;
	}
	
	

	public ArrayList searchTableList(int sel, String text) throws Exception { // 목록에서 검색

		String[] selCol = { "fest_name", "fest_location"};
		String sql = "select fest_code, fest_name, fest_location, fest_stdate, fest_enddate,  fest_price, fest_seatcnt from festival where " + selCol[sel] + " like '%" + text + "%' and festct_code = 5";

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		list = new ArrayList();
		
		while (rs.next()) {
			
			int num =0;
			int code = rs.getInt("fest_code");
			
			
			String sql2 = "select sum(res_seatcnt) from reservation where fest_code = ?";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, code);
			rs2 = ps.executeQuery();
			
			if(rs2.next()) {
				num = rs2.getInt(1);
			}

			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("fest_code"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("fest_location"));
			temp.add(rs.getDate("fest_stdate"));
			temp.add(rs.getDate("fest_enddate"));
			temp.add(rs.getInt("fest_price"));
			temp.add(rs.getInt("fest_seatcnt")-num);
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

}
