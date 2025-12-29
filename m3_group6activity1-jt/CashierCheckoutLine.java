package m3_group6activity1;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class CashierCheckoutLine {
			
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		double totalBill = 0.0;		
		Queue<Product> queue1 = new LinkedList<>();
		
		initializeProductQueue(queue1);
				
		String choice;
		
		//Main Menu
		do {
			displayMenu();					
			//Get user input for chosen option from the menu
			choice = sc.nextLine();
			
			switch (choice.trim()) {
				case "1":
					addProduct(queue1, sc);
					break;
				case "2":
					totalBill = processProduct(queue1, totalBill);
					break;
				case "3":
					checkQueue(queue1);
					break;
				case "4":
					viewTotalBill(totalBill);
					break;
				case "5":
					exitProgram(totalBill);
					break;
				default:
					System.out.println("Invalid choice. Only options are 1 - 5.\n");
			}
		} while (!choice.equals("5"));
		
		sc.close();
	}
	

	//5 Initial products	
	public static void initializeProductQueue(Queue<Product> queue) {
		queue.add(new Product("Headphones", 500.00));
		queue.add(new Product("Keyboard", 600.00));
		queue.add(new Product("Monitor", 2500.00));
		queue.add(new Product("Mouse", 900.00));
		queue.add(new Product("USB flash drive", 400.00));
	}
	
	//Display Menu
	public static void displayMenu() {
		System.out.println("==== CHECKOUT MENU ====");
		System.out.println("1. Add Product");
		System.out.println("2. Process next product");
		System.out.println("3. Check number of products");
		System.out.println("4. View total bill");
		System.out.println("5. Exit");
		System.out.println("Enter Choice (1-5): ");
	}
	
	//Add Product
	//Adds new product at the end of queue
	public static void addProduct(Queue<Product> queue, Scanner sc) {
		System.out.println("Enter product name: ");
		String name = sc.nextLine();
		
		double price = getValidPrice(sc);
		queue.add(new Product(name, price));
		
		System.out.println("Product added to queue.");
		System.out.println("");
		
	}
	
	public static double processProduct(Queue<Product> queue, double totalBill) {
		//Check if queue is empty
		if (queue.isEmpty()) {
			System.out.println("Queue is empty. No product to process.");
			System.out.println("");
			return totalBill;
		}
		
		Product product = queue.poll(); //FIFO 
		totalBill += product.getPrice();
		//Update total bill
		System.out.println("Processed product: " + product.getName() + "   Price: " +  printWith2Decimals(product.getPrice()));
		System.out.println("Updated total bill: " + printWith2Decimals(totalBill));
		System.out.println("");
		return totalBill;
	}
	
	//Displays the number of products in queue
	public static void checkQueue(Queue<Product> queue) {
		System.out.println("Products waiting in queue: " + queue.size());
		System.out.println("");
	}
	//Displays total bill of all processed products
	public static void viewTotalBill(double totalBill) {
		System.out.println("Total bill so far: " + printWith2Decimals(totalBill));
		System.out.println("");
	}
	//Exit and displays the total final bill
	public static void exitProgram(double totalBill) {
		System.out.println("Closing Cashier line...");
		System.out.println("Final total bill: " + printWith2Decimals(totalBill));
	}
	
	//Validation for Product price
	//Ensure price is numeric and not negative value
	public static double getValidPrice(Scanner sc) {
		while(true) {
			System.out.println("Enter product price: ");
			if(sc.hasNextDouble()) {
				double price = sc.nextDouble();
				//This consumes the newline special character
				sc.nextLine();
				if (price >= 0) {
					return price;
				}
				System.out.println("Price must not be negative.");
			} else {
				System.out.println("Invalid input. Enter valid price. ");
				//This consumes the invalid input including the newline special character
				sc.nextLine();
			}
		}
	}
	
	public static String printWith2Decimals(double d) {
		return String.format("%.2f", d);
	}
	
}

