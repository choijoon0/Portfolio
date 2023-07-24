package model.rec;

public class ConcertCardPayVO {
	String bank, cardnum, yuhyo;
	int cvc, resnum;
	
	public ConcertCardPayVO(String bank, String cardnum, String yuhyo, int cvc, int resnum) {
		this.bank = bank;
		this.cardnum = cardnum;
		this.yuhyo = yuhyo;
		this.cvc = cvc;
		this.resnum = resnum;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
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

	public int getResnum() {
		return resnum;
	}

	public void setResnum(int resnum) {
		this.resnum = resnum;
	}
	
}
