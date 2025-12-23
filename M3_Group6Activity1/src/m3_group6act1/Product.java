package m3_group6act1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Product {

	
	private String name;
	private double price;
	
	private static Queue<Product> queue = new LinkedList<>();
	private static double totalBill = 0.0;
	private static Scanner sc = new Scanner(System.in);
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	
	//5 Initial products	
	public static void initialProduct() {
		queue.add(new Product("Headphones", 500.00));
		queue.add(new Product("Keyboard", 600.00));
		queue.add(new Product("Monitor", 2500.00));
		queue.add(new Product("Mouse", 900.00));
		queue.add(new Product("USB", 400.00));
	}
	
	//Display Menu
	public static void displayMenu() {
		System.out.println("==== CHECKOUT MENU ====");
		System.out.println("1. Add Product");
		System.out.println("2. Process next product");
		System.out.println("3. Check number of products");
		System.out.println("4. View total bill");
		System.out.println("5. Exit");
		System.out.println("Enter Choice: ");
	}
	
	//Add Product
	//Adds new product at the end of queue
	public static void addProduct() {
		System.out.println("Enter product name: ");
		String name = sc.nextLine();
		
		double price = getValidPrice();
		queue.add(new Product(name, price));
		
		System.out.println("Product added to queue.");
		
	}
	
	public static void processProduct() {
		//Check if queue is empty
		if (queue.isEmpty()) {
			System.out.println("Queue is empty. No product to process.");
			return;
		}
		
		Product product = queue.poll(); //FIFO 
		totalBill += product.getPrice();
		//Update total bill
		System.out.println("Processed product: " + product.getName() + "Price: " + product.getPrice());
		System.out.println("Updated total bill: " + totalBill);
	}
	
	//Displays the number of products in queue
	public static void checkQueue() {
		System.out.println("Products waiting in queue: " + queue.size());
	}
	//Displays total bill of all processed products
	public static void viewTotalBill() {
		System.out.println("Total bill so far: " + totalBill);
	}
	//Exit and displays the total final bill
	public static void exitProgram() {
		System.out.println("Closing Cashier line...");
		System.out.println("Final total bill: " + totalBill);
		sc.close();
	}
	
	//Validation for Product price
	//Ensure price is numeric and not negative value
	private static double getValidPrice() {
		while(true) {
			System.out.println("Enter product price: ");
			if(sc.hasNextDouble()) {
				double price = sc.nextDouble();
				if (price > 0) {
					return price;
				}
				System.out.println("Price must be greater than 0.");
			} else {
				System.out.println("Invalid input. Enter valid price: ");
				sc.next();
			}
		}
	}
}
