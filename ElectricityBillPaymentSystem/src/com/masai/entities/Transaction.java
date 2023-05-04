package com.masai.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable{
	
	private String username;
	private String email;
	private int billId;
	private String billName;
	private int quantity;
	private double price;
	private double total;
	private LocalDate dt;
	
	private Transaction() {
		
	}
	
	public String getName() {
		return billName;
	}
	
	public void setName(String billName) {
		this.billName = billName;
	}
	
	public Transaction(String username, String email, int billId, String billName,int quantity,double price, double total,LocalDate dt) {
		super();
		this.username = username;
		this.email = email;
		this.billId = billId;
		this.billName = billName;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.dt = dt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDate getDt() {
		return dt;
	}

	public void setDt(LocalDate dt) {
		this.dt = dt;
	}
	
	
	@Override
	public String toString() {
		return "Transaction [username=" + username + ", email=" + email + ", billId=" + billId + ", billName=" + billName +", quantity=" 
				+ quantity + ", price=" + price + ", total=" + total + ", dt=" + dt +"]";
	}
}
