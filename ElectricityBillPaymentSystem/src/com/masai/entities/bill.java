package com.masai.entities;

import java.io.Serializable;
import java.util.Objects;

public class bill implements Serializable{
	
	private int id;
	private String name;
	private int quantity;
	private double price;
	private String category;
	
	public bill() {
		super();
	}
	public bill(int id, String name, int quantity, double price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
		
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	@Override
	public String toString() {
		return "bill [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", category=" + category +"]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(category, id, name, price, quantity);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		
		bill other = (bill) obj;
		return Objects.equals(category, other.category) && id == other.id && Objects.equals(name, other.name) 
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity;
		
	}
	

}
