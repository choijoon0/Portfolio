package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.AddGoodsVO;

public class AddGoodsDAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.85:1521:orcl"; // ip:port:DB명
	private String id = "pass"; // DB user
	private String pwd = "pass"; // DB user password
	PreparedStatement ps = null;
	Statement stmt = null;
	ResultSet rs = null;
	AddGoodsVO vo = null;
	ArrayList list = null;

	public AddGoodsDAO() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pwd);
	}

	//상품추가 
	public void AddGoods(AddGoodsVO vo, int goodsctCode) throws Exception {
		
		String sql = "insert into goods(goods_code, boothcode, goods_name, goods_jungprice, goods_oneprice, goods_cnt, gct_code, goods_img)"
				+ " values (seq_goods_goods_code.nextval, ?, ?, ?, ?, ?, ?, ?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, vo.getBoothCode());
		ps.setString(2, vo.getGoodsName());
		ps.setInt(3, vo.getJungPrice());
		ps.setInt(4, vo.getOnePrice());
		ps.setInt(5, vo.getGoodsCnt());
		ps.setInt(6, goodsctCode);
		ps.setString(7, vo.getGoodsImg());

		ps.executeUpdate();

		ps.close();

	}
	//상품 수정
	public void ModGoods(AddGoodsVO vo, int goodscode) throws Exception {
		String sql = "update goods set goods_name = ?, goods_jungprice = ?, goods_oneprice = ?, goods_cnt = ?"
				+ " where goods_code = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getGoodsName());
		ps.setInt(2, vo.getJungPrice());
		ps.setInt(3, vo.getOnePrice());
		ps.setInt(4, vo.getGoodsCnt());
		ps.setInt(5, goodscode);
		
		ps.executeUpdate();
		ps.close();
	}

	//상품카테고리번호 찾기
	public int gctCode(int gtCode, int gdCode) throws Exception {
		int goodsctCode = 0;

		String sql = "select gct_code from goodscategory where gt_code = ? and gd_code=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, gtCode);
		ps.setInt(2, gdCode);
		rs = ps.executeQuery();

		while (rs.next()) {
			goodsctCode = rs.getInt("gct_code");
		}

		return goodsctCode;
	}

	
	//상품리스트
	public ArrayList goodsList(int code) throws Exception {
		list = new ArrayList();
		String sql = "select g.goods_code, b.booth_name, g.goods_name, g.goods_jungprice, g.goods_oneprice, g.goods_cnt from booth b, goodscategory c, goods g"
				+ " where b.boothcode = g.boothcode and g.gct_code = c.gct_code and b.boothcode = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, code);
		rs = ps.executeQuery();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("goods_code"));
			temp.add(rs.getString("booth_name"));
			temp.add(rs.getString("goods_name"));
			temp.add(rs.getInt("goods_jungprice"));
			temp.add(rs.getInt("goods_oneprice"));
			temp.add(rs.getInt("goods_cnt"));
			list.add(temp);
		}
		rs.close();
		ps.close();
		return list;
	}

	public AddGoodsVO findByName(int gnum) throws Exception {
		String sql = "select t.gt_name, d.gd_name, b.booth_name ,g.goods_name, g.goods_jungprice, g.goods_oneprice, g.goods_cnt, g.goods_img"
				+ " from booth b, goodscategory c, goods g, goodstype t, goodsdetail d"
				+ " where b.boothcode = g.boothcode and g.gct_code = c.gct_code and c.gt_code = t.gt_code and c.gd_code = d.gd_code"
				+ " and g.goods_code = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, gnum);

		rs = ps.executeQuery();

		if (rs.next()) {
			vo = new AddGoodsVO();
			vo.setBoothName(rs.getString("booth_name"));
			vo.setGoodsName(rs.getString("goods_name"));
			vo.setJungPrice(rs.getInt("goods_jungprice"));
			vo.setOnePrice(rs.getInt("goods_oneprice"));
			vo.setGoodsCnt(rs.getInt("goods_cnt"));
			vo.setGoodsImg(rs.getString("goods_img"));
			vo.setGtName(rs.getString("gt_name"));
			vo.setGdName(rs.getString("gd_name"));
		}
		rs.close();
		return vo;
	}


	//부스코드로 부스이름 찾기
	public String selectBoothName(int num) throws Exception {
		String name = null;
		String sql = "select booth_name from booth where boothcode=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, num);
		rs = ps.executeQuery();
		if (rs.next()) {
			name = rs.getString("booth_name");
		}
		rs.close();
		ps.close();
		return name;
	}
	
	public String getImage(int goodscode) throws Exception{
		String url = null;
		String sql = "select goods_img from goods where goods_code = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, goodscode);
		rs = ps.executeQuery();
		if(rs.next()) {
			url = rs.getString(1);
		}
		rs.close();
		ps.close();
		
		
		return url;
	}
}
