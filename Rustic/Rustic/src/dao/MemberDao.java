package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import models.Member;
import util.Time;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao instance=new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	private Connection conn; //DB 연결 객체
	private PreparedStatement pstmt; //Query 작성 객체
	private ResultSet rs; //Query 결과 커서
	
	
	//매매인 로그인 확인
	public int findByUsernameAndPassword(String ownerid, String ownerpw) {
		
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select * from owner where ownerid = ? and ownerpw = ?");
			
		
			pstmt.setString(1, ownerid);
			pstmt.setString(2, ownerpw);
	
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				return 1; 
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return -1; 
	}
	
	//고객 로그인 확인
	public int findByUsernameAndPassword_Customer(String cusid, String cuspw) {
		
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select * from customer where CUSTID = ? and CUSTPW = ?");
			
			pstmt.setString(1, cusid);
			pstmt.setString(2, cuspw);
	
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				return 1; 
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return -1; 
	}
	
	
	
	
	public void insertmember(String id, String pw, String name, String tel, String jumin) throws Exception  {


		
		//String sql ="insert into owner(OWNERNUM,OWNERNAME,OWNERPHONE,OWNERID,OWNERPW,OWNERJUMIN)"
		//		+ " values(ownernumSeq.nextval, ?, ?, ?, ?, ?)";
		
		//System.out.println(name+tel+id+pw+jumin);
		conn = DBConnection.getConnection();
		
		pstmt = conn.prepareStatement("insert into owner(OWNERNUM,OWNERNAME,OWNERPHONE,OWNERID,OWNERPW,OWNERJUMIN)"
				+ " values(ownernumSeq.nextval, ?, ?, ?, ?, ?)");
		//create sequence ownernumSeq로 시퀀스 생성해줘야 위에처럼 사용가능
		//미완성된 부분에 값을 대입
		pstmt.setString(1, name); //첫번째 ?에 name을 넣겠다. 라는 뜻 
		pstmt.setString(2, tel);	//ps.setString(1, cust.getCusName()) 처럼 해도됨
		pstmt.setString(3, id);
		pstmt.setString(4, pw);
		pstmt.setString(5, jumin);

		//DB에 전송
		pstmt.executeUpdate();	
		pstmt.close();

	}
	
	
	public void insertmember_cus(String id, String pw, String name, String tel, String jumin) throws Exception  {

        conn = DBConnection.getConnection();
        
        pstmt = conn.prepareStatement("insert into customer(CUSTNUM,CUSTNAME,CUSTPHONE,CUSTID,CUSTPW,CUSTJUMINNUM)"
              + " values(custnumSeq.nextval, ?, ?, ?, ?, ?)");
        //create sequence ownernumSeq로 시퀀스 생성해줘야 위에처럼 사용가능
        //미완성된 부분에 값을 대입
        pstmt.setString(1, name); //첫번째 ?에 name을 넣겠다. 라는 뜻 
        pstmt.setString(2, tel);   //ps.setString(1, cust.getCusName()) 처럼 해도됨
        pstmt.setString(3, id);
        pstmt.setString(4, pw);
        pstmt.setString(5, jumin);
     
        //DB에 전송
        pstmt.executeUpdate();   
        pstmt.close();

     }
	
	
	public ArrayList find_info(String id, int gubun) {
		
		conn = DBConnection.getConnection();
		ArrayList  list	= new ArrayList();
		if( gubun==1) {
			try {
				pstmt = conn.prepareStatement("select custname, custphone from customer where CUSTID = ?");
				
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					list.add(rs.getString("custname"));
					list.add(rs.getString("custphone"));
				}		
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
		}
		if(gubun==2) {
			try {
				pstmt = conn.prepareStatement("select ownername, ownerphone from owner where ownerid = ?");
				
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					list.add(rs.getString("ownername"));
					list.add(rs.getString("ownerphone"));
				}		
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}

		return list; 
	}
	
	
	
	//오너의 폰번호 가져오기
	public String find_phone(String id) {
		
		conn = DBConnection.getConnection();
		String phone=null;
	
		try {
			pstmt = conn.prepareStatement("select ownerphone from owner where ownerid = ?");
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
			phone=rs.getString("ownerphone");

			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		


		return phone; 
	}
	
	public int find_custnum(String id) {
		
		conn = DBConnection.getConnection();
		int custnum = 0;
	
		try {
			pstmt = conn.prepareStatement("select custnum from customer where custid = ?");
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				custnum = rs.getInt("custnum");

			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		


		return custnum; 
	}	
	
	//부동 수정
	public void bumodify(String name, String addr, String detail, String room, String ft, String direc, String intro, String toilet, int bumenunum) throws Exception  {

        conn = DBConnection.getConnection();
        
        pstmt = conn.prepareStatement("UPDATE budongmenu SET BUMENUNAME=?,BUADDR=?,BUDETAILADRESS=?,BUROOMQUANTITY=?,BUSQUAREMESURE=?,BUAROUNDVIEW=?,BUMENUINTRODUCE=?, BUTOILETQUANTITY=? WHERE bumenunum=?");
        //create sequence ownernumSeq로 시퀀스 생성해줘야 위에처럼 사용가능
        //미완성된 부분에 값을 대입
        pstmt.setString(1, name); //첫번째 ?에 name을 넣겠다. 라는 뜻 
        pstmt.setString(2, addr);   //ps.setString(1, cust.getCusName()) 처럼 해도됨
        pstmt.setString(3, detail);
        pstmt.setString(4, room);
        pstmt.setString(5, ft);
        pstmt.setString(6, direc);
        pstmt.setString(7, intro);
        pstmt.setString(8, toilet);
        pstmt.setInt(9, bumenunum);
     
        //DB에 전송
        pstmt.executeUpdate();   
        pstmt.close();

     }
	
	//메뉴 수정
	public void menumodify(String name, String addr, String detail, String room, String ft, String direc, String intro, int menunum) throws Exception  {

        conn = DBConnection.getConnection();
        
        pstmt = conn.prepareStatement("UPDATE menu SET menuname=?,address=?,addressdetail=?,bangcount=?,squaremesure=?,sundirection=?,menuintroduce=? WHERE menunum = ?");
        //create sequence ownernumSeq로 시퀀스 생성해줘야 위에처럼 사용가능
        //미완성된 부분에 값을 대입
        pstmt.setString(1, name); //첫번째 ?에 name을 넣겠다. 라는 뜻 
        pstmt.setString(2, addr);   //ps.setString(1, cust.getCusName()) 처럼 해도됨
        pstmt.setString(3, detail);
        pstmt.setString(4, room);
        pstmt.setString(5, ft);
        pstmt.setString(6, direc);
        pstmt.setString(7, intro);
        pstmt.setInt(8, menunum);
        
     
        //DB에 전송
        pstmt.executeUpdate();   
        pstmt.close();

     }


	
	
	
}
