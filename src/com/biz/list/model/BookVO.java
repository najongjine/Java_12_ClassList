package com.biz.list.model;

public class BookVO {
	private String strISBN;
	private String strTitle;
	private String strAuthor;
	private String strPublisher;
	private int intPrice;
	private int intPubYear;

	
	public String getStrTitle() {
		return strTitle;
	}
	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}
	public String getStrAuthor() {
		return strAuthor;
	}
	public void setStrAuthor(String strAuthor) {
		this.strAuthor = strAuthor;
	}
	public String getStrPublisher() {
		return strPublisher;
	}
	public void setStrPublisher(String strPublisher) {
		this.strPublisher = strPublisher;
	}
	public int getIntPrice() {
		return intPrice;
	}
	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}
	public int getIntPubYear() {
		return intPubYear;
	}
	public void setIntPubYear(int intPubYear) {
		this.intPubYear = intPubYear;
	}
	public String getStrISBN() {
		return strISBN;
	}
	public void setStrISBN(String strISBN) {
		this.strISBN = strISBN;
	}//end
	
	
}
