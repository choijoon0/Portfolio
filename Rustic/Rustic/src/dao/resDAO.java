package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class resDAO {
	
	
	private resDAO() {}
	private static resDAO instance = new resDAO();
	public static resDAO getInstance() {
		return instance;
		}
	
	
	   
	private Connection conn; //DB 연결 객체
	private PreparedStatement pstmt; //Query 작성 객체
	private ResultSet rs; //Query 결과 커서

	   
	   public void insertres(String reservpaymentmethod, int menunum, int custnum, String reservcheckin, String reservcheckout, String reservpeoplecnt, long reservstaylength) throws Exception {   
		      //(String reservdate, String reservpaymentmethod, int menunum, int reservcustnum, String reservcheckin, String reservcheckout, String reservpeoplecnt, String reservstaylength, String reservconfirmation)
		      conn = DBConnection.getConnection();
		      
		      pstmt = conn.prepareStatement("insert into reservation(RESERVNUM, RESERVDATE, RESERVPAYMENTMETHOD, RESERVCUSTNUM, RESERVCHECKIN, RESREVCHECKOUT, MENUNUM, RESERVPEOPLECNT, RESERVSTAYLENGTH) "
		            + "values(resnumSeq.nextval, sysdate, ?, ?, ?, ?, ?, ?, ?)");
		      //RESERVNUM, RESERVDATE, RESERVPAYMENTMETHOD, RESERVCUSTNUM, RESERVCHECKIN, RESREVCHECKOUT, MENUNUM, RESERVPEOPLECNT, RESERVSTAYLENGTH, RESERVCONFIRMATION
		      

		      pstmt.setString(1, reservpaymentmethod);
		      pstmt.setInt(2, custnum);
		      pstmt.setString(3, reservcheckin);
		      pstmt.setString(4, reservcheckout);
		      pstmt.setInt(5, menunum);
		      pstmt.setString(6, reservpeoplecnt);
		      pstmt.setLong(7, reservstaylength);
		     
		      
		      pstmt.executeUpdate();
		      pstmt.close();
		   }

	   //예약넘버를 받아서 체크인,체크아웃 리턴
	   public ArrayList getCheck(int renum) {
		   
			conn = DBConnection.getConnection();
			ArrayList  list	= new ArrayList();

			try {
				pstmt = conn.prepareStatement("select RESERVCHECKIN, RESREVCHECKOUT from RESERVATION where RESERVNUM = ?");
				
				pstmt.setInt(1, renum);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					list.add(rs.getString("RESERVCHECKIN"));
					list.add(rs.getString("RESREVCHECKOUT"));
					}		
				} 
			
			catch (SQLException e) {
				e.printStackTrace();
			} 
				
			return list;
		   
		}


	
}
