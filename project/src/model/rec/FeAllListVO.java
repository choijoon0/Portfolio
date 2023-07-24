package model.rec;

public class FeAllListVO {
	int festcode;
	String festname;

	public FeAllListVO() {

	}

	public FeAllListVO(int festcode, String festname) {
		this.festcode=festcode;
		this.festname=festname;
	}

	public int getFestcode() {
		return festcode;
	}

	public void setFestcode(int festcode) {
		this.festcode = festcode;
	}

	public String getFestname() {
		return festname;
	}

	public void setFestname(String festname) {
		this.festname = festname;
	}

}
