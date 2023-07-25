package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuDAO {
   
   private MenuDAO() {}
   private static MenuDAO instance=new MenuDAO();
   public static MenuDAO getInstance() {
      return instance;
   }
   
   private Connection conn; //DB 연결 객체
   private PreparedStatement pstmt; //Query 작성 객체
   private ResultSet rs; //Query 결과 커서

   
public void insertmenu(String menunanme, String address, String addressdetail, int bangcount, int squaremeasure, String menuintroduce, String sundirection, int ownernum) throws Exception  {

      conn = DBConnection.getConnection();
      
      pstmt = conn.prepareStatement("insert into menu(menunum, menuname ,address, addressdetail, bangcount, squaremesure, menuintroduce, sundirection, ownernum)"
            + " values(menunumSeq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)");

      //create sequence ownernumSeq로 시퀀스 생성해줘야 위에처럼 사용가능
      //미완성된 부분에 값을 대입
      pstmt.setString(1, menunanme); //첫번째 ?에 name을 넣겠다. 라는 뜻 
      pstmt.setString(2, address);   //ps.setString(1, cust.getCusName()) 처럼 해도됨
      pstmt.setString(3, addressdetail);
      pstmt.setInt(4, bangcount);
      pstmt.setInt(5, squaremeasure);
      pstmt.setString(6, menuintroduce);
      pstmt.setString(7, sundirection);
      pstmt.setInt(8, ownernum);

      //DB에 전송
      pstmt.executeUpdate();   
      pstmt.close();

   }


public void insert_bu_menu(String menunanme, String address, String addressdetail, int bangcount, int squaremeasure, String menuintroduce, String sundirection, int ownernum, int toicount) throws Exception  {

    conn = DBConnection.getConnection();
    
    pstmt = conn.prepareStatement("insert into budongmenu(BUMENUNUM, BUMENUNAME ,BUADDR, BUDETAILADRESS, BUROOMQUANTITY , BUSQUAREMESURE, BUMENUINTRODUCE, BUAROUNDVIEW, OWNERNUM, BUTOILETQUANTITY)"
          + " values(bumenunumSeq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    
    //create sequence ownernumSeq로 시퀀스 생성해줘야 위에처럼 사용가능
    //미완성된 부분에 값을 대입
    pstmt.setString(1, menunanme); //첫번째 ?에 name을 넣겠다. 라는 뜻 
    pstmt.setString(2, address);   //ps.setString(1, cust.getCusName()) 처럼 해도됨
    pstmt.setString(3, addressdetail);
    pstmt.setInt(4, bangcount);
    pstmt.setInt(5, squaremeasure);
    pstmt.setString(6, menuintroduce);
    pstmt.setString(7, sundirection);
    pstmt.setInt(8, ownernum);
    pstmt.setInt(9, toicount);
    
    //DB에 전송
    pstmt.executeUpdate();   
    pstmt.close();

 }



//폰 넘버를 통해서 오너넘버를 리턴
public String comenum(String phone) {
   
   conn = DBConnection.getConnection();
   
   String num=null;
   try {
      pstmt = conn.prepareStatement("select ownernum from owner where ownerphone = ?");
      
      pstmt.setString(1, phone);
      
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
          num = rs.getString("ownernum");
      }
   } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
   return num;
   
}

//메뉴 넘버를 통해서 나머지 값을 전부 리턴
public ArrayList select_All(int menuNum) {
	   
		conn = DBConnection.getConnection();
		ArrayList  list	= new ArrayList();
	
		try {
			pstmt = conn.prepareStatement("select MENUNAME, ADDRESS, ADDRESSDETAIL, BANGCOUNT, SQUAREMESURE, SUNDIRECTION, MENUINTRODUCE, OWNERNUM from menu where MENUNUM = ?");
			
			pstmt.setInt(1, menuNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list.add(rs.getString("MENUNAME"));
				list.add(rs.getString("ADDRESS"));
				list.add(rs.getString("ADDRESSDETAIL"));
				list.add(rs.getInt("BANGCOUNT"));
				list.add(rs.getInt("SQUAREMESURE"));
				list.add(rs.getString("SUNDIRECTION"));
				list.add(rs.getString("MENUINTRODUCE"));
				
				list.add(rs.getInt("OWNERNUM"));
				}		
			} 
		
		catch (SQLException e) {
			e.printStackTrace();
		} 
			
		return list;
	   
	}

//메뉴 넘버를 통해서 나머지 값을 전부 리턴
public ArrayList select(int numnum) {
	   
		conn = DBConnection.getConnection();
		ArrayList  list	= new ArrayList();
	
		try {
			pstmt = conn.prepareStatement("select BUMENUNAME, BUADDR, BUDETAILADRESS, BUROOMQUANTITY, BUSQUAREMESURE, BUAROUNDVIEW, BUMENUINTRODUCE, BUTOILETQUANTITY, OWNERNUM from BUDONGMENU where BUMENUNUM = ?");
			
			pstmt.setInt(1, numnum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list.add(rs.getString("BUMENUNAME"));
				list.add(rs.getString("BUADDR"));
				list.add(rs.getString("BUDETAILADRESS"));
				list.add(rs.getInt("BUROOMQUANTITY"));
				list.add(rs.getInt("BUSQUAREMESURE"));
				list.add(rs.getString("BUAROUNDVIEW"));
				list.add(rs.getString("BUMENUINTRODUCE"));
				list.add(rs.getString("BUTOILETQUANTITY"));
				list.add(rs.getInt("OWNERNUM"));
				}		
			} 
		
		catch (SQLException e) {
			e.printStackTrace();
		} 
			
		return list;
	   
	}

public ArrayList select_All2(int bumenunum) {
	   
	conn = DBConnection.getConnection();
	ArrayList  list	= new ArrayList();

	try {
		pstmt = conn.prepareStatement("select BUMENUNAME, BUADDR, BUDETAILADRESS, BUROOMQUANTITY, BUSQUAREMESURE, BUTOILETQUANTITY, BUMENUINTRODUCE, OWNERNUM from budongmenu where BUMENUNUM = ?");
		
		pstmt.setInt(1, bumenunum);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			list.add(rs.getString("BUMENUNAME"));
			list.add(rs.getString("BUADDR"));
			list.add(rs.getString("BUDETAILADRESS"));
			list.add(rs.getInt("BUROOMQUANTITY"));
			list.add(rs.getInt("BUSQUAREMESURE"));
			list.add(rs.getInt("BUTOILETQUANTITY"));
			list.add(rs.getString("BUMENUINTRODUCE"));
			list.add(rs.getInt("OWNERNUM"));
			}		
		} 
	
	catch (SQLException e) {
		e.printStackTrace();
	} 
		
	return list;
   
}



