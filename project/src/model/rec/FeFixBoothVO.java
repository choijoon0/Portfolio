package model.rec;

public class FeFixBoothVO {
	String fesname, boothname;

	public FeFixBoothVO() {

	}

	public FeFixBoothVO(String fesname, String boothname) {
		this.fesname = fesname;
		this.boothname = boothname;
	}

	public String getFesname() {
		return fesname;
	}

	public void setFesname(String fesname) {
		this.fesname = fesname;
	}

	public String getBoothname() {
		return boothname;
	}

	public void setBoothname(String boothname) {
		this.boothname = boothname;
	}

}
