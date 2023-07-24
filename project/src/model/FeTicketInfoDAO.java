package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.FeMyPageVO;

public class FeTicketInfoDAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.85:1521:orcl"; // ip:port:DB명
	private String id = "pass"; // DB user
	private String pwd = "pass"; // DB user password
	PreparedStatement ps = null;
	Statement stmt = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	ArrayList list = null;

	public FeTicketInfoDAO() throws Exception {
		// TODO Auto-generated constructor stub
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pwd);
	}
	
	//축제 리스트
	public ArrayList festList(int pk) throws Exception {
		list = new ArrayList();
		String sql = "select f.fest_code, f.fest_name, c.festct_name, f.fest_stdate, f.fest_enddate, f.fest_maxbth"
				+ " from festival f, festivalcategory c" + " where f.festct_code = c.festct_code"
				+ " and f.festct_code != 5 and f.mem_code = " + pk;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int num = 0;
			int festcode = rs.getInt("fest_code");
			String sql2 = "select count(fest_code) count from booth where fest_code = ?" 
					+ " and booth_resok = 'Y' group by fest_code";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, festcode);
			rs2 = ps.executeQuery();
			if(rs2.next()) {
				num = rs2.getInt("count");
			}
			
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("fest_code"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("festct_name"));
			temp.add(rs.getString("fest_stdate"));
			temp.add(rs.getString("fest_enddate"));
			temp.add(rs.getInt("fest_maxbth")-num);
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	//콘서트 리스트
	public ArrayList conList(int pk) throws Exception {
		list = new ArrayList();
		String sql = "select f.fest_code, f.fest_name, c.festct_name, f.fest_stdate, f.fest_enddate, f.fest_seatcnt"
				+ " from festival f, festivalcategory c" 
				+ " where f.festct_code = c.festct_code"
				+ " and f.festct_code = 5 and f.mem_code = " + pk;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int num = 0;
			int festcode = rs.getInt("fest_code");
			String sql2 = "select sum(res_seatcnt) count from reservation where fest_code = ?";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, festcode);
			rs2 = ps.executeQuery();
			if(rs2.next()) {
				num = rs2.getInt("count");
			}
			
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("fest_code"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("festct_name"));
			temp.add(rs.getString("fest_stdate"));
			temp.add(rs.getString("fest_enddate"));
			temp.add(rs.getInt("fest_seatcnt")-num);
			list.add(temp);
		}
		
		return list;
	}
}
