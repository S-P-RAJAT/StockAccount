package com.bridgelabz.stockaccountmanagement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transactions {

	String stockName;
	double price;
	int numOfShares;
	String type;
	LocalDateTime date;

	public Transactions(String stockName, double price, int numOfShares, String type, LocalDateTime date) {
		super();
		this.stockName = stockName;
		this.price = price;
		this.numOfShares = numOfShares;
		this.type = type;
		this.date = date;

	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd/MM/uuuu hh:mm:ss a");
		String dateString = date.format(formatter);
		// TODO Auto-generated method stub
		return "\n\n Stock Name: " + stockName + "\n Price: " + price + "\n Number of Shares: " + numOfShares + "\n Type: " + type + "\n Date:" + dateString;
	}
}
