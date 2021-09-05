package com.bridgelabz.stockaccountmanagement;

public class StockAccountManagementMain {
public static void main(String[] args) {
	StockPortfolio stockPortfolio = new StockPortfolio();
	stockPortfolio.addStocks();
	double totalValue = stockPortfolio.calculateValues();
	System.out.println("Total value of all the stocks is: " + totalValue);}
}
