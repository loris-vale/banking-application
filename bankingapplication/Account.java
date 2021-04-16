package bankingapplication;

import java.util.Scanner;

public class Account {

	private int balance;
	private int previousTransaction;
	private String cityResidence;
	private String customerName;
	private String customerID;
	private static int id = 10000;
	private static String idPrefix = "";
	
	
	public Account() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your full name: ");
		this.customerName = in.nextLine();
		System.out.println("Enter your District of Residence (Continental Portugal): ");
		this.cityResidence = in.nextLine();
		switch(cityResidence) {
		case "Aveiro":
			idPrefix = "AR";
			break;
		case "Beja":
			idPrefix = "BJ";
			break;
		case "Braga":
			idPrefix = "BR";
			break;
		case "Bragança":
			idPrefix = "BG";
			break;
		case "Castelo Branco":
			idPrefix = "CB";
			break;
		case "Coimbra":
			idPrefix = "CM";
			break;
		case "Évora":
			idPrefix = "EV";
			break;
		case "Faro":
			idPrefix = "FR";
			break;
		case "Guarda":
			idPrefix = "GD";
			break;
		case "Leiria":
			idPrefix = "LE";
			break;
		case "Lisboa":
			idPrefix = "LS";
			break;
		case "Portalegre":
			idPrefix = "PA";
			break;
		case "Porto":
			idPrefix = "PO";
			break;
		case "Santarém":
			idPrefix = "SM";
			break;
		case "Setúbal":
			idPrefix = "ST";
			break;
		case "Viana do Castelo":
			idPrefix = "VC";
			break;
		case "Vila Real":
			idPrefix = "VR";
			break;
		case "Viseu":
			idPrefix = "VS";
			break;
		}
		setCustomerId();
	}
	
	private void setCustomerId() {
		id++;
		this.customerID = (idPrefix + "" + id);
	}
	
	public void deposit(int amount) {
		if (amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}
	
	public void withdraw(int amount) {
		if (amount != 0) {
			balance -= amount;
			previousTransaction = amount;
		}
	}
	
	public void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction + "€");
		} else if (previousTransaction < 0) {
			System.out.println("Withdrawn: " + previousTransaction + "€");
		} else {
			System.out.println("No transaction occurred");
		}
	}
	
	public void calculateInterest(int years) {
		double interestRate = 0.0185;
		double newBalance = balance + (balance * (Math.pow((1 + interestRate), years) - 1));
		//double newBalance = (balance * interestRate * years) + balance;
		System.out.println("The current interestrate is: " + (100 * interestRate));
		System.out.println("After " + years + " years, your balance will be: " + newBalance + "€");
	}
	
	public void showMenu() {
		char option = '\0';
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome, " + customerName);
		System.out.println("Your ID is: " + customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawal");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = in.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			case 'A':
				System.out.println("=============================");
				System.out.println("Balance: " + balance + "€");
				System.out.println("=============================");
				System.out.println();
				break;
			case 'B':
				System.out.println("Enter an amount to deposit: ");
				int amount = in.nextInt();
				deposit(amount);
				System.out.println();
				break;
			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				int amount2 = in.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
			case 'D':
				System.out.println("====================================");
				getPreviousTransaction();
				System.out.println("====================================");
				System.out.println();
				break;
			case 'E':
				System.out.println("Enter how many years of accrued interest: ");
				int years = in.nextInt();
				calculateInterest(years);
				break;
			case 'F':
				System.out.println("====================================");
				break;
			default:
				System.out.println("Error: invalid option. Please enter A, B, C, D, or E or access services.");
				break;
			}
		} while(option != 'F');
		System.out.println("Thank you for banking with us!");
	}
}
