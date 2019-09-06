package com.mafcarrefour.sales.service;

import com.mafcarrefour.sales.entity.Basket;

public interface SalesTaxCalculator {
	void calculateSalesTax(Basket basket);
	/**
	 * Round the value nearest to the 0.05.
	 * @param value
	 * @return Rounded value
	 */
	default float roundValue(float value) {
		return (Math.round(value*20))/20.0f;
	}
	
}
