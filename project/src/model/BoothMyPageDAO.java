package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.BoothMyPageVO;

public class BoothMyPageDAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.85:1521:orcl"; // ip:port:DB명
	private String id = "pass"; // DB user
	private String pwd = "pass"; // DB user password
	PreparedStatement ps = null;
	Statement stmt = null;
	ResultSet rs = null;
	BoothMyPageVO vo = null;
	ArrayList list = null;
	
	public BoothMyPageDAO() throws Exception{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pwd);
	}
	
	public ArrayList MyBthInfoList(int pk) throws Exception {
		String sql = "select c.mct_name, m.mem_name, m.mem_tel, m.mem_id, m.mem_pw, count(b.mem_code) \"내 부스개수\""
				+ " from membercategory c, member m, booth b"
				+ " where c.mct_code = m.mct_code and m.mem_code = b.mem_code"
				+ " and m.mem_code = " + pk
				+ " group by c.mct_name, m.mem_name, m.mem_tel, m.mem_id, m.mem_pw, b.mem_code";
		list = new ArrayList();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("mct_name"));
			temp.add(rs.getString("mem_name"));
			temp.add(rs.getString("mem_tel"));
			temp.add(rs.getString("mem_id"));
			temp.add(rs.getString("mem_pw"));
			temp.add(rs.getInt("내 부스개수"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public String checkPw(int pk) throws Exception{
		String memPw = null;
		String sql = "select mem_pw from member where mem_code =" + pk;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			memPw = rs.getString("mem_pw");
		}
		rs.close();
		return memPw;
	}
	
	public void ModMyPass(BoothMyPageVO vo, int pk) throws Exception {
		String sql = "update member set mem_pw = ? where mem_code = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getPw());
		ps.setInt(2, pk);
		
		ps.executeUpdate();
	}
}
