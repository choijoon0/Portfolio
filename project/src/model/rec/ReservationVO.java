package model.rec;

import java.util.Date;

public class ReservationVO {

	int festcode, ctcode, resseatcnt, price, howpay, seatcnt;
	String festname, loc, company, startday, endday;

	public ReservationVO(int festcode, int ctcode, int resseatcnt, int price, int howpay, int seatcnt, String festname,
			String loc, String company, String startday, String endday) {

		// 예약
		this.resseatcnt = resseatcnt;
		this.howpay = howpay;
		this.seatcnt = seatcnt;

		// 축제
		this.festcode = festcode;
		this.ctcode = ctcode;
		this.festname = festname;
		this.loc = loc;
		this.startday = startday;
		this.endday = endday;
		this.price = price;
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

	public int getResseatcnt() {
		return resseatcnt;
	}

	public void setResseatcnt(int resseatcnt) {
		this.resseatcnt = resseatcnt;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHowpay() {
		return howpay;
	}

	public void setHowpay(int howpay) {
		this.howpay = howpay;
	}

	public int getSeatcnt() {
		return seatcnt;
	}

	public void setSeatcnt(int seatcnt) {
		this.seatcnt = seatcnt;
	}

	public String getFestname() {
		return festname;
	}

	public void setFestname(String festname) {
		this.festname = festname;
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

	public ReservationVO() {
		// TODO Auto-generated constructor stub
	}

}
