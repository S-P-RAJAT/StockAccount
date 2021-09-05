package com.bridgelabz.stockaccountmanagement;

import java.util.Scanner;

import com.bridgelabz.linkedlist.MyLinkedList;
import com.bridgelabz.linkedlist.MyNode;

public class StockPortfolio {
	private static MyLinkedList<Stock> stocksList = new MyLinkedList<Stock>();

	public static void addStocks() {
		System.out.println("Enter the number of Stocks that want to add: ");
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();

		double totalStockValue = 0;

		for (int index = 0; index < count; index++) {
			System.out.println("Enter the name of stock");
			String name = scanner.next();
			System.out.println("Enter the number of shares");
			int numOfShares = scanner.nextInt();
			System.out.println("Enter the price for each share");
			double price = scanner.nextDouble();
			Stock stock = new Stock(name, numOfShares, price);

			double value = numOfShares * price;
			System.out.println("Value for stock '" + name + "' is: " + value);
			totalStockValue += value;

			MyNode<Stock> myStockNode = new MyNode<Stock>(stock);
			stocksList.append(myStockNode);
		}
		System.out.println("Total stock value = "+totalStockValue);
		scanner.close();
	}
}