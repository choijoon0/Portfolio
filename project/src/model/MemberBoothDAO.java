package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberBoothDAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.85:1521:orcl";		//ip:port:DB명
	private String id = "pass";		//DB user
	private String pwd = "pass";		//DB user password
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	ArrayList list = null;
	
	public MemberBoothDAO() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pwd);
	}
	
	public ArrayList searchBooth(int fcode) throws Exception {

		list = new ArrayList();

		String sql = "select b.boothcode, b.booth_name, g.boothct_name, b.booth_opentime, b.booth_closetime, b.booth_tel from booth b, boothcategory g where b.boothct_code = g.boothct_code and b.fest_code="+fcode;

		st = conn.createStatement();

		rs = st.executeQuery(sql);

		while (rs.next()) {

			ArrayList temp = new ArrayList();

			temp.add(rs.getInt(1));
			temp.add(rs.getString(2));
			temp.add(rs.getString(3));
			temp.add(rs.getInt(4));
			temp.add(rs.getInt(5));
			temp.add(rs.getString(6));
			

			list.add(temp);

		}

		rs.close();
		st.close();

		return list;

	}
	//부스검색
	public ArrayList searchBtn(int sel, String text, int fcode) throws Exception {

		String[] selCol = { "b.booth_name", "g.boothct_name"};
		String sql = "select b.boothcode, b.booth_name, g.boothct_name, b.booth_opentime, b.booth_closetime, b.booth_tel from booth b, boothcategory g"
				+ " where " + selCol[sel] + " like '%" + text + "%'" + " and b.fest_code=" + fcode + " and b.boothct_code = g.boothct_code";
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt(1));
			temp.add(rs.getString(2));
			temp.add(rs.getString(3));
			temp.add(rs.getInt(4));
			temp.add(rs.getInt(5));
			temp.add(rs.getString(6));

			list.add(temp);
		}
		rs.close();
		st.close();

		return list;
	}
	
	//체험형 부스인지 판단
	public int checkActivity(int bcode) throws Exception{
		int num = 0;
		String sql = "select boothct_code from booth where boothcode ="+bcode;
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if(rs.next()) {
			num = rs.getInt("boothct_code");
		}
		rs.close();
		st.close();
		
		return num;
	}
	
	
}
