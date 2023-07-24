package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.BoothResVO;

public class BoothResDAO {
	private Connection conn = null;
	private String jdbc_url = "jdbc:oracle:thin:@192.168.0.85:1521:ORCL";
	private String db_id = "pass";
	private String db_pw = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	ArrayList list = null;
	BoothResVO vo;
 
	public BoothResDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
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

	// 신청 부스 인서트
	public void resBooth(BoothResVO vo) throws Exception {
		String sql = "insert into booth (BOOTHCODE,BOOTH_NAME,BOOTHCT_CODE,FEST_CODE,BOOTH_TEL,BOOTH_YN,BOOTH_OPENTIME,BOOTH_CLOSETIME,BOOTH_RESOK, MEM_CODE) values (seq_booth_boothcode.nextval, ?, ?, ?, ?, 'N', ?, ?, 'N', ?)";

		ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getBoothname());
		ps.setInt(2, vo.getBoothctcode());
		ps.setInt(3, vo.getFestcode());
		ps.setString(4, vo.getBoothtel());
		ps.setInt(5, vo.getBoothopen());
		ps.setInt(6, vo.getBoothclose());
		ps.setInt(7, vo.getMemcode());
		ps.executeUpdate();

		ps.close();

	}

	// 축제명으로 축제PK찾기
	public int returnFestPK(String name) throws Exception {
		int num = 0;
		String sql = "select fest_code from festival where fest_name='" + name + "'";

		st = conn.createStatement();
		rs = st.executeQuery(sql);

		if (rs.next()) {
			num = rs.getInt("fest_code");
		}
		
		st.close();
		return num;
	}
	
	//내 등록신청 부스들 리스트
	public ArrayList myResList(int pk,int fcode) throws Exception{
		list = new ArrayList();
		String sql = "select b.boothcode, f.FEST_NAME, b.BOOTH_NAME, g.BOOTHCT_NAME, b.BOOTH_OPENTIME, b.BOOTH_CLOSETIME, b.BOOTH_RESOK from booth b, festival f, boothcategory g where b.fest_code = f.fest_code and b.boothct_code = g.boothct_code and b.mem_code="+pk+" and f.fest_code ="+fcode;
		
		st = conn.createStatement();
		
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("boothcode"));
			temp.add(rs.getString("FEST_NAME"));
			temp.add(rs.getString("BOOTH_NAME"));
			temp.add(rs.getString("BOOTHCT_NAME"));
			temp.add(rs.getInt("BOOTH_OPENTIME"));
			temp.add(rs.getInt("BOOTH_CLOSETIME"));
			temp.add(rs.getString("BOOTH_RESOK"));
			
			list.add(temp);
		}
		
		rs.close();
		st.close();

		return list;
	}
	
	//축제명으로 데이터 찾기
	public BoothResVO findByFest(int num, int pk) throws Exception{
		
		String sql="select f.FEST_NAME, b.BOOTH_NAME, g.BOOTHCT_NAME, b.BOOTH_OPENTIME, b.BOOTH_CLOSETIME, b.BOOTH_TEL from booth b, festival f, boothcategory g where b.fest_code = f.fest_code and b.boothct_code = g.boothct_code and b.mem_code="+pk+" and b.boothcode ="+num;
		
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		
		vo = new BoothResVO();
		
		if(rs.next()) {
			vo.setFestname(rs.getString(1));
			vo.setBoothname(rs.getString(2));
			vo.setBoothctname(rs.getString(3));
			vo.setBoothopen(rs.getInt(4));
			vo.setBoothclose(rs.getInt(5));
			vo.setBoothtel(rs.getString(6));
			
		}
		rs.close();
		st.close();
		
		return vo;
	}
	
	//신청한 부스 수정
	public void updateResBooth(BoothResVO vo) throws Exception{
		String sql = "update booth set booth_name = ?, boothct_code = ?, booth_tel = ?, booth_opentime = ?, booth_closetime = ? where boothcode = ?";
		
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, vo.getBoothname());
		ps.setInt(2, vo.getBoothctcode());
		ps.setString(3, vo.getBoothtel());
		ps.setInt(4, vo.getBoothopen());
		ps.setInt(5, vo.getBoothclose());
		ps.setInt(6, vo.getBoothcode());
		
		ps.executeUpdate();
		
		rs.close();
		ps.close();
		
		
	}
	//부스 신청 취소
	public void resCancel(int vNum) throws Exception{
		
		String sql = "delete from booth where boothcode ="+vNum;
		
		st =conn.createStatement();
		
		st.executeQuery(sql);
		
	}

}
