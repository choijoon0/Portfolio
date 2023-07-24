package model.rec;

public class ResSeatVO {
	
	int paycode, seatchoice, memcode, festcode;

	public ResSeatVO(int paycode) {
		this.paycode =paycode;
		
	}
	
	public ResSeatVO(int paycode, int seatchoice, int memcode, int festcode) {
		this.paycode = paycode;
		this.seatchoice = seatchoice;
		this.memcode = memcode;
		this.festcode = festcode;
		
	}
	
	
	public int getSeatchoice() {
		return seatchoice;
	}

	public void setSeatchoice(int seatchoice) {
		this.seatchoice = seatchoice;
	}

	public int getMemcode() {
		return memcode;
	}

	public void setMemcode(int memcode) {
		this.memcode = memcode;
	}

	public int getFestcode() {
		return festcode;
	}

	public void setFestcode(int festcode) {
		this.festcode = festcode;
	}

	public int getPaycode() {
		return paycode;
	}

	public void setPaycode(int paycode) {
		this.paycode = paycode;
	}



	

}
