package model.rec;

public class BoothResVO {
	String boothname, boothtel, festname, boothctname, boothresok;
	int boothctcode, festcode, boothopen, boothclose, memcode, boothcode;

	public BoothResVO() {

	}

	public BoothResVO(String boothname, int boothctcode, int festcode, String boothtel, int boothopen, int boothclose,
			int memcode) {
		// TODO Auto-generated constructor stub
		this.boothname = boothname;
		this.boothctcode = boothctcode;
		this.festcode = festcode;
		this.boothtel = boothtel;
		this.boothopen = boothopen;
		this.boothclose = boothclose;
		this.memcode = memcode;
	}

//	public BoothResVO(String festname, String boothname, String boothctname, int boothopen, int boothclose,
//			String boothtel) {
//		this.festname = festname;
//		this.boothname = boothname;
//		this.boothctname = boothctname;
//		this.boothopen = boothopen;
//		this.boothclose = boothclose;
//		this.boothtel = boothtel;
//	}

	public BoothResVO(String boothname, int boothctcode, String boothtel, int boothopen, int boothclose,
			int boothcode) {
		this.boothname = boothname;
		this.boothctcode = boothctcode;
		this.boothtel = boothtel;
		this.boothopen = boothopen;
		this.boothclose = boothclose;
		this.boothcode = boothcode;

	}

	public int getBoothcode() {
		return boothcode;
	}

	public void setBoothcode(int boothcode) {
		this.boothcode = boothcode;
	}

	public String getFestname() {
		return festname;
	}

	public void setFestname(String festname) {
		this.festname = festname;
	}

	public String getBoothctname() {
		return boothctname;
	}

	public void setBoothctname(String boothctname) {
		this.boothctname = boothctname;
	}

	public String getBoothresok() {
		return boothresok;
	}

	public void setBoothresok(String boothresok) {
		this.boothresok = boothresok;
	}

	public int getMemcode() {
		return memcode;
	}

	public void setMemcode(int memcode) {
		this.memcode = memcode;
	}

	public String getBoothname() {
		return boothname;
	}

	public void setBoothname(String boothname) {
		this.boothname = boothname;
	}

	public String getBoothtel() {
		return boothtel;
	}

	public void setBoothtel(String boothtel) {
		this.boothtel = boothtel;
	}

	public int getBoothctcode() {
		return boothctcode;
	}

	public void setBoothctcode(int boothctcode) {
		this.boothctcode = boothctcode;
	}

	public int getFestcode() {
		return festcode;
	}

	public void setFestcode(int festcode) {
		this.festcode = festcode;
	}

	public int getBoothopen() {
		return boothopen;
	}

	public void setBoothopen(int boothopen) {
		this.boothopen = boothopen;
	}

	public int getBoothclose() {
		return boothclose;
	}

	public void setBoothclose(int boothclose) {
		this.boothclose = boothclose;
	}

}
