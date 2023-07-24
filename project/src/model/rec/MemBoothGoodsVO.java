package model.rec;

public class MemBoothGoodsVO {
	int amount, jucode, goodscode, total;
	
	
	public MemBoothGoodsVO(int amount, int jucode, int goodscode) {
		this.amount = amount;
		this.jucode = jucode;
		this.goodscode = goodscode;
	}

	public MemBoothGoodsVO(int total) {
		this.total=total;
	}

	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getJucode() {
		return jucode;
	}


	public void setJucode(int jucode) {
		this.jucode = jucode;
	}


	public int getGoodscode() {
		return goodscode;
	}


	public void setGoodscode(int goodscode) {
		this.goodscode = goodscode;
	}
	
}
