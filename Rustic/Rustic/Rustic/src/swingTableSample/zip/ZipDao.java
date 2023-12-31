package swingTableSample.zip;

import java.sql.*;

import java.util.ArrayList;

public class ZipDao {
	Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
   
   
    // 데이터베이스 연결
    public void connection() {
    	try {
                  Class.forName("oracle.jdbc.driver.OracleDriver");
                  conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "rustic", "pass");
         	} catch (ClassNotFoundException e) {
         		
            } catch (SQLException e) {
            	
            }
    }
   
    // 데이터베이스 연결종료
    public void disconnection() {
    	try {
    		if(pstmt != null) pstmt.close();
                      
    		if(rs != null) rs.close();
                      
    		if(conn != null) conn.close();
             
    	} catch (SQLException e) {
    		
    	}
    }

    // 시도데이터=============================================
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
   
    // 구군데이터=============================================
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

    // 동데이터=============================================
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

    // 전부주소 데이터 =============================================
    public ArrayList<ZipDto> searchAddress(String sido, String gugun, String dong) {

    	ArrayList<ZipDto> addressList = new ArrayList<>();

    	try {
    		String query = "select * from zipcode where sido = \'" + sido + "\'  and gugun = \'" + gugun + "\' and dong = \'" + dong +"\'";
		
    		pstmt = conn.prepareStatement(query);
   
    		rs = pstmt.executeQuery();

    		while(rs.next()){

    			ZipDto zipcode = new ZipDto();
   
    			zipcode.setSeq(rs.getString("seq")); 
                zipcode.setZipcode(rs.getString("zipcode"));	 	//오류포인트	 
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
	
	
	//리스트 그리드에서 선택한 값 반환
	public ZipDto findByNum( String vnum ) throws Exception{
		/*===================================
		해당하는 비디오번호에 의한 비디오 검색하기

			1.  sql 작성하기			( select 문 작성 : 조건 지정하여 )
				# SELECT * FROM videoTab WHERE videoNum=?

			2.  sql  전송객체 얻어오기	
			3.  sql  전송				( executeQuery() 이용 )
										( 결과 받아 멤버필드에 지정 )
			4.  닫기				( Connection은 닫으면 안됨 )

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