//오너 넘버를 통해서 이름과 전화번호 반환
public ArrayList select_owner(int ownernum) {
	   
	conn = DBConnection.getConnection();
	ArrayList  list	= new ArrayList();

	try {
		pstmt = conn.prepareStatement("select OWNERNAME, OWNERPHONE from owner where OWNERNUM = ?");
		
		pstmt.setInt(1, ownernum);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			list.add(rs.getString("OWNERNAME"));
			list.add(rs.getString("OWNERPHONE"));
			}		
		} 
	
	catch (SQLException e) {
		e.printStackTrace();
	} 
		
	return list;
   
}

//예약번호를 넣으면 해당하는 메뉴 넘버를 반환
public int getMenuNum(int renum) {
	   
	conn = DBConnection.getConnection();
	int mnum=0;

	try {
		pstmt = conn.prepareStatement("select menunum from RESERVATION where RESERVNUM = ?");
		
		pstmt.setInt(1, renum);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			mnum = rs.getInt("menunum");
			}		
		} 
	
	catch (SQLException e) {
		e.printStackTrace();
	} 
		
	return mnum;
   
}

//메뉴 리뷰 저장하는 DAO
public void insert_MenuReview(int renum, String reviewContent, int star) throws Exception  {

    conn = DBConnection.getConnection();
    
    pstmt = conn.prepareStatement("insert into shop_review(SREVIEWNUM, SREVIEWCONTENT ,SREVIEWGRADE, SREVIEWDATE, RESERVNUM)"
          + " values(reviewnumSeq.nextval, ?, ?, sysdate, ?)");
    
    
    pstmt.setString(1, reviewContent); 
    pstmt.setInt(2, star);   
    pstmt.setInt(3, renum);

    
    //DB에 전송
    pstmt.executeUpdate();   
    pstmt.close();

 }


   
}