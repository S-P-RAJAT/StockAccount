package com.bridgelabz.stockaccountmanagement;

public interface StocksAccountIF {
	double valueOf();
	
	void buy(int amount, String symbol);
	
	void sell(int amount, String symbol);
		
	void printReport();
}
