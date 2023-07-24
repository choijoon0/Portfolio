package model.rec;

public class FeTicketInfoVO {
String festname;			
int memcode;

public FeTicketInfoVO() {
	
}

public FeTicketInfoVO(String fesname,int memcode) {
	this.festname=fesname;
	this.memcode=memcode;
}

public String getFestname() {
	return festname;
}

public void setFestname(String festname) {
	this.festname = festname;
}

public int getMemcode() {
	return memcode;
}

public void setMemcode(int memcode) {
	this.memcode = memcode;
}

}