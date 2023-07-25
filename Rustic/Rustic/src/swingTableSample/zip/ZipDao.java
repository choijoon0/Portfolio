package swingTableSample.zip;

import java.sql.*;

import java.util.ArrayList;

public class ZipDao {
	Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
   
   
    // �����ͺ��̽� ����
    public void connection() {
    	try {
                  Class.forName("oracle.jdbc.driver.OracleDriver");
                  conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "rustic", "pass");
         	} catch (ClassNotFoundException e) {
         		
            } catch (SQLException e) {
            	
            }
    }
   
    // �����ͺ��̽� ��������
    public void disconnection() {
    	try {
    		if(pstmt != null) pstmt.close();
                      
    		if(rs != null) rs.close();
                      
    		if(conn != null) conn.close();
             
    	} catch (SQLException e) {
    		
    	}
    }

    // �õ�������=============================================
    public ArrayList<ZipDto> searchSido() {
             ArrayList<ZipDto> sidoList = new ArrayList<ZipDto>();
             try {
                      String query = "select distinct(sido) from zipcode order by sido";
                      pstmt = conn.prepareStatement(query);
                      rs = pstmt.executeQuery();
                      while(rs.next()){
                              ZipDto zipcode = new ZipDto();
                              zipcode.setSido(rs.getString("SIDO"));
                              sidoList.add(zipcode);
                      }
             } catch (SQLException e) {
             }

             return sidoList;
    }
   
    // ����������=============================================
    public ArrayList<ZipDto> searchGugun(String sido) {
             ArrayList<ZipDto> gugunList = new ArrayList<>();
            
             try {
                      String query = "select distinct(gugun) from zipcode where sido = \'" + sido + "\' order by gugun";
                      pstmt = conn.prepareStatement(query);
                      rs = pstmt.executeQuery();
                      while(rs.next()){
                              ZipDto zipcode = new ZipDto();
                              zipcode.setGugun(rs.getString("GUGUN"));
                              gugunList.add(zipcode);
                      }
             } catch (SQLException e) {
             }
                             
             return gugunList;         
    }

    // ��������=============================================
    public ArrayList<ZipDto> searchDong(String sido, String gugun) {
             ArrayList<ZipDto> dongList = new ArrayList<>();

             try {
                      String query = "select distinct(dong) from zipcode where sido = \'" + sido + "\'  and gugun = \'" + gugun + "\' order by dong";
                      pstmt = conn.prepareStatement(query);
                      rs = pstmt.executeQuery();
                      while(rs.next()){
                              ZipDto zipcode = new ZipDto();
                              zipcode.setDong(rs.getString("DONG"));
                              dongList.add(zipcode);
                      }
             } catch (SQLException e) {
             }

             return dongList;          
    }

    // �����ּ� ������ =============================================
    public ArrayList<ZipDto> searchAddress(String sido, String gugun, String dong) {

    	ArrayList<ZipDto> addressList = new ArrayList<>();

    	try {
    		String query = "select * from zipcode where sido = \'" + sido + "\'  and gugun = \'" + gugun + "\' and dong = \'" + dong +"\'";
		
    		pstmt = conn.prepareStatement(query);
   
    		rs = pstmt.executeQuery();

    		while(rs.next()){

    			ZipDto zipcode = new ZipDto();
   
    			zipcode.setSeq(rs.getString("seq")); 
                zipcode.setZipcode(rs.getString("zipcode"));	 	//��������Ʈ	 
                zipcode.setSido(rs.getString("sido"));
	            zipcode.setGugun(rs.getString("gugun"));
	            zipcode.setDong(rs.getString("dong"));
	
	            zipcode.setRi(rs.getString("ri"));
	            zipcode.setBldg(rs.getString("bldg"));
	            zipcode.setBunji(rs.getString("bungi"));
	            
	            addressList.add(zipcode);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}

    	return addressList;               
    }

	public ArrayList<ZipDto> searchKeyDong(String dongName) {
		
		ArrayList<ZipDto> addressList = new ArrayList<>();

    	try {
    		//String query = "select * from zipcode where dong like \'%\' \'" + dongName + "\' || \'%\'";
    		String query = "select * from zipcode where dong like '%" + dongName + "%'";
    		pstmt = conn.prepareStatement(query);
    
    		rs = pstmt.executeQuery();

    		while(rs.next()){

    			ZipDto zipcode = new ZipDto();
    			zipcode.setSeq(rs.getString("seq"));     
                zipcode.setZipcode(rs.getString("zipcode"));
                zipcode.setSido(rs.getString("sido"));
	            zipcode.setGugun(rs.getString("gugun"));
	            zipcode.setDong(rs.getString("dong"));
	            zipcode.setRi(rs.getString("ri"));
	            zipcode.setBldg(rs.getString("bldg"));
	            zipcode.setBunji(rs.getString("bungi"));
	      
	            addressList.add(zipcode);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
             
    	return addressList;  
	}
	
	
	//����Ʈ �׸��忡�� ������ �� ��ȯ
	public ZipDto findByNum( String vnum ) throws Exception{
		/*===================================
		�ش��ϴ� ������ȣ�� ���� ���� �˻��ϱ�

			1.  sql �ۼ��ϱ�			( select �� �ۼ� : ���� �����Ͽ� )
				# SELECT * FROM videoTab WHERE videoNum=?

			2.  sql  ���۰�ü ������	
			3.  sql  ����				( executeQuery() �̿� )
										( ��� �޾� ����ʵ忡 ���� )
			4.  �ݱ�				( Connection�� ������ �ȵ� )

		*/

		//Integer.parseInt(vnum);
		ZipDto dto = new ZipDto();
		int snum=Integer.parseInt(vnum);
		String sql = "select sido, gugun, dong from zipcode where seq=" + snum;
		
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "rustic", "pass");
        
		Statement ps = conn.createStatement();

		ResultSet rs = ps.executeQuery(sql);

		if(rs.next()) {
			//dto.setSeq(vnum);
	
			dto.setSido(rs.getString("sido"));
			dto.setGugun(rs.getString("gugun"));
			dto.setDong(rs.getString("dong"));
		}
		rs.close();
		ps.close();
		
		return dto;
	}
	
	
	
}
