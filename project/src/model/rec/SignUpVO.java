package model.rec;

public class SignUpVO {
	String name, tel, jumin, id, pw, memcode;
	public SignUpVO() {
		

	}
	
	public SignUpVO(String name, String tel, String jumin, String id, String pw, int memcode) {
		this.name = name;
		this.tel = tel;
		this.jumin = jumin;
		this.id = id;
		this.pw = pw;
		this.memcode = this.memcode;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
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

	public String getMemcode() {
		return memcode;
	}

	public void setMemcode(String memcode) {
		this.memcode = memcode;
	}
	
	
}
