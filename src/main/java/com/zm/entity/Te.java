package com.zm.entity;

public class Te {
	private String b;
	private int a = 1;

	public static String getS() {
		return s;
	}

	public static void setS(String s) {
		Te.s = s;
	}

	{
		System.out.println(a);
		System.out.println(s);
		System.out.println("块");
	}
	private static String s = "s";
	static {
		System.out.println(s);
		System.out.println("statci块");
	}

	public Te(String b) {
		this.b = b;
		System.out.println("constroct");
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	private int turnback() {
		return this.a;
	}

	public int turnback(String c) {
		System.out.println(c);
		return this.turnback();
	}
}
