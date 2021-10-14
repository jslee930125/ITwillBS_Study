package com.itwillbs.domain;

public class ProductVO {
	// VO(Value Object) == DTO == 자바빈
	
	private String name;
	private double price;
	
	// 생성자
	public ProductVO() { }
	public ProductVO(String name,double price) {
		this.name = name;
		this.price = price;
	}
	
	// set/get() 생성
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	//toString
	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + "]";
	}
	
}
