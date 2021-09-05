package com.bridgelabz.stockaccountmanagement;

import com.bridgelabz.linkedlist.MyNode;

public interface StocksAccountIF {
	double valueOf();
	
	MyNode<Stock> search(String name);
	
	void buy(int amount, String symbol);
	
	void sell(int amount, String symbol);
		
	void printReport();
}
