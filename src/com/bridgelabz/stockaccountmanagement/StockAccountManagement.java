package com.bridgelabz.stockaccountmanagement;

import java.util.Scanner;

import com.bridgelabz.linkedlist.MyLinkedList;
import com.bridgelabz.linkedlist.MyNode;
import com.bridgelabz.stacks.MyStack;

public class StockAccountManagement {
	static final Scanner scanner = StockAccountManagementMain.scanner;

	MyLinkedList<Stock> stocksList = new MyLinkedList<Stock>();
	MyStack<String> myPurchase= new MyStack<String>();
	MyStack<String> mySelling= new MyStack<String>();

	StocksAccountIF stockAccount = new StocksAccount(stocksList,myPurchase,mySelling);

	public void buyShare() {
		System.out.println("Enter the name of stock");
		String name = scanner.next();
		System.out.println("Enter the number of shares");
		int numOfShares = scanner.nextInt();

		if (stockAccount.search(name) != null) {
			stockAccount.buy(numOfShares, name);
			

		} else {
			System.out.println("Enter the price for each share");
			double price = scanner.nextDouble();
			Stock stock = new Stock(name, numOfShares, price);
			MyNode<Stock> myStockNode = new MyNode<Stock>(stock);
			stocksList.append(myStockNode);
			MyNode<String> nameInStack = new MyNode<String>(name);
			myPurchase.push(nameInStack);
		}
	}

	public void sellShare() {
		System.out.println("Enter the name of stock");
		String name = scanner.next();
		if (stockAccount.search(name) != null) {
			System.out.println("Enter the number of shares");
			int numOfShares = scanner.nextInt();
			stockAccount.sell(numOfShares, name);
		} else {
			System.out.println("You don't own any shares with such name!");
		}
	}

	public void printReport() {
		stockAccount.printReport();

	}

	public void deleteShare() {
		System.out.println("Enter the name of stock");
		String name = scanner.next();
		MyNode<Stock> tempNode = stockAccount.search(name);
		if(tempNode != null) {
			stocksList.deleteGivenKeyNode(tempNode.getKey());
		System.out.println("Share is deleted!");
		} else {
			System.out.println("You don't own any shares with such name!");
		}
		
	}
	public void showHistory() {
		stockAccount.stackDisplay();
	}
}
