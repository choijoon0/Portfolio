package dao;

import java.sql.*;
import java.util.ArrayList;


public class MainpageSearchDAO {

	
	private Statement stmt = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String jdbc_url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private String db_id ="rustic";
	private String db_pwd="pass";
	
	private Connection conn;
	private PreparedStatement pstmt; //Query 작성 객체
	private ResultSet rs; //Query 결과 커서

	
	public MainpageSearchDAO() throws Exception{
	      try{

		         Class.forName(driver);
		         conn = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
		         //System.out.println("메인페이지 서치 DB연결");    
		         stmt = conn.createStatement();
		         
		         
		  }
	      catch(ClassNotFoundException e){
		         System.out.println("해당 드라이버를 찾을 수 없습니다.");
		  }
		  catch(SQLException se){
		         System.out.println("SQL 명령이 잘못됬습니다.");
		  }
	}
	

	
	//오너 메인 리스트
	public ArrayList totalListowner() throws Exception
	{
		
		
		ArrayList list = new ArrayList();

		String sql ="select BUMENUNUM, BUMENUNAME, BUADDR, BUDETAILADRESS from BUDONGMENU";
		Statement ps = conn.createStatement();
		ResultSet rs = ps.executeQuery(sql);

		while(rs.next()) {

			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("BUMENUNUM"));
			temp.add(rs.getString("BUMENUNAME"));
			temp.add(rs.getString("BUADDR"));
			temp.add(rs.getString("BUDETAILADRESS"));

	
			list.add(temp);
		}

		rs.close();
		ps.close();
		
		

