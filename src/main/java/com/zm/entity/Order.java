package com.zm.entity;


public class Order {
	private int id;
	private int number;
	private String dateO;
	private String dateP;
	private Goods good;
	private boolean payState;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDateO() {
		return dateO;
	}

	public void setDateO(String dateO) {
		this.dateO = dateO;
	}

	public String getDateP() {
		return dateP;
	}

	public void setDateP(String dateP) {
		this.dateP = dateP;
	}

	public Goods getGood() {
		return good;
	}

	public void setGood(Goods good) {
		this.good = good;
	}

	public boolean isPayState() {
		return payState;
	}

	public void setPayState(boolean payState) {
		this.payState = payState;
	}
}
