package com.biz.list.model;
/*
 * a씨가 최근에 마트를 오픈을 함
 * 마트에서 판매되는 거래 내용을 관리할 app을 만들려함.
 * 거래내용을 관리할 클래스
 */
public class IoListVO {
	private String strDate;
	private String strTradedTime;
	private String strP_Name;
	private int intPrice;
	private int intQty;
	private int intTotal;
	
	public IoListVO(String strDate, String strTradedTime, String strP_Name, int intPrice) {
		this.intPrice=intPrice;
		this.strDate=strDate;
		this.strP_Name=strP_Name;
		this.strTradedTime=strTradedTime;
	}
	public IoListVO(String strDate, String strTradedTime, String strP_Name, int intPrice, int intQty) {
		this.intPrice=intPrice;
		this.strDate=strDate;
		this.strP_Name=strP_Name;
		this.strTradedTime=strTradedTime;
		this.intQty=intQty;
	}
	
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getstrTradedTime() {
		return strTradedTime;
	}
	public void setstrTradedTime(String strTradedTime) {
		this.strTradedTime = strTradedTime;
	}
	public String getStrP_Name() {
		return strP_Name;
	}
	public void setStrP_Name(String strP_Name) {
		this.strP_Name = strP_Name;
	}
	public int getIntPrice() {
		return intPrice;
	}
	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}
	public int getIntQty() {
		return intQty;
	}
	public void setIntQty(int intQty) {
		this.intQty = intQty;
	}
	public int getIntTotal() {
		return intTotal;
	}
	public void setIntTotal(int intTotal) {
		this.intTotal=intTotal;
	}
	
	public void setIntTotal(int intPrice, int intQty) {
		this.intTotal=intPrice*intQty;
	}
	
}
