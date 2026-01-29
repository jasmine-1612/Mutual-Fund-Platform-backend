package com.project;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="STOCKSINFUND") 
public class StocksInFund {
	
	@EmbeddedId
	StockIdentifier identifier;
	double stockWeight;
	double unit;
	
	
	
	public double getUnit() {
		return unit;
	}

	public void setUnit(double unit) {
		this.unit = unit;
	}

	public StocksInFund() {
		super();
	}

	public StocksInFund(StockIdentifier identifier, double stockWeight, double unit) {
		super();
		this.identifier = identifier;
		this.stockWeight = stockWeight;
		this.unit=unit;
	}

	public StockIdentifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(StockIdentifier identifier) {
		this.identifier = identifier;
	}

	public double getStockWeight() {
		return stockWeight;
	}

	public void setStockWeight(double stockWeight) {
		this.stockWeight = stockWeight;
	}

	
	
	
	
	
}