		return list;
	}
	
	//메인 통합
	public ArrayList total() throws Exception
	{
		
		
		ArrayList list = new ArrayList();

		String sql ="select menunum, menuname, address, addressdetail from menu UNION select bumenunum, bumenuname, buaddr, budetailadress from budongmenu";
		Statement ps = conn.createStatement();
		ResultSet rs = ps.executeQuery(sql);

		while(rs.next()) {

			ArrayList  temp	= new ArrayList();
			temp.add(rs.getString("menunum"));
			temp.add(rs.getString("menuname"));
			temp.add(rs.getString("address"));
			temp.add(rs.getString("addressdetail"));
		

			//System.out.println(rs.getString("ownerphone"));
			list.add(temp);
		}
	
		rs.close();
		ps.close();
		
		

		return list;
	}
	
	
	
	//숙박리스트
	public ArrayList totalList() throws Exception
	{
		
		
		ArrayList list = new ArrayList();

		String sql ="select MENUNUM, MENUNAME, ADDRESS, ADDRESSDETAIL from menu";
		Statement ps = conn.createStatement();
		ResultSet rs = ps.executeQuery(sql);

		while(rs.next()) {

			ArrayList  temp	= new ArrayList();
			temp.add(rs.getInt("MENUNUM"));
			temp.add(rs.getString("MENUNAME"));
			temp.add(rs.getString("ADDRESS"));
			temp.add(rs.getString("ADDRESSDETAIL"));

			//System.out.println(rs.getString("ownerphone"));
			list.add(temp);
		}

		rs.close();
		ps.close();
		
		

		return list;
	}
	
	//부동산리스트
	public ArrayList totalList2() throws Exception
	{
		
		
		ArrayList list = new ArrayList();

		String sql ="select BUMENUNUM, BUMENUNAME, BUADDR, BUDETAILADRESS from BUDONGMENU";
		Statement ps = conn.createStatement();
		ResultSet rs = ps.executeQuery(sql);

		while(rs.next()) {

			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("BUMENUNUM"));
			temp.add(rs.getString("BUMENUNAME"));
			temp.add(rs.getString("BUADDR"));
			temp.add(rs.getString("BUDETAILADRESS"));

	
			list.add(temp);
		}

		rs.close();
		ps.close();
		
		

		return list;
	}
	
	
	//custid로 custnum 찾기
	public int checknunm(String custid) {

		int custnum = 0;
	
		try {
			pstmt = conn.prepareStatement("select CUSTNUM from customer where CUSTID = ?");
			
			pstmt.setString(1, custid);
			
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				custnum = rs.getInt("CUSTNUM");

			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		


		return custnum; 
	}	
	
	//ownerid로 ownernum 찾기
	public int checkownernunm(String ownerid) {

		int ownernum = 0;
	
		try {
			pstmt = conn.prepareStatement("select OWNERNUM from OWNER where OWNERID = ?");
			
			pstmt.setString(1, ownerid);
			
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				ownernum = rs.getInt("OWNERNUM");

			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		


		return ownernum; 
	}	
	
	//custnum 으로 reservnum찾기
	public int gaboja(int custnum) {

		int num  = 0;
	
		try {
			pstmt = conn.prepareStatement("select reservnum from reservation where reservcustnum = ?");
			
			pstmt.setInt(1, custnum);
			
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				num = rs.getInt("reservnum");

			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		


		return num; 
	}	
	
	
	//예약리스트
	public ArrayList MypageList(int custnum) throws Exception
	{
		ArrayList list = new ArrayList();

		pstmt = conn.prepareStatement("select RESERVNUM, RESERVDATE, RESERVCONFIRMATION, RESERVCHECKIN, RESREVCHECKOUT from RESERVATION where reservcustnum = ?");
		
	
		pstmt.setInt(1, custnum);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {

			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("RESERVNUM"));
			temp.add(rs.getString("RESERVDATE"));
			temp.add(rs.getString("RESERVCONFIRMATION"));
			temp.add(rs.getString("RESERVCHECKIN"));
			temp.add(rs.getString("RESREVCHECKOUT"));

			list.add(temp);
		}

		rs.close();
		pstmt.close();
		
		

		return list;
	}
	
	//오너 부동산 리스트
	public ArrayList bububu(int ownernum) throws Exception
	{
		ArrayList list = new ArrayList();

		pstmt = conn.prepareStatement("select BUMENUNUM, BUMENUNAME, BUADDR, BUDETAILADRESS from BUDONGMENU where ownernum = ?");
		
	
		pstmt.setInt(1, ownernum);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {

			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("BUMENUNUM"));
			temp.add(rs.getString("BUMENUNAME"));
			temp.add(rs.getString("BUADDR"));
			temp.add(rs.getString("BUDETAILADRESS"));
			

			list.add(temp);
		}

		rs.close();
		pstmt.close();
		
		

		return list;
	}
	
	//오너 숙박 리스트
		public ArrayList memenu(int ownernum) throws Exception
		{
			ArrayList list = new ArrayList();

			pstmt = conn.prepareStatement("select menunum, menuname, address, ADDRESSDETAIL from menu where ownernum = ?");
			
		
			pstmt.setInt(1, ownernum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("menunum"));
				temp.add(rs.getString("menuname"));
				temp.add(rs.getString("address"));
				temp.add(rs.getString("ADDRESSDETAIL"));

				list.add(temp);
			}

			rs.close();
			pstmt.close();
			
			

			return list;
		}
	
	
	//확정리스트
	public ArrayList MypageList2(int custnum) throws Exception
	{
		ArrayList list = new ArrayList();

		pstmt = conn.prepareStatement("select RESERVNUM, RESERVDATE, RESERVPAYMENTMETHOD, RESERVCHECKIN, RESREVCHECKOUT from RESERVATION where reservcustnum = ? and RESERVCONFIRMATION = 'Y'");
		
	
		pstmt.setInt(1, custnum);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {

			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("RESERVNUM"));
			temp.add(rs.getString("RESERVDATE"));
			temp.add(rs.getString("RESERVPAYMENTMETHOD"));
			temp.add(rs.getString("RESERVCHECKIN"));
			temp.add(rs.getString("RESREVCHECKOUT"));

			list.add(temp);
		}

		rs.close();
		pstmt.close();
		
		

		return list;
	}
	
	//리뷰리스트
		public ArrayList reviewlist(int custnum) throws Exception
		{
			ArrayList list = new ArrayList();

			pstmt = conn.prepareStatement("select SREVIEWCONTENT, SREVIEWGRADE, SREVIEWDATE from SHOP_REVIEW where RESERVNUM = ?");
			
		
			pstmt.setInt(1, custnum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				ArrayList temp = new ArrayList();
				temp.add(rs.getString("SREVIEWCONTENT"));
				temp.add(rs.getString("SREVIEWGRADE"));
				temp.add(rs.getString("SREVIEWDATE"));

				list.add(temp);
			}

			rs.close();
			pstmt.close();
			
			

			return list;
		}
		
	
	

	//통합검색
	 public ArrayList totsearch( int sel, String text ) throws Exception
     {
 
        
        String[] selCol = { "MENUNAME" , "ADDRESS" , "ADDRESSDETAIL" };
        String sql = "select MENUNUM, MENUNAME, ADDRESS, ADDRESSDETAIL from MENU "
                 + "where " + selCol[sel] + " like '%" + text + "%'";
        
        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery(sql);
        ArrayList  list   = new ArrayList();
        
        while(rs.next()) {
           ArrayList temp  = new ArrayList();
            temp.add(rs.getInt("MENUNUM"));
            temp.add(rs.getString("MENUNAME"));  
            temp.add(rs.getString("ADDRESS"));
            temp.add(rs.getString("ADDRESSDETAIL"));

           
            list.add(temp);
        }
        
        
        ps.close();
        rs.close();
        return list;
     }
	
	 
	 //부동산 검색
	 public ArrayList busearch( int sel, String text ) throws Exception
     {

        String[] selCol = { "BUMENUNAME" , "BUADDR" , "BUDETAILADRESS" };
        String sql = "select BUMENUNUM, BUMENUNAME, BUADDR, BUDETAILADRESS from BUDONGMENU "
                 + "where " + selCol[sel] + " like '%" + text + "%'";
        
        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery(sql);
        ArrayList  list   = new ArrayList();
        
        while(rs.next()) {
           ArrayList temp  = new ArrayList();
            temp.add(rs.getInt("BUMENUNUM"));
            temp.add(rs.getString("BUMENUNAME"));  
            temp.add(rs.getString("BUADDR"));
            temp.add(rs.getString("BUDETAILADRESS"));

           
            list.add(temp);
        }
        
        
        ps.close();
        rs.close();
        return list;
     }
	
	
	 
	 

	 //숙박검색
	 public ArrayList rmsearch( int sel, String text ) throws Exception
     {

        String[] selCol = { "MENUNAME", "ADDRESS", "ADDRESSDETAIL" };
        String sql = "select MENUNUM, MENUNAME, ADDRESS, ADDRESSDETAIL from MENU "
                 + "where " + selCol[sel] + " like '%" + text + "%'";
        
        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery(sql);
        ArrayList  list   = new ArrayList();
        
        while(rs.next()) {
           ArrayList temp  = new ArrayList();
            temp.add(rs.getInt("MENUNUM"));
            temp.add(rs.getString("MENUNAME"));  
            temp.add(rs.getString("ADDRESS"));
            temp.add(rs.getString("ADDRESSDETAIL"));

           
            list.add(temp);
        }
        
        
        ps.close();
        rs.close();
        return list;
     }
	
	// 확정 메소드
		public void reservcheck(String reservnum) throws Exception
		{

			
			
			String sql = "update RESERVATION set RESERVCONFIRMATION = 'Y' WHERE RESERVNUM = ?";
			//4. 전송객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reservnum);
			
			//5. 전송
			pstmt.executeUpdate();
			
			//6. 닫기
			pstmt.close();
			
		}
	 
		// 취소 메소드
		public void reservnotcheck(String reservnum) throws Exception
		{

					
					
			String sql = "update RESERVATION set RESERVCONFIRMATION = 'N' WHERE RESERVNUM = ?";
			//4. 전송객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reservnum);
			
			//5. 전송
			pstmt.executeUpdate();
			
			//6. 닫기
			pstmt.close();
					
		}
			 
	
}
