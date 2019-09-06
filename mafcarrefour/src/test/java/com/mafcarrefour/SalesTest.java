package com.mafcarrefour;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mafcarrefour.sales.entity.Basket;
import com.mafcarrefour.sales.entity.Goods;
import com.mafcarrefour.sales.service.SalesTaxCalculator;
import com.mafcarrefour.sales.service.SalesTaxCalculatorImpl;

/**
 * Unit test for App.
 */
public class SalesTest {
	private SalesTaxCalculator saleTaxCalculator;
	
	@Before
	public void beforeTests() {
		saleTaxCalculator = new SalesTaxCalculatorImpl(10, 5);
	}
	@Test
	public void testEval() {
		Basket basket = new Basket();
		List<Goods> goodsList = new LinkedList<Goods>();
		goodsList.add(new Goods("1 Book", 12.49f, false, false));
		goodsList.add(new Goods("1 Music CD", 14.99f, true, false));
		goodsList.add(new Goods("1 Chocolate bar", 0.85f, false, false));
		basket.setGoodsList(goodsList);
		saleTaxCalculator.calculateSalesTax(basket);
		
		goodsList = basket.getGoodsList();
		Goods goods = goodsList.get(0);
		System.out.println(goods.getName()+": "+ goods.getPrice());
		Assert.assertEquals(goods.getName(), 12.49f, goods.getPrice(), 0.00f);
		
		goods = goodsList.get(1);
		System.out.println(goods.getName()+": "+ goods.getPrice());
		Assert.assertEquals(goods.getName(), 16.49f, goods.getPrice(),0.00f);
		
		goods = goodsList.get(2);
		System.out.println(goods.getName()+": "+ goods.getPrice());
		Assert.assertEquals(goods.getName(), 0.85f, goods.getPrice(), 0.00f);
		
		System.out.println("Sales tax: "+ basket.getTotalSalesTax());
		System.out.println("Total: "+ basket.getBasketAmt());
		
		Assert.assertEquals("Sales taxes",1.50f, basket.getTotalSalesTax(), 0.00f);
		Assert.assertEquals("Total",29.83f, basket.getBasketAmt(), 0.00f);
	}
	@Test
	public void testEval1() {
		Basket basket = new Basket();
		List<Goods> goodsList = new LinkedList<Goods>();
		goodsList.add(new Goods("1 Imported Box of Chocolates",10.00f,false, true));
		goodsList.add(new Goods("1 Music CD", 47.50f,true, true));
		basket.setGoodsList(goodsList);
		saleTaxCalculator.calculateSalesTax(basket);
		
		goodsList = basket.getGoodsList();
		Goods goods = goodsList.get(0);
		System.out.println(goods.getName()+": "+ goods.getPrice());
		Assert.assertEquals(goods.getName(), 10.50f, goods.getPrice(),0.00f);
		
		goods = goodsList.get(1);
		System.out.println(goods.getName()+": "+ goods.getPrice());
		Assert.assertEquals(goods.getName(), 54.65f, goods.getPrice(),0.00f);
		
		System.out.println("Sales tax: "+ basket.getTotalSalesTax());
		System.out.println("Total: "+ basket.getBasketAmt());
		Assert.assertEquals("Sales taxes",7.65f, basket.getTotalSalesTax(), 0.00f);
		Assert.assertEquals("Total",65.15f, basket.getBasketAmt(), 0.00f);
	}
	@Test
	public void testEval2() {
		Basket basket = new Basket();
		List<Goods> goodsList = new LinkedList<Goods>();
		goodsList.add(new Goods("1 Imported bottel of perfume", 27.99f,true, true));
		goodsList.add(new Goods("1 Bottel of perfume", 18.99f,true, false));
		goodsList.add(new Goods("1 Packet of Headache pills", 9.75f,false, false));
		goodsList.add(new Goods("1 Box of imported Chocolates", 11.25f,false, true));
		basket.setGoodsList(goodsList);
		saleTaxCalculator.calculateSalesTax(basket);
		
		goodsList = basket.getGoodsList();
		Goods goods = goodsList.get(0);
		System.out.println(goods.getName()+": "+ goods.getPrice());
		Assert.assertEquals(goods.getName(), 32.19f, goods.getPrice(),0.00f);
		
		goods = goodsList.get(1);
		System.out.println(goods.getName()+": "+ goods.getPrice());
		Assert.assertEquals(goods.getName(), 20.89f, goods.getPrice(),0.00f);
		
		goods = goodsList.get(2);
		System.out.println(goods.getName()+": "+ goods.getPrice());
		Assert.assertEquals(goods.getName(), 9.75f, goods.getPrice(), 0.00f);
		
		goods = goodsList.get(3);
		System.out.println(goods.getName()+": "+ goods.getPrice());
		Assert.assertEquals(goods.getName(), 11.85f, goods.getPrice(),0.00f);
		
		
		System.out.println("Sales tax: "+ basket.getTotalSalesTax());
		System.out.println("Total: "+ basket.getBasketAmt());
		Assert.assertEquals("Sales taxes",6.70f, basket.getTotalSalesTax(), 0.00f);
		Assert.assertEquals("Total", 74.68f, basket.getBasketAmt(), 0.00f);
	}
	
}
