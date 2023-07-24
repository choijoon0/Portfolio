package model.rec;

public class PayCardVO {
	String cardname, cardnum, yuhyo, request;
	int cvc, jucode, memcode;

	public PayCardVO(String cardname, String cardnum, int cvc, String yuhyo, int jucode, String request) {
		this.cardname = cardname;
		this.cardnum = cardnum;
		this.cvc = cvc;
		this.yuhyo = yuhyo;
		this.jucode = jucode;
		this.request = request;
	}

	public PayCardVO(int jucode, String request, int memcode) {
		this.jucode = jucode;
		this.request = request;
		this.memcode = memcode;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public int getMemcode() {
		return memcode;
	}

	public void setMemcode(int memcode) {
		this.memcode = memcode;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getYuhyo() {
		return yuhyo;
	}

	public void setYuhyo(String yuhyo) {
		this.yuhyo = yuhyo;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public int getJucode() {
		return jucode;
	}

	public void setJucode(int jucode) {
		this.jucode = jucode;
	}

}
