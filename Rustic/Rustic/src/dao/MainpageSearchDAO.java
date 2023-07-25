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
	private PreparedStatement pstmt; //Query �ۼ� ��ü
	private ResultSet rs; //Query ��� Ŀ��

	
	public MainpageSearchDAO() throws Exception{
	      try{

		         Class.forName(driver);
		         conn = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
		         //System.out.println("���������� ��ġ DB����");    
		         stmt = conn.createStatement();
		         
		         
		  }
	      catch(ClassNotFoundException e){
		         System.out.println("�ش� ����̹��� ã�� �� �����ϴ�.");
		  }
		  catch(SQLException se){
		         System.out.println("SQL ����� �߸�����ϴ�.");
		  }
	}
	

	
	//���� ���� ����Ʈ
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
	
	//���� ����
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
	
	
	
	//���ڸ���Ʈ
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
	
	//�ε��긮��Ʈ
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
	
	
	//custid�� custnum ã��
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
	
	//ownerid�� ownernum ã��
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
	
	//custnum ���� reservnumã��
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
	
	
	//���ฮ��Ʈ
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
	
	//���� �ε��� ����Ʈ
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
	
	//���� ���� ����Ʈ
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
	
	
	//Ȯ������Ʈ
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
	
	//���丮��Ʈ
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
		
	
	

	//���հ˻�
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
	
	 
	 //�ε��� �˻�
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
	
	
	 
	 

	 //���ڰ˻�
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
	
	// Ȯ�� �޼ҵ�
		public void reservcheck(String reservnum) throws Exception
		{

			
			
			String sql = "update RESERVATION set RESERVCONFIRMATION = 'Y' WHERE RESERVNUM = ?";
			//4. ���۰�ü ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reservnum);
			
			//5. ����
			pstmt.executeUpdate();
			
			//6. �ݱ�
			pstmt.close();
			
		}
	 
		// ��� �޼ҵ�
		public void reservnotcheck(String reservnum) throws Exception
		{

					
					
			String sql = "update RESERVATION set RESERVCONFIRMATION = 'N' WHERE RESERVNUM = ?";
			//4. ���۰�ü ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reservnum);
			
			//5. ����
			pstmt.executeUpdate();
			
			//6. �ݱ�
			pstmt.close();
					
		}
			 
	
}
