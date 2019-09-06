package com.mafcarrefour.sales.entity;

import java.util.List;

public class Basket {
	private List<Goods> goodsList;
	private float totalSalesTax;
	private float basketAmt;
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	public float getTotalSalesTax() {
		return totalSalesTax;
	}
	public void setTotalSalesTax(float totalSalesTax) {
		this.totalSalesTax = totalSalesTax;
	}
	public float getBasketAmt() {
		return basketAmt;
	}
	public void setBasketAmt(float basketAmt) {
		this.basketAmt = basketAmt;
	}
	
}
