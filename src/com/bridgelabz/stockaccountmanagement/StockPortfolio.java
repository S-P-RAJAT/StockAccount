package com.bridgelabz.stockaccountmanagement;

import java.util.Scanner;

import com.bridgelabz.linkedlist.MyLinkedList;
import com.bridgelabz.linkedlist.MyNode;

public class StockPortfolio {
	private MyLinkedList<Stock> stocksList = new MyLinkedList<Stock>();
	private double totalStockValue;

	public void addStocks() {
		System.out.println("Enter the number of Stocks that want to add: ");
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		for(int index =0;index<count;index++) {
			System.out.println("Enter the name of stock");
			String name = scanner.next();
			System.out.println("Enter the number of shares");
			int numOfShares = scanner.nextInt();
			System.out.println("Enter the price for each share");
			double price = scanner.nextDouble();
			Stock stock = new Stock(name,numOfShares,price);
			MyNode<Stock> myStockNode = new MyNode<Stock>(stock);
			stocksList.append(myStockNode);
		}
		scanner.close();
	}
	
	public double calculateValues() {
		MyNode<Stock> tempNode = (MyNode<Stock>) stocksList.head;
		while(tempNode != null) {
			Stock stock = tempNode.getKey();
			double value = stock.getNumberOfShares() * stock.getSharePrice();
			System.out.println("Value for stock '" + stock.getName() + "' is: " + value);
			totalStockValue += value;
			tempNode = (MyNode<Stock>)tempNode.getNext();
		}
		return totalStockValue;
	}
}