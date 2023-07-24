package model.rec;

public class LoginVO {
	String id, pw;
	int ctnum;

	public LoginVO() {

	}

	public LoginVO(String id, String pw, int ctnum) {
		this.id = id;
		this.pw = pw;
		this.ctnum = ctnum;
	}

	public LoginVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
