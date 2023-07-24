package model.rec;

public class ConcertGoPayVO {
	String bank,name,account;
	int resnum;
	public ConcertGoPayVO(String bank, String name, String accout, int resnum) {
		// TODO Auto-generated constructor stub
		this.bank=bank;
		this.name=name;
		this.account =accout;
		this.resnum=resnum;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getResnum() {
		return resnum;
	}
	public void setResnum(int resnum) {
		this.resnum = resnum;
	}
	
	
}
