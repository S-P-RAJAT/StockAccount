package com.bridgelabz.stockaccountmanagement;

import com.bridgelabz.linkedlist.MyLinkedList;
import java.util.Scanner;


public class StockAccountManagementMain {
	
	public static final Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {
	StockAccountManagement manager = new StockAccountManagement();
	int choice;
	do {
		System.out.println("\n1.Buy a share \n2.Sell a share \n3.Display shares \n4.Delete shares \n5.Exit");
		choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
		
		case 1:
			manager.buyShare();
			break;
		case 2:
			manager.sellShare();
			break;
			
		case 3:
			manager.printReport();
			break;
			
		case 4:
			manager.deleteShare();
			break;
		case 5:
			break;
			
		default:
			System.out.println("Choose correct option from above mentioned option only!!");
			break;
		}
	} while (choice != 5);
	}
}
