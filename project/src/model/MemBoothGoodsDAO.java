package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.MemBoothGoodsVO;

public class MemBoothGoodsDAO {
	private Connection conn = null;
	private String jdbc_url = "jdbc:oracle:thin:@192.168.0.85:1521:ORCL";
	private String db_id = "pass";
	private String db_pw = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs =null;
	ArrayList list = null;
	
	public MemBoothGoodsDAO() throws Exception{
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
	
	public ArrayList searchAllGoods(int bcode) throws Exception {

		list = new ArrayList();

		String sql = "select goods_code, goods_name, goods_jungprice, goods_cnt from goods where boothcode ="+bcode;

		st = conn.createStatement();

		rs = st.executeQuery(sql);

		while (rs.next()) {

			ArrayList temp = new ArrayList();

			temp.add(rs.getInt(1));
			temp.add(rs.getString(2));
			temp.add(rs.getInt(3));
			temp.add(rs.getInt(4));

			list.add(temp);

		}

		rs.close();
		st.close();

		return list;

	}
	
	//주문번호 우선 생성
	public void makeJumunCode() throws Exception {
		String sql = "insert into jumun (jumun_code, mem_code, jumun_date) values (seq_jumun_jumun_code.nextval,?,sysdate)";
		ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		
	}
	
	//부스코드로 부스명 추출
	public String boothName(int bcode) throws Exception {
		String sql ="select booth_name from booth where boothcode="+bcode;
		String name = null;
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if(rs.next()) {
			name = rs.getString("booth_name");
		}
		
		
		return name;
	}
	
	//주문하기위해 주문 코드만 만들고 추출해놓기
	public int createJumunCode() throws Exception{
		int num = 0;
		String sql = "select seq_jumun_jumun_code.nextval from dual";
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if(rs.next()) {
			num = rs.getInt(1);
		}
		
		String sql2 ="insert into jumun (jumun_code) values (?)";
		ps = conn.prepareStatement(sql2);
		ps.setInt(1, num);
		ps.executeUpdate();
		st.close();
		rs.close();
		ps.close();
		
		
		return num;
	}
	
	//상품주문
	public void inBuyInfo(MemBoothGoodsVO vo) throws Exception{
		String sql = "INSERT INTO PASS.BUYINFO (BUY_CODE, BUY_CNT, JUMUN_CODE, GOODS_CODE) VALUES(seq_buyinfo_buy_code.nextval, ?, ?, ?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, vo.getAmount());
		ps.setInt(2, vo.getJucode());
		ps.setInt(3, vo.getGoodscode());
		ps.executeUpdate();
		
		ps.close();
		
		
	}
	
	//이미지 가져오기
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
	
	//상품코드로 상품 재고
	public int getGoodsCnt(int goodscode) throws Exception{
		int num = 0;
		String sql ="select goods_cnt from goods where goods_code = "+goodscode;
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		if(rs.next()) {
			num = rs.getInt("goods_cnt");
		}
		rs.close();
		st.close();
		
		return num;
		
	}
	

}
