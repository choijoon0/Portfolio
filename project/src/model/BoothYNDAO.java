package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class BoothYNDAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.85:1521:orcl";		//ip:port:DB명
	private String id = "pass";		//DB user
	private String pwd = "pass";		//DB user password
	PreparedStatement ps = null;
	Statement stmt = null;
	ResultSet rs = null;
	ArrayList list = null;
	
	public BoothYNDAO() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pwd);
	}
	
	//확정 안된 부스 리스트
	public ArrayList BthNoList(int pk) throws Exception {
		String sql = "select b.boothcode,f.fest_name, f.fest_location, f.fest_stdate, f.fest_enddate,"
				+ " b.booth_name, c.boothct_name, b.booth_resok"
				+ " from festival f, booth b, boothcategory c"
				+ " where f.fest_code = b.fest_code and b.boothct_code = c.boothct_code and b.booth_resok='N' and b.mem_code = "+pk;
		
		list = new ArrayList();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("boothcode"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("fest_location"));
			temp.add(rs.getString("fest_stdate"));
			temp.add(rs.getString("fest_enddate"));
			temp.add(rs.getString("booth_name"));
			temp.add(rs.getString("boothct_name"));
			temp.add(rs.getString("booth_resok"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	
	//확정된 부스 리스트
	public ArrayList BthYesList(int pk) throws Exception {
		String sql = "select b.boothcode,f.fest_name, f.fest_location, f.fest_stdate, f.fest_enddate,"
				+ " b.booth_name, c.boothct_name, b.booth_resok"
				+ " from festival f, booth b, boothcategory c"
				+ " where f.fest_code = b.fest_code and b.boothct_code = c.boothct_code and b.booth_resok='Y' and b.mem_code = "+pk;
		list = new ArrayList();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("boothcode"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("fest_location"));
			temp.add(rs.getString("fest_stdate"));
			temp.add(rs.getString("fest_enddate"));
			temp.add(rs.getString("booth_name"));
			temp.add(rs.getString("boothct_name"));
			temp.add(rs.getString("booth_resok"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	//부스 신청 취소
	public void resCancel(int vNum) throws Exception{
		
		String sql = "delete from booth where boothcode ="+vNum;
		
		stmt =conn.createStatement();
		
		stmt.executeQuery(sql);
		
	}
}
