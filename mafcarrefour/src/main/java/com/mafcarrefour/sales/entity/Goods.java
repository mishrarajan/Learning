package com.mafcarrefour.sales.entity;

import java.io.Serializable;

public class Goods implements Serializable {
	
	/**
	 * Generated by Compiler
	 */
	private static final long serialVersionUID = 1979301751614285416L;
	private String name;
	private float price;
	private boolean isSalestaxApplicable;
	private boolean isImported;
	
	public Goods() {
		
	}
	public Goods(String name, float price, boolean isSalestaxApplicable, boolean isImported) {
		super();
		this.name = name;
		this.price = price;
		this.isSalestaxApplicable = isSalestaxApplicable;
		this.isImported = isImported;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isSalestaxApplicable() {
		return isSalestaxApplicable;
	}
	public void setSalestaxApplicable(boolean isSalestaxApplicable) {
		this.isSalestaxApplicable = isSalestaxApplicable;
	}
	public boolean isImported() {
		return isImported;
	}
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	
	

}
