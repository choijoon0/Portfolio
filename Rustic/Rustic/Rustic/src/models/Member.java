package models;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class Member {
	private String ownerid;
	private String ownerpw;
	
	
	public String getownerid() {
		return ownerid;
	}
	public void setownerid(String ownerid) {
		ownerid = ownerid;
	}
	public String getownerpw() {
		return ownerpw;
	}
	public void setownerpw(String ownerpw) {
		ownerpw = ownerpw;
	}
	
}

