package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberJumunInfoDAO {
	private Connection conn = null;
	private String url = "jdbc:oracle:thin:@192.168.0.85:1521:ORCL";
	private String id = "pass";
	private String pw = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	PreparedStatement ps = null;
	ArrayList list = null;
	Statement st = null;
	ResultSet rs = null;
	
	public MemberJumunInfoDAO() throws Exception{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pw);
	}
	
	//리스트출력
	public ArrayList myJumunList(int pk) throws Exception{
		String sql = "select distinct m.mem_name, j.jumun_code, g.goods_name, j.jumun_cnt, (g.goods_jungprice*j.jumun_cnt) \"주문금액\", j.jumun_date, h.howpay_name"
				+ " from member m, jumun j, goods g, howpay h, buyinfo b"
				+ " where m.mem_code = j.mem_code and j.jumun_code = b.jumun_code and b.goods_code = g.goods_code and j.howpay_code = h.howpay_code"
				+ " and m.mem_code = " + pk + " order by j.jumun_code";
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("mem_name"));
			temp.add(rs.getInt("jumun_code"));
			temp.add(rs.getString("goods_name"));
			temp.add(rs.getInt("jumun_cnt"));
			temp.add(rs.getInt("주문금액"));
			temp.add(rs.getString("jumun_date"));
			temp.add(rs.getString("howpay_name"));
			list.add(temp);
		}
		rs.close();
		st.close();
		return list;
	}
	
	//검색
	public ArrayList myJumunSearch(int sel, String text, int pk) throws Exception{
		String[] selCol = {"g.goods_name", "j.jumun_date", "h.howpay_name", "주문금액"};
		String sql = "select distinct m.mem_name, j.jumun_code, g.goods_name, j.jumun_cnt, (g.goods_jungprice*j.jumun_cnt) \"주문금액\", j.jumun_date, h.howpay_name"
				+ " from member m, jumun j, goods g, howpay h, buyinfo b"
				+ " where m.mem_code = j.mem_code and j.jumun_code = b.jumun_code and b.goods_code = g.goods_code and j.howpay_code = h.howpay_code"
				+ " and m.mem_code = " + pk + " and " + selCol[sel] + " like '%" + text + "%' order by j.jumun_code";
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("mem_name"));
			temp.add(rs.getInt("jumun_code"));
			temp.add(rs.getString("goods_name"));
			temp.add(rs.getInt("jumun_cnt"));
			temp.add(rs.getInt("주문금액"));
			temp.add(rs.getString("jumun_date"));
			temp.add(rs.getString("howpay_name"));
			list.add(temp);
		}
		rs.close();
		st.close();
		return list;
	}
	
	public ArrayList jumunSearchPr(int sel, String text, int pk) throws Exception {
		String[] selCol = {"g.goods_name", "j.jumun_date", "h.howpay_name", "g.goods_jungprice*j.jumun_cnt"};
		String sql = "select distinct m.mem_name, j.jumun_code, g.goods_name, j.jumun_cnt, (g.goods_jungprice*j.jumun_cnt) \"주문금액\", j.jumun_date, h.howpay_name"
				+ " from member m, jumun j, goods g, howpay h, buyinfo b"
				+ " where m.mem_code = j.mem_code and j.jumun_code = b.jumun_code and b.goods_code = g.goods_code and j.howpay_code = h.howpay_code"
				+ " and m.mem_code = " + pk + " and " + selCol[sel] + " <= " + text + " order by 5 desc";
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("mem_name"));
			temp.add(rs.getInt("jumun_code"));
			temp.add(rs.getString("goods_name"));
			temp.add(rs.getInt("jumun_cnt"));
			temp.add(rs.getInt("주문금액"));
			temp.add(rs.getString("jumun_date"));
			temp.add(rs.getString("howpay_name"));
			list.add(temp);
		}
		rs.close();
		st.close();
		return list;
	}
}
