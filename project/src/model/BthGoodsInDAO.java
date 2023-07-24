package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BthGoodsInDAO {
	private Connection conn = null;
	private String url = "jdbc:oracle:thin:@192.168.0.85:1521:ORCL";
	private String id = "pass";
	private String pw = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	PreparedStatement ps = null;
	ArrayList list = null;
	Statement st = null;
	ResultSet rs = null;
	
	public BthGoodsInDAO() throws Exception {
		// TODO Auto-generated constructor stub
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pw);
	}
	
	//상품 리스트 출력
	public ArrayList goodsInList(int pk) throws Exception{
		String sql = "select j.jumun_code, b.booth_name, g.goods_name, i.buy_cnt,"
				+ " g.goods_jungprice, g.goods_oneprice, ((g.goods_jungprice * i.buy_cnt) - (g.goods_oneprice * i.buy_cnt)) \"순수익\""
				+ " from booth b, goods g, buyinfo i, jumun j"
				+ " where b.boothcode = g.boothcode and g.goods_code = i.goods_code and j.jumun_code = i.jumun_code"
				+ " and (b.mem_code = " + pk + ") order by j.jumun_code";
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("jumun_code"));
			temp.add(rs.getString("booth_name"));
			temp.add(rs.getString("goods_name"));
			temp.add(rs.getInt("buy_cnt"));
			temp.add(rs.getInt("goods_jungprice"));
			temp.add(rs.getInt("goods_oneprice"));
			temp.add(rs.getInt("순수익"));
			list.add(temp);
		}
		rs.close();
		st.close();
		return list;
	}
	
	//순수익 합계
	public int sumPrice(int pk) throws Exception{
		int sumPrice = 0;
		String sql = "select sum((g.goods_jungprice * i.buy_cnt) - (g.goods_oneprice * i.buy_cnt)) \"순수익 합계\""
				+ " from goods g, buyinfo i, booth b"
				+ " where b.boothcode = g.boothcode and g.goods_code = i.goods_code"
				+ " and (b.mem_code = " + pk + ")";
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		if(rs.next()) {
			sumPrice = rs.getInt("순수익 합계");
		}
		st.close();
		rs.close();
		return sumPrice;
	}
	
	//상품 검색
	public ArrayList searchInList(int sel, String text, int pk) throws Exception {
		String[] selCol = {"g.goods_name"};
		String sql = "select j.jumun_code, b.booth_name, g.goods_name, i.buy_cnt, g.goods_cnt,"
				+ " g.goods_jungprice, g.goods_oneprice, ((g.goods_jungprice * i.buy_cnt) - (g.goods_oneprice * i.buy_cnt)) \"순수익\""
				+ " from booth b, goods g, buyinfo i, jumun j"
				+ " where b.boothcode = g.boothcode and g.goods_code = i.goods_code and j.jumun_code = i.jumun_code"
				+ " and (b.mem_code = " + pk + ") and "+ selCol[sel] + " like '%" + text + "%'" 
				+ " order by j.jumun_code";
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("jumun_code"));
			temp.add(rs.getString("booth_name"));
			temp.add(rs.getString("goods_name"));
			temp.add(rs.getInt("buy_cnt"));
			temp.add(rs.getInt("goods_cnt"));
			temp.add(rs.getInt("goods_jungprice"));
			temp.add(rs.getInt("goods_oneprice"));
			temp.add(rs.getInt("순수익"));
			list.add(temp);
		}
		st.close();
		rs.close();
		return list;
	}
	
	//검색 상품 순수익 합계
	public int searchSum(int sel, String text, int pk) throws Exception {
		int searchSum = 0;
		String[] selCol = {"g.goods_name"};
		String sql = "select sum((g.goods_jungprice * i.buy_cnt)-(g.goods_oneprice * i.buy_cnt)) \"순수익 합계\""
				+ " from goods g, buyinfo i, booth b"
				+ " where b.boothcode = g.boothcode and g.goods_code = i.goods_code"
				+ " and " + selCol[sel] + " like '%" + text + "%'"
				+ " and (b.mem_code = " + pk + ")";
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		if(rs.next()) {
			searchSum = rs.getInt("순수익 합계");
		}
		rs.close();
		st.close();
		return searchSum;
	}
	
	//재고 리스트
	public ArrayList selectJaego(int pk) throws Exception {
		list = new ArrayList();
		String sql = "select b.booth_name, g.goods_code, g.goods_name, g.goods_cnt"
				+ " from booth b, goods g where b.boothcode = g.boothcode"
				+ " and b.mem_code =" + pk;
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("booth_name"));
			temp.add(rs.getInt("goods_code"));
			temp.add(rs.getString("goods_name"));
			temp.add(rs.getInt("goods_cnt"));
			list.add(temp);
		}
		rs.close();
		st.close();
		return list;
	}
	
	//재고 검색
	public ArrayList searchJaego(int sel, String text, int pk) throws Exception {
		list = new ArrayList();
		String[] selCol = {"g.goods_name"};
		String sql = "select b.booth_name, g.goods_code, g.goods_name, g.goods_cnt"
				+ " from booth b, goods g where b.boothcode = g.boothcode"
				+ " and " + selCol[sel] + " like '%" + text + "%'"
				+ " and b.mem_code =" + pk;
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("booth_name"));
			temp.add(rs.getInt("goods_code"));
			temp.add(rs.getString("goods_name"));
			temp.add(rs.getInt("goods_cnt"));
			list.add(temp);
		}
		rs.close();
		st.close();
		return list;
	}
}
