package model.rec;

public class AddGoodsVO {
//	String bthName;
	String goodsName, boothName, goodsImg, gctName, gtName, gdName;
	int jungPrice, onePrice, goodsCnt, gctCode, boothCode;

	public AddGoodsVO() {
		
	}
	
	public AddGoodsVO(String goodsimg) {
		// TODO Auto-generated constructor stub
		this.goodsImg = goodsimg;
		
	}

//	public AddGoodsVO(String boothname, int jungprice, int) {
////		this.bthName=bthName;
//		this.boothName = boothName;
////		this.gctCode = gctCode;
//		this.goodsName = goodsName;
//		this.jungPrice = jungPrice;
//		this.onePrice = onePrice;
//		this.goodsCnt = goodsCnt;
//		this.goodsImg = goodsImg;
////		this.gctName = gctName;
////		this.boothCode = boothCode;
//	}
//	
	
	//상품인서트위함
	public AddGoodsVO(int boothcode, String goodsname, int jungprice, int oneprice, int goodscnt,String goodsimg) {
		// TODO Auto-generated constructor stub
		this.boothCode = boothcode;
		this.goodsName = goodsname;
		this.jungPrice = jungprice;
		this.onePrice = oneprice;
		this.goodsCnt = goodscnt;
		this.goodsImg = goodsimg;
	}
	public AddGoodsVO(String goodsname, int jungprice, int oneprice, int goodscnt) {
		this.goodsName = goodsname;
		this.jungPrice = jungprice;
		this.onePrice = oneprice;
		this.goodsCnt = goodscnt;
	}
	
	public AddGoodsVO(String boothname, String goodsname, int jungprice, int oneprice, 
			int goodscnt, String goodsimg, String gtname, String gdname) {
		this.boothName = boothname;
		this.goodsName = goodsname;
		this.jungPrice = jungprice;
		this.onePrice = oneprice;
		this.goodsCnt = goodscnt;
		this.goodsImg = goodsimg;
		this.gtName = gtname;
		this.gdName = gdname;
	}

	public String getGtName() {
		return gtName;
	}

	public void setGtName(String gtName) {
		this.gtName = gtName;
	}

	public String getGdName() {
		return gdName;
	}

	public void setGdName(String gdName) {
		this.gdName = gdName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getBoothName() {
		return boothName;
	}

	public void setBoothName(String boothName) {
		this.boothName = boothName;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public String getGctName() {
		return gctName;
	}

	public void setGctName(String gctName) {
		this.gctName = gctName;
	}

	public int getJungPrice() {
		return jungPrice;
	}

	public void setJungPrice(int jungPrice) {
		this.jungPrice = jungPrice;
	}

	public int getOnePrice() {
		return onePrice;
	}

	public void setOnePrice(int onePrice) {
		this.onePrice = onePrice;
	}

	public int getGoodsCnt() {
		return goodsCnt;
	}

	public void setGoodsCnt(int goodsCnt) {
		this.goodsCnt = goodsCnt;
	}

	public int getGctCode() {
		return gctCode;
	}

	public void setGctCode(int gctCode) {
		this.gctCode = gctCode;
	}

	public int getBoothCode() {
		return boothCode;
	}

	public void setBoothCode(int boothCode) {
		this.boothCode = boothCode;
	}
	
	
	
	
	
	
}
