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
   
   private Connection conn; //DB ���� ��ü
   private PreparedStatement pstmt; //Query �ۼ� ��ü
   private ResultSet rs; //Query ��� Ŀ��

   
public void insertmenu(String menunanme, String address, String addressdetail, int bangcount, int squaremeasure, String menuintroduce, String sundirection, int ownernum) throws Exception  {

      conn = DBConnection.getConnection();
      
      pstmt = conn.prepareStatement("insert into menu(menunum, menuname ,address, addressdetail, bangcount, squaremesure, menuintroduce, sundirection, ownernum)"
            + " values(menunumSeq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)");

      //create sequence ownernumSeq�� ������ ��������� ����ó�� ��밡��
      //�̿ϼ��� �κп� ���� ����
      pstmt.setString(1, menunanme); //ù��° ?�� name�� �ְڴ�. ��� �� 
      pstmt.setString(2, address);   //ps.setString(1, cust.getCusName()) ó�� �ص���
      pstmt.setString(3, addressdetail);
      pstmt.setInt(4, bangcount);
      pstmt.setInt(5, squaremeasure);
      pstmt.setString(6, menuintroduce);
      pstmt.setString(7, sundirection);
      pstmt.setInt(8, ownernum);

      //DB�� ����
      pstmt.executeUpdate();   
      pstmt.close();

   }


public void insert_bu_menu(String menunanme, String address, String addressdetail, int bangcount, int squaremeasure, String menuintroduce, String sundirection, int ownernum, int toicount) throws Exception  {

    conn = DBConnection.getConnection();
    
    pstmt = conn.prepareStatement("insert into budongmenu(BUMENUNUM, BUMENUNAME ,BUADDR, BUDETAILADRESS, BUROOMQUANTITY , BUSQUAREMESURE, BUMENUINTRODUCE, BUAROUNDVIEW, OWNERNUM, BUTOILETQUANTITY)"
          + " values(bumenunumSeq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    
    //create sequence ownernumSeq�� ������ ��������� ����ó�� ��밡��
    //�̿ϼ��� �κп� ���� ����
    pstmt.setString(1, menunanme); //ù��° ?�� name�� �ְڴ�. ��� �� 
    pstmt.setString(2, address);   //ps.setString(1, cust.getCusName()) ó�� �ص���
    pstmt.setString(3, addressdetail);
    pstmt.setInt(4, bangcount);
    pstmt.setInt(5, squaremeasure);
    pstmt.setString(6, menuintroduce);
    pstmt.setString(7, sundirection);
    pstmt.setInt(8, ownernum);
    pstmt.setInt(9, toicount);
    
    //DB�� ����
    pstmt.executeUpdate();   
    pstmt.close();

 }



//�� �ѹ��� ���ؼ� ���ʳѹ��� ����
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

//�޴� �ѹ��� ���ؼ� ������ ���� ���� ����
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

//�޴� �ѹ��� ���ؼ� ������ ���� ���� ����
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



//���� �ѹ��� ���ؼ� �̸��� ��ȭ��ȣ ��ȯ
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

//�����ȣ�� ������ �ش��ϴ� �޴� �ѹ��� ��ȯ
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

//�޴� ���� �����ϴ� DAO
public void insert_MenuReview(int renum, String reviewContent, int star) throws Exception  {

    conn = DBConnection.getConnection();
    
    pstmt = conn.prepareStatement("insert into shop_review(SREVIEWNUM, SREVIEWCONTENT ,SREVIEWGRADE, SREVIEWDATE, RESERVNUM)"
          + " values(reviewnumSeq.nextval, ?, ?, sysdate, ?)");
    
    
    pstmt.setString(1, reviewContent); 
    pstmt.setInt(2, star);   
    pstmt.setInt(3, renum);

    
    //DB�� ����
    pstmt.executeUpdate();   
    pstmt.close();

 }


   
}