package model.rec;

public class PayGoVO {
	String bankname, goname, gonum,req;
	int jcode, memcode;

	public PayGoVO(String bankname, String goname, String gonum, int jcode) {
		this.bankname = bankname;
		this.goname = goname;
		this.gonum = gonum;
		this.jcode = jcode;
	}

	public PayGoVO(int jcode, String req, int memcode) {
		this.jcode = jcode;
		this.req = req;
		this.memcode = memcode;
	}
	
	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

	public int getMemcode() {
		return memcode;
	}

	public void setMemcode(int memcode) {
		this.memcode = memcode;
	}

	public int getJcode() {
		return jcode;
	}


	public void setJcode(int jcode) {
		this.jcode = jcode;
	}


	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getGoname() {
		return goname;
	}

	public void setGoname(String goname) {
		this.goname = goname;
	}

	public String getGonum() {
		return gonum;
	}

	public void setGonum(String gonum) {
		this.gonum = gonum;
	}

}
