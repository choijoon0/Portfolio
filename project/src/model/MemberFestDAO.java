package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberFestDAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.85:1521:orcl"; // ip:port:DB명
	private String id = "pass"; // DB user
	private String pwd = "pass"; // DB user password
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	ArrayList list = null;

	public MemberFestDAO() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pwd);
	}

	public ArrayList searchFest() throws Exception {

		list = new ArrayList();

		String sql = "select fest_code, fest_name, fest_location, fest_price, fest_content,FEST_ENDDATE from festival";

		st = conn.createStatement();

		rs = st.executeQuery(sql);

		while (rs.next()) {

			ArrayList temp = new ArrayList();

			temp.add(rs.getInt(1));
			temp.add(rs.getString(2));
			temp.add(rs.getString(3));
			temp.add(rs.getInt(4));
			temp.add(rs.getString(5));
			temp.add(rs.getString(6));

			list.add(temp);

		}

		rs.close();
		st.close();

		return list;

	}

	public ArrayList searchBtn(int sel, String text) throws Exception {

		String[] selCol = { "fest_name", "fest_location", "fest_enddate", "fest_price" };
		String sql = "select fest_code, fest_name, fest_location, fest_price, fest_content,FEST_ENDDATE from festival"
				+ " where " + selCol[sel] + " like '%" + text + "%'";
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt(1));
			temp.add(rs.getString(2));
			temp.add(rs.getString(3));
			temp.add(rs.getInt(4));
			temp.add(rs.getString(5));
			temp.add(rs.getString(6));

			list.add(temp);
		}
		rs.close();
		st.close();

		return list;
	}
	
	public ArrayList searchPrBtn(int sel, String text) throws Exception {
		String[] selCol = {"fest_name", "fest_location", "fest_enddate", "fest_price"};
		String sql = "select fest_code, fest_name, fest_location, fest_price, fest_content, fest_endtime from festival"
				+ " where " + selCol[sel] + " <= " + text + "order by fest_price desc";
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt(1));
			temp.add(rs.getString(2));
			temp.add(rs.getString(3));
			temp.add(rs.getInt(4));
			temp.add(rs.getString(5));
			temp.add(rs.getString(6));

			list.add(temp);
		}
		rs.close();
		st.close();
		return list;
	}
}
