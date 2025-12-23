/**
 * 
 */
package m3_group6act1;
import java.util.Scanner;
/**
 * 
 */
public class Cashier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product.initialProduct();
		
		Scanner sc = new Scanner(System.in);
		int choice;
		//Main menu
		do {
			Product.displayMenu();
		//Validate input
		while (!sc.hasNextInt()) {
			System.out.println("Invalid Input. Enter a number: ");
			sc.next();
		}
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			Product.addProduct();
			break;
		case 2:
			Product.processProduct();
			break;
		case 3:
			Product.checkQueue();
			break;
		case 4:
			Product.viewTotalBill();
			break;
		case 5:
			Product.exitProgram();
			break;
		default:
			System.out.println("Invalid choice.");
		}
		} while (choice != 5);
		
		sc.close();
		}
	}

