package model.rec;

public class PayMainVO {

	int pk, jumuncode, tot;
	int memcode;
	String request;
	String cardname;
	String cardnum;
	int cvc;
	String yuhyo;

	public PayMainVO(int pk, int jumuncode, String request, int tot) {
		this.pk = pk;
		this.jumuncode = jumuncode;
		this.request = request;
		this.tot = tot;
	}

	public PayMainVO(String cardname, String cardnum, int cvc, String yuhyo) {
		this.cardname = cardname;
		this.cardnum = cardnum;
		this.cvc = cvc;
		this.yuhyo = yuhyo;

	}
	public PayMainVO(int memcode) {
		this.memcode=memcode;
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

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public String getYuhyo() {
		return yuhyo;
	}

	public void setYuhyo(String yuhyo) {
		this.yuhyo = yuhyo;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public int getJumuncode() {
		return jumuncode;
	}

	public void setJumuncode(int jumuncode) {
		this.jumuncode = jumuncode;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

}
