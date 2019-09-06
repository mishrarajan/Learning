package com.mafcarrefour.sales.service;

import com.mafcarrefour.sales.entity.Basket;
import com.mafcarrefour.sales.entity.Goods;

public class SalesTaxCalculatorImpl implements SalesTaxCalculator {

	private float salesTaxRate;
	private float importDutyRate;

	public SalesTaxCalculatorImpl() {

	}
	public SalesTaxCalculatorImpl(float salesTaxRate, float importDutyRate) {
		this.salesTaxRate = salesTaxRate;
		this.importDutyRate = importDutyRate;
	}

	@Override
	public void calculateSalesTax(Basket basket) {
		for(Goods goods: basket.getGoodsList()) {
			float goodsSalesTax = 0.0f;
			float goodsImportDuty = 0.0f;
				
			if(goods.isSalestaxApplicable()) {
				goodsSalesTax = (goods.getPrice() * salesTaxRate)/100;
			}
			if(goods.isImported()) {
				goodsImportDuty = (goods.getPrice() * importDutyRate)/100;
			}
			goodsSalesTax = goodsSalesTax + goodsImportDuty;
			goodsSalesTax = roundValue(goodsSalesTax);
			
			goods.setPrice(goods.getPrice() + goodsSalesTax);
			basket.setBasketAmt(basket.getBasketAmt() + goods.getPrice());
			basket.setTotalSalesTax(basket.getTotalSalesTax() + goodsSalesTax);
		}
	}

	public float getSalesTaxRate() {
		return salesTaxRate;
	}

	public void setSalesTaxRate(float salesTaxRate) {
		this.salesTaxRate = salesTaxRate;
	}

	public float getImportDutyRate() {
		return importDutyRate;
	}

	public void setImportDutyRate(float importDutyRate) {
		this.importDutyRate = importDutyRate;
	}

}
