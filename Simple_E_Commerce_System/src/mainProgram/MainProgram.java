package mainProgram;

import com.ecommerce.*;
import com.ecommerce.orders.Order;

import java.util.Scanner;

public class MainProgram {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    // Get user input for customer
	    System.out.println("Enter Customer's ID: ");
	    int customerID = scanner.nextInt();
	    scanner.nextLine(); // Consume the newline character
	    System.out.println("Enter Customer's Name: ");
	    String customerName = scanner.nextLine();

	    // Create instance of customer with user input
	    CustomerClass customer = new CustomerClass(customerID, customerName);

	    // Display welcome message
	    System.out.println("Dear esteemed customer, " + customerName + ", welcome to our E-commerce System!");
	    System.out.println("Please take a look at all products we have. "
	    		+ "Enter the product ID to add it to your order.");

	    // Display all products in the system
	    displayAllProducts();

	    // Allow the customer to make an order
	    makeOrder(customer, scanner);

	    // Display information about the customer's order
	    System.out.println("\nYour Selected items:\n" + customer.getShoppingCart().toString());

	    // Ask the customer if they want to proceed with the order or cancel
	    System.out.println("Do you want to proceed with the order? (Enter 'Y' for Yes, 'N' for No): ");
	    String userChoice = scanner.nextLine();

	    if (userChoice.equalsIgnoreCase("Y")) {
	        // Proceed with the order
	        processOrder(customer);
	    } else {
	        // Cancel the order
	        System.out.println("Thank you for coming!");
	    }

	    // Close the scanner
	    scanner.close();
	}

	private static void makeOrder(CustomerClass customer, Scanner scanner) {
	    int selectedProductID;

	    // Allow the customer to add products to the order
	    do {
	        System.out.println("\nEnter the Product ID to add to your shopping cart (enter 0 to finish): ");
	        selectedProductID = scanner.nextInt();

	        // Consume the newline character
	        scanner.nextLine();

	        // Check if the selected product ID is valid
	        if (selectedProductID > 0) {
	            // Add the selected product to the customer's order
	            ProductClass selectedProduct = getProductById(selectedProductID);
	            if (selectedProduct != null) {
	                customer.getShoppingCart().addProduct(selectedProduct);
	                System.out.println("Product added to your order: " + selectedProduct.toString());
	            } else {
	                System.out.println("Invalid Product ID. Please try again.");
	            }
	        }
	    } while (selectedProductID != 0);
	}

    private static void displayAllProducts() {
        System.out.println("\nAvailable Products:");

        // Create instances of products
        ProductClass laptop = new ProductClass(1, "Laptop", 899.99);
        ProductClass smartphone = new ProductClass(2, "Smartphone", 499.99);

        // Display information about products
        System.out.println("Product Information: " + laptop.toString());
        System.out.println("Product Information: " + smartphone.toString());
    }

        private static ProductClass getProductById(int productID) {
        // For simplicity, this method returns a product based on a hardcoded list.
        // In a real application, you might want to fetch product information from a database.
        switch (productID) {
            case 1:
                return new ProductClass(1, "Laptop", 899.99);
            case 2:
                return new ProductClass(2, "Smartphone", 499.99);
            default:
                return null;
        }
    }
    
    private static void processOrder(CustomerClass customer) {
        // Create an instance of Order
        int orderID = generateOrderID(); // You can implement this method to generate a unique order ID
        Order order = new Order(orderID, customer, customer.getShoppingCart().getProducts(), "Processing");

        // Display the order summary
        System.out.println("\nOrder Summary:\n" + order.generateOrderSummary());
    }
    
    private static int generateOrderID() {
        // For simplicity, this method generates a random order ID.
        // In a real application, you might want to implement a more sophisticated logic.
        return (int) (Math.random() * 1000);
    }
    
}
