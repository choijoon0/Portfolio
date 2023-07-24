package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import model.rec.FeSignupVO;

public class FeSignupDAO {

	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.85:1521:orcl";
	private String id = "pass";
	private String pass = "pass";
	PreparedStatement ps = null;
	Statement stmt = null;
	FeSignupVO vo = null;
	ArrayList list = null;
	Result rs = null;

	void connectDB() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pass);

	}

	public FeSignupDAO() throws Exception {

		connectDB();
	}

	public void FestivalInsert(FeSignupVO vo) throws Exception { // 축제 등록

		String sql = "insert into festival(fest_code,fest_name,fest_stdate,fest_enddate,fest_endtime, fest_price, fest_company,fest_sttime, fest_maxbth, fest_location, festct_code, mem_code,fest_content,FEST_DECATE, fest_seatcnt) "
				+ "values (seq_festival_fest_code.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getName());
		ps.setString(2, vo.getStartday());
		ps.setString(3, vo.getEndday());
		ps.setInt(4, vo.getEndtime());
		ps.setInt(5, vo.getPrice());
		ps.setString(6, vo.getCompany());
		ps.setInt(7, vo.getStarttime());
		ps.setInt(8, vo.getBoose());
		ps.setString(9, vo.getLoc());
		ps.setInt(10, vo.getCtcode());
		ps.setInt(11, vo.getMemcode());
		ps.setString(12, vo.getContent());
		ps.setString(13, vo.getFestdetail());
		ps.setInt(14, vo.getFestSeat());

		ps.executeUpdate();
		ps.close();

	}

	public int FestivalDelete(int vNum) throws Exception { // 축제 삭제

		String sql = "delete festival where fest_code=?";
		ps = conn.prepareStatement(sql);

		ps.setInt(1, vo.getFestcode());

		ps.executeUpdate();
		ps.close();

		return vNum;
	}

	public int FestModify(FeSignupVO vo) throws SQLException { // 축제 수정

		String sql = "update festival set fest_name=?, fest_stdate=?, fest_enddate=?, fest_endtime=?, fest_price=?, fest_company=?, fest_sttime=?, fest_maxbth=?, fest_location=?, festct_code=?, fest_content=?, FEST_DECATE = ?"
				+ " where fest_code=?";

		ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getName());
		ps.setString(2, vo.getStartday());
		ps.setString(3, vo.getEndday());
		ps.setInt(4, vo.getEndtime());
		ps.setInt(5, vo.getPrice());
		ps.setString(6, vo.getCompany());
		ps.setInt(7, vo.getStarttime());
		ps.setInt(8, vo.getBoose());
		ps.setString(9, vo.getLoc());
		ps.setInt(10, vo.getCtcode());
		ps.setString(11, vo.getContent());
		ps.setString(12, vo.getFestdetail());
		ps.setInt(13, vo.getFestcode());

		ps.executeUpdate();
		ps.close();

		return vo.getFestcode();
	}

	public ArrayList showJTable() throws Exception { // 리스트가 JTable에 보이게
		list = new ArrayList();

		String sql = "select f.fest_code, c.festct_code, f.FEST_DECATE,f.fest_name, f.fest_stdate, f.fest_enddate, f.fest_endtime, f.fest_price, f.fest_company, f.fest_sttime, f.fest_maxbth, f.fest_location, f.fest_content"
				+ " from festival f,member m,festivalcategory c where m.mem_code = f.mem_code and f.festct_code = c.festct_code order by f.fest_code";

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();

			temp.add(rs.getInt("fest_code"));
			temp.add(rs.getInt("festct_code"));
			temp.add(rs.getString("FEST_DECATE"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("fest_location"));
			temp.add(rs.getDate("fest_stdate"));
			temp.add(rs.getDate("fest_enddate"));
			temp.add(rs.getInt("fest_sttime"));
			temp.add(rs.getInt("fest_endtime"));
			temp.add(rs.getInt("fest_price"));
			temp.add(rs.getString("fest_company"));
			temp.add(rs.getInt("fest_maxbth"));
			temp.add(rs.getString("fest_content"));
			list.add(temp);

		}

		rs.close();
		stmt.close();

		return list;
	}

	public ArrayList selectTableList(int sel, String text) throws Exception { // 검색

		String[] selCol = { "fest_name", "fest_location", "fest_company" };
		String sql = "select festct_code, fest_code, FEST_DECATE,fest_name, fest_stdate, fest_enddate, fest_endtime, fest_price, fest_company, fest_sttime, fest_maxbth, fest_location, fest_content"
				+ " from festival where " + selCol[sel] + " like '%" + text + "%'";

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();

			temp.add(rs.getInt("festct_code"));
			temp.add(rs.getInt("fest_code"));
			temp.add(rs.getString("FEST_DECATE"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("fest_location"));
			temp.add(rs.getDate("fest_stdate"));
			temp.add(rs.getDate("fest_enddate"));
			temp.add(rs.getInt("fest_sttime"));
			
			temp.add(rs.getInt("fest_endtime"));
			temp.add(rs.getInt("fest_price"));
			temp.add(rs.getString("fest_company"));
			temp.add(rs.getInt("fest_maxbth"));
			temp.add(rs.getString("fest_content"));
			list.add(temp);

		}
		rs.close();
		stmt.close();
		return list;
	}

	private ArrayList ArrayList() {

		return null;
	}

	public FeSignupVO FindByNum(int vNum) throws Exception { // 축제 코드로 리스트 선택

		String sql = "select FEST_DECATE,festct_code,fest_code, fest_name, fest_stdate, fest_enddate, fest_endtime, fest_price, fest_company, fest_sttime, fest_maxbth, fest_location, fest_content"
				+ " from festival where fest_code =?";

		ps = conn.prepareStatement(sql);

		ps.setInt(1, vNum);

		ResultSet rs = ps.executeQuery();

		vo = new FeSignupVO();

		if (rs.next()) {
			vo.setFestdetail(rs.getString("FEST_DECATE"));
			vo.setCtcode(rs.getInt("festct_code"));
			vo.setFestcode(rs.getInt("fest_code"));
			vo.setName(rs.getString("fest_name"));
			vo.setLoc(rs.getString("fest_location"));
			vo.setStartday(rs.getString("fest_stdate"));
			vo.setEndday(rs.getString("fest_enddate"));
			vo.setStarttime(rs.getInt("fest_sttime"));
			vo.setEndtime(rs.getInt("fest_endtime"));
			vo.setPrice(rs.getInt("fest_price"));
			vo.setCompany(rs.getString("fest_company"));
			vo.setBoose(rs.getInt("fest_maxbth"));
			vo.setContent(rs.getString("fest_content"));

		}

		rs.close();
		ps.close();

		return vo;
	}

}
