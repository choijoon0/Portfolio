package model.rec;

import java.util.Date;

public class FeSignupVO {
	int festcode, ctcode, starttime, endtime, price, boose, memcode, festSeat;
	String name, loc, company, content, startday, endday, festdetail;
	
	

	public FeSignupVO(int festcode, int ctcode, int starttime, int endtime, int price, int boose, String startday,
			String endday, String name, String loc, String company, String content,int memcode,String festdetail) {

		this.festcode = festcode;
		this.ctcode = ctcode;
		this.starttime = starttime;
		this.endtime = endtime;
		this.price = price;
		this.boose = boose;
		this.startday = startday;
		this.endday = endday;
		this.name = name;
		this.loc = loc;
		this.company = company;
		this.content = content;
		this.memcode = memcode;
		this.festdetail = festdetail;
	}
	
	public FeSignupVO(int ctcode, int starttime, int endtime, int price, int boose, String startday, String endday, String name, String loc, String company, String content, String festdetail, int mcode, int festSeat) {
		this.ctcode = ctcode;
		this.starttime= starttime;
		this.endtime =endtime;
		this.price = price;
		this.boose = boose;
		this.startday = startday;
		this.endday = endday;
		this.name = name;
		this.loc = loc;
		this.company = company;
		this.content = content;
		this.festdetail = festdetail;
		this.memcode = mcode;
		this.festSeat = festSeat;
	}

	public int getFestSeat() {
		return festSeat;
	}

	public void setFestSeat(int festSeat) {
		this.festSeat = festSeat;
	}

	public String getFestdetail() {
		return festdetail;
	}

	public void setFestdetail(String festdetail) {
		this.festdetail = festdetail;
	}

	public int getMemcode() {
		return memcode;
	}

	public void setMemcode(int memcode) {
		this.memcode = memcode;
	}

	public int getFestcode() {
		return festcode;
	}

	public void setFestcode(int festcode) {
		this.festcode = festcode;
	}

	public int getCtcode() {
		return ctcode;
	}

	public void setCtcode(int ctcode) {
		this.ctcode = ctcode;
	}

	public int getStarttime() {
		return starttime;
	}

	public void setStarttime(int starttime) {
		this.starttime = starttime;
	}

	public int getEndtime() {
		return endtime;
	}

	public void setEndtime(int endtime) {
		this.endtime = endtime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBoose() {
		return boose;
	}

	public void setBoose(int boose) {
		this.boose = boose;
	}

	public String getStartday() {
		return startday;
	}

	public void setStartday(String startday) {
		this.startday = startday;
	}

	public String getEndday() {
		return endday;
	}

	public void setEndday(String endday) {
		this.endday = endday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public FeSignupVO() {
		// TODO Auto-generated constructor stub
	}

	

}
