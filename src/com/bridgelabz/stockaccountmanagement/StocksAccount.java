package com.bridgelabz.stockaccountmanagement;

import com.bridgelabz.linkedlist.MyLinkedList;
import com.bridgelabz.linkedlist.MyNode;

public class StocksAccount implements StocksAccountIF {
	private MyLinkedList<Stock> stocksList;

	public StocksAccount(MyLinkedList<Stock> stocksList) {
		super();
		this.stocksList = stocksList;
	}

	public double valueOf() {
		double totalStockValue = 0;
		MyNode<Stock> tempNode = (MyNode<Stock>) stocksList.head;
		while (tempNode != null) {
			Stock stock = tempNode.getKey();
			double value = stock.getNumberOfShares() * stock.getSharePrice();
			totalStockValue += value;
			tempNode = (MyNode<Stock>) tempNode.getNext();
		}
		return totalStockValue;
	}

	public MyNode<Stock> search(String name) {
		MyNode<Stock> tempNode = (MyNode<Stock>) stocksList.head;
		while (tempNode != null) {
			if (tempNode.getKey().getName().equals(name)) {
				return tempNode;
			}
			tempNode = (MyNode<Stock>) tempNode.getNext();
		}
		return null;
	}

	public void buy(int amount, String name) {

		MyNode<Stock> tempNode = search(name);

		double sharePrice = tempNode.getKey().getSharePrice();
		int noOfShares = (int) (amount / sharePrice);
		int orginalNoOfShare = tempNode.getKey().getNumberOfShares();
		tempNode.getKey().setNumberOfShares(noOfShares + orginalNoOfShare);
		System.out.println(noOfShares + " shares are added to " + name);

	}

	public void sell(int amount, String name) {
		MyNode<Stock> tempNode = search(name);
			double sharePrice = tempNode.getKey().getSharePrice();
			int noOfShares = (int) (amount / sharePrice);
			int orginalNoOfShare = tempNode.getKey().getNumberOfShares();
			int sell = orginalNoOfShare - noOfShares;
			if (sell > 0) {
				tempNode.getKey().setNumberOfShares(sell);
				System.out.println(noOfShares + " shares worth "+(tempNode.getKey().getSharePrice()*noOfShares)+" are sold from " + name);
			} else {
				System.out.println("You have not enough shares");
			}
	}

	public void printReport() {
		MyNode<Stock> tempNode = (MyNode<Stock>) stocksList.head;
		if (tempNode != null) {
			System.out.println("------ Stock Report ------");

			while (tempNode != null) {
				System.out.println("\nName: " + tempNode.getKey().getName());
				System.out.println("Number of shares: " + tempNode.getKey().getNumberOfShares());
				System.out.println("Share price: " + tempNode.getKey().getSharePrice());
				System.out.println(
						"Share Value: " + (tempNode.getKey().getNumberOfShares() * tempNode.getKey().getSharePrice()));
				tempNode = (MyNode<Stock>) tempNode.getNext();
			}
			System.out.println("\nTotal value of stock = " + valueOf());
		} else {
			System.out.println("No shares exists in the stock account");
		}
	}
}
