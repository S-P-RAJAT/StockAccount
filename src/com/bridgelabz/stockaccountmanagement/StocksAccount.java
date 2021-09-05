package com.bridgelabz.stockaccountmanagement;

import com.bridgelabz.linkedlist.MyLinkedList;
import com.bridgelabz.linkedlist.MyNode;

public class StocksAccount {
	private MyLinkedList<Stock> stocksList;

	public StocksAccount(MyLinkedList<Stock> stocksList) {
		super();
		this.stocksList = stocksList;
	}
	public double valueOf() {
		double totalStockValue = 0;
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

	public void buy(int amount, String name) {
		MyNode<Stock> tempNode = (MyNode<Stock>) stocksList.head;
		System.out.println("Hi");
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().getName().equals(name)) {
				double sharePrice = tempNode.getKey().getSharePrice();
				int noOfShares = (int) (amount / sharePrice);
				int orginalNoOfShare = tempNode.getKey().getNumberOfShares();
				tempNode.getKey().setNumberOfShares(noOfShares + orginalNoOfShare);
				System.out.println(noOfShares + " shares are added to " + name);
			}
			tempNode = (MyNode<Stock>) tempNode.getNext();
		}
		if (tempNode != null && tempNode.getNext() == null && tempNode.getKey().getName().equals(name)) {
			double sharePrice = tempNode.getKey().getSharePrice();
			int noOfShares = (int) (amount / sharePrice);
			int orginalNoOfShare = tempNode.getKey().getNumberOfShares();
			tempNode.getKey().setNumberOfShares(noOfShares + orginalNoOfShare);
			System.out.println(noOfShares + " shares are added to " + name);
		}
	}

	public void sell(int amount, String name) {
		MyNode<Stock> tempNode = (MyNode<Stock>) stocksList.head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().getName().equals(name)) {
				double sharePrice = tempNode.getKey().getSharePrice();
				int noOfShares = (int) (amount / sharePrice);
				int orginalNoOfShare = tempNode.getKey().getNumberOfShares();
				int sell = orginalNoOfShare - noOfShares;
				if (sell > 0) {
					tempNode.getKey().setNumberOfShares(sell);
					System.out.println(noOfShares + " shares are sold from " + name);
				} else {
					System.out.println("You have not enough shares");
				}
			}
			tempNode = (MyNode<Stock>) tempNode.getNext();
		}
		if (tempNode != null && tempNode.getNext() == null && tempNode.getKey().getName().equals(name)) {
			double sharePrice = tempNode.getKey().getSharePrice();
			int noOfShares = (int) (amount / sharePrice);
			int orginalNoOfShare = tempNode.getKey().getNumberOfShares();
			int sell = orginalNoOfShare - noOfShares;
			if (sell > 0) {
				tempNode.getKey().setNumberOfShares(sell);
				System.out.println(noOfShares + " shares are sold from " + name);
			} else {
				System.out.println("You have not enough shares");
			}
		}
	}
}
