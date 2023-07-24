package model;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.FeFixBoothVO;

public class FeFixBoothDAO {

	private Connection conn = null;
	private String url = "jdbc:oracle:thin:@192.168.0.85:1521:ORCL";
	private String id = "pass";
	private String pw = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	PreparedStatement ps = null;
	ArrayList list = null;
	Statement st = null;
	ResultSet rs=null;

	public FeFixBoothDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pw);
	}

	public ArrayList noFixboothSearch(int sel, String text, int pk) throws Exception {

		// -------------------------------------------
		// 축제관리자가 등록한 부스 정보(확정 전*부스 리스트)

		String[] selCol = { "fest_name", "booth_name" };
		String sql = "select b.boothcode, f.fest_name, b.booth_name, g.boothct_name, b.booth_opentime, b.booth_closetime, m.mem_name, b.booth_resok "
				+ "from member m, festival f, booth b, boothcategory g "
				+ "where g.boothct_code = b.boothct_code "
				+ "and b.mem_code = m.mem_code "
				+ "and f.fest_code = b.fest_code "
				+ "and b.booth_resok = 'N' and f.mem_code = " + pk +" and "
				+ selCol[sel] + " like '%" + text + "%'";

		list = new ArrayList();
		st = conn.createStatement();

		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("boothcode"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("booth_name"));
			temp.add(rs.getString("boothct_name"));
			temp.add(rs.getInt("booth_opentime"));
			temp.add(rs.getInt("booth_closetime"));
			temp.add(rs.getString("mem_name"));
			temp.add(rs.getString("booth_resok"));
			list.add(temp);
		}
		rs.close();
		st.close();
		return list;

	}

	public void changeResOk(int bcode) throws Exception {		//확정버튼 누르면 부스예약이->Y로 업데이트
		String sql = "update booth set booth_resok='Y' where boothcode="+bcode;
		st = conn.createStatement();
		st.executeQuery(sql);
	
	}

	public ArrayList fixBoothSearch(int sel, String text, int pk) throws Exception {
		// 확정후 부스 검색
		String[] selCol = { "fest_name", "booth_name", "boothct_name", "booth_opentime", "booth_closetime" };
		String sql ="select b.boothcode, f.fest_name, b.booth_name, g.boothct_name, b.booth_opentime, b.booth_closetime, m.mem_name, b.booth_resok "
				+ "from member m, festival f, booth b, boothcategory g "
				+ "where g.boothct_code = b.boothct_code "
				+ "and b.mem_code = m.mem_code "
				+ "and f.fest_code = b.fest_code "
				+ "and b.booth_resok = 'Y' and f.mem_code = " + pk +" and "
				+ selCol[sel] + " like '%" + text + "%'";

		list = new ArrayList();
		st = conn.createStatement();

		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();

			temp.add(rs.getInt("boothcode"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("booth_name"));
			temp.add(rs.getString("boothct_name"));
			temp.add(rs.getInt("booth_opentime"));
			temp.add(rs.getInt("booth_closetime"));
			temp.add(rs.getString("mem_name"));
			temp.add(rs.getString("booth_resok"));
			list.add(temp);
		}
		rs.close();
		st.close();
		return list;
	}
	
	public ArrayList searchFe(int sel, String text, int pk) throws Exception {
		String[] selCol = {"fest_name", "fest_location", "fest_stdate", "fest_enddate"};
		String sql = "select fest_code, fest_name, fest_location, fest_stdate, fest_enddate from festival"
				+ " where mem_code = " + pk + " and " + selCol[sel] + " like '%" + text + "%'";
		list = new ArrayList();
		st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("fest_code"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("fest_location"));
			temp.add(rs.getString("fest_stdate"));
			temp.add(rs.getString("fest_enddate"));
			list.add(temp);
			
		}
		rs.close();
		st.close();
		return list;
	}
	
	//확정 전 리스트
	public ArrayList TotNoList(int pk) throws Exception{
		
		String sql ="select b.boothcode, f.fest_name, b.booth_name, g.boothct_name, b.booth_opentime, b.booth_closetime, m.mem_name, b.booth_resok "
				+ "from member m ,booth b, boothcategory g, festival f "
				+ "where g.boothct_code = b.boothct_code "
				+ "and b.mem_code = m.mem_code "
				+ "and f.fest_code = b.fest_code "
				+ "and b.booth_resok = 'N' and f.mem_code = " + pk;
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("boothcode"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("booth_name"));
			temp.add(rs.getString("boothct_name"));
			temp.add(rs.getInt("booth_opentime"));
			temp.add(rs.getInt("booth_closetime"));
			temp.add(rs.getString("mem_name"));
			temp.add(rs.getString("booth_resok"));
			list.add(temp);
			
		}
		
		rs.close();
		st.close();
		return list;
		
	}
	//확정 후 리스트
	public ArrayList TotYesList(int pk) throws Exception{
		
		String sql ="select b.boothcode, f.fest_name, b.booth_name, g.boothct_name, b.booth_opentime, b.booth_closetime, m.mem_name, b.booth_resok "
				+ "from member m ,booth b, boothcategory g, festival f "
				+ "where g.boothct_code = b.boothct_code "
				+ "and b.mem_code = m.mem_code "
				+ "and f.fest_code = b.fest_code "
				+ "and b.booth_resok = 'Y' and f.mem_code = " + pk;
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("boothcode"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("booth_name"));
			temp.add(rs.getString("boothct_name"));
			temp.add(rs.getInt("booth_opentime"));
			temp.add(rs.getInt("booth_closetime"));
			temp.add(rs.getString("mem_name"));
			temp.add(rs.getString("booth_resok"));
			list.add(temp);
			
		}
		
		rs.close();
		st.close();
		return list;
	}
	
	public ArrayList TotMyFeList(int pk) throws Exception {
		String sql = "select fest_code, fest_name, fest_location, fest_stdate, fest_enddate from festival"
				+ " where mem_code = " + pk;
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("fest_code"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("fest_location"));
			temp.add(rs.getString("fest_stdate"));
			temp.add(rs.getString("fest_enddate"));
			list.add(temp);
		}
		rs.close();
		st.close();
		return list;
	}
	//해당 축제에 대한 총 부스 개수
	public int bthCnt(int fcode) throws Exception {
		String sql = "select fest_maxbth from festival where fest_code = " + fcode;
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		int maxBth = 0;
		if(rs.next()) {
			maxBth = rs.getInt("fest_maxbth");
		}
		rs.close();
		return maxBth;
	}
	//해당 축제에 승인 대기중인 부스 개수
	public int addNoBthCnt(int fcode) throws Exception {
		String sql = "select count(fest_code) from booth where booth_resok = 'N' and fest_code = " + fcode;
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		int addNoBth = 0;
		if(rs.next()) {
			addNoBth = rs.getInt("count(fest_code)");
		}
		rs.close();
		return addNoBth;
	}
	//해당 축제에 승인된 부스 개수
	public int addYesBthCnt(int fcode) throws Exception {
		String sql = "select count(fest_code) from booth where booth_resok = 'Y' and fest_code = " + fcode;
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		int addYesBth = 0;
		if(rs.next()) {
			addYesBth = rs.getInt("count(fest_code)");
		}
		rs.close();
		return addYesBth;
	}
	
	//해당 축제에 남아있는 부스 자리
	public int balanceBthCnt(int fcode) throws Exception {
//		String sql = "select f.fest_maxbth - count(b.fest_code) \"bth_balance\" from festival f, booth b "
//				+ " where f.fest_code = b.fest_code and b.booth_resok = 'Y' and f.fest_code = " + fcode
//				+ " group by f.fest_maxbth, b.fest_code";
		String sql = "select f.fest_maxbth - count(b.fest_code) \"bth_balance\""
				+ " from festival f left join booth b on f.fest_code = b.fest_code and b.booth_resok = 'Y'"
				+ " where f.fest_code = " + fcode
				+ " group by f.fest_maxbth, b.fest_code";
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		int balanceBth = 0;
		if(rs.next()) {
			balanceBth = rs.getInt("bth_balance");
		}
		rs.close();
		return balanceBth;
	}
	
	
	//해당 축제에 신청한 부스 리스트
	public ArrayList FeNoList(int pk, int fcode) throws Exception{
		String sql = "select b.boothcode, f.fest_name, b.booth_name, g.boothct_name, b.booth_opentime, b.booth_closetime, m.mem_name, b.booth_resok"
				+ " from member m, booth b, boothcategory g, festival f"
				+ " where g.boothct_code = b.boothct_code and b.mem_code = m.mem_code"
				+ " and f.fest_code = b.fest_code"
				+ " and b.booth_resok = 'N' and b.fest_code = " + fcode;
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("boothcode"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("booth_name"));
			temp.add(rs.getString("boothct_name"));
			temp.add(rs.getInt("booth_opentime"));
			temp.add(rs.getInt("booth_closetime"));
			temp.add(rs.getString("mem_name"));
			temp.add(rs.getString("booth_resok"));
			list.add(temp);
		}
		rs.close();
		st.close();
		return list;
	}
	
	public ArrayList FeYesList(int pk, int fcode) throws Exception {
		String sql = "select b.boothcode, f.fest_name, b.booth_name, g.boothct_name, b.booth_opentime, b.booth_closetime, m.mem_name, b.booth_resok"
				+ " from member m, booth b, boothcategory g, festival f"
				+ " where g.boothct_code = b.boothct_code and b.mem_code = m.mem_code"
				+ " and f.fest_code = b.fest_code"
				+ " and b.booth_resok = 'Y' and b.fest_code = " + fcode;
		list = new ArrayList();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("boothcode"));
			temp.add(rs.getString("fest_name"));
			temp.add(rs.getString("booth_name"));
			temp.add(rs.getString("boothct_name"));
			temp.add(rs.getInt("booth_opentime"));
			temp.add(rs.getInt("booth_closetime"));
			temp.add(rs.getString("mem_name"));
			temp.add(rs.getString("booth_resok"));
			list.add(temp);
		}
		rs.close();
		st.close();
		return list;
	}
}
