package com.pack;

public class Product {
	
	int id;
	public Product(int id, String name, String desc, String seller, String email, float price) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.seller = seller;
		this.email = email;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	String name;
	String desc;
	String seller;
	String email;
	float price;

}
