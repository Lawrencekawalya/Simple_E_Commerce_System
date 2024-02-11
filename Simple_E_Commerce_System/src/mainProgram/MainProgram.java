package mainProgram;

import com.ecommerce.*;
import com.ecommerce.orders.Order;

import java.util.Scanner;

public class MainProgram {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	 // Get user input for customer ID
	    int customerID = 0;
	    boolean validInput = false;

	    do {
	        try {
	            System.out.println("Enter Customer's ID: ");
	            customerID = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character
	            validInput = true; // Set to true if no exception is thrown
	        } catch (java.util.InputMismatchException e) {
	            System.out.println("Customer's ID... Must be an integer like this ***123***");
	            scanner.nextLine(); // Consume the invalid input
	        }
	    } while (!validInput);

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
        String userChoice;

        do {
            System.out.println("Do you want to proceed with the order? (Enter 'Y' for Yes, 'N' for No): ");
            userChoice = scanner.nextLine();

            if (!userChoice.equalsIgnoreCase("Y") && !userChoice.equalsIgnoreCase("N")) {
                System.out.println("Invalid choice. Please enter 'Y' for Yes or 'N' for No.");
            }

        } while (!userChoice.equalsIgnoreCase("Y") && !userChoice.equalsIgnoreCase("N"));

        if (userChoice.equalsIgnoreCase("Y")) {
            // Proceed with the order
            processOrder(customer);
        } else {
            // Cancel the order
        	System.out.println("\n\n*************************************************");
            System.out.println("Thank you for coming! Please come back again🤩❤️");
            System.out.println("*************************************************");
        }

	    // Close the scanner
	    scanner.close();
	}

	
	private static void makeOrder(CustomerClass customer, Scanner scanner) {
	    int selectedProductID;

	    // Allow the customer to add products to the order
	    do {
	        try {
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
	                    System.out.println("Invalid Product ID Or Product is Out of stock or Unavailable.");
	                    System.out.println("Please try again.....");
	                }
	            }
	        } catch (java.util.InputMismatchException e) {
	            System.out.println("Invalid input! Please enter a valid integer for Product ID.");
	            scanner.nextLine(); // Consume the invalid input
	            selectedProductID = -1; // Set an invalid value to repeat the loop
	        }
	    } while (selectedProductID != 0);
	}

    private static void displayAllProducts() {
        System.out.println("\nAvailable Products:");

        // Create instances of products
        ProductClass laptop = new ProductClass(1, "Laptop", 899.99);
        ProductClass smartphone = new ProductClass(2, "Smartphone", 499.99);
        ProductClass tablet = new ProductClass(3, "Tablet", 299.99);
        ProductClass headphones = new ProductClass(4, "Headphones", 79.99);
        ProductClass smartwatch = new ProductClass(5, "Smartwatch", 149.99);
        ProductClass camera = new ProductClass(6, "Camera", 599.99);
        ProductClass gamingConsole = new ProductClass(7, "Gaming Console", 399.99);

        // Display information about products
        System.out.println("Product Information: " + laptop.toString());
        System.out.println("Product Information: " + smartphone.toString());
        System.out.println("Product Information: " + tablet.toString());
        System.out.println("Product Information: " + headphones.toString());
        System.out.println("Product Information: " + smartwatch.toString());
        System.out.println("Product Information: " + camera.toString());
        System.out.println("Product Information: " + gamingConsole.toString());  
    }

        private static ProductClass getProductById(int productID) {
        // For simplicity, this method returns a product based on a hardcoded list.
        switch (productID) {
            case 1:
                return new ProductClass(1, "Laptop", 899.99);
            case 2:
                return new ProductClass(2, "Smartphone", 499.99);
            case 3:
                return new ProductClass(3, "Tablet", 299.99);
            case 4:
                return new ProductClass(4, "Headphones", 79.99);
            case 5:
                return new ProductClass(5, "Smartwatch", 149.99);
            case 6:
                return new ProductClass(6, "Camera", 599.99);
            case 7:
                return new ProductClass(7, "Gaming Console", 399.99);
            	
            default:
                return null;
        }
    }
    
    private static void processOrder(CustomerClass customer) {
        // Create an instance of Order
        int orderID = generateOrderID(); // You can implement this method to generate a unique order ID
        Order order = new Order(orderID, customer, customer.getShoppingCart().getProducts(), "Processing...");

        // Display the order summary
        System.out.println("\n\n********Order Summary**********************\n\n" + order.generateOrderSummary());
    }
    
    private static int generateOrderID() {
        //this method generates a random order ID.
        return (int) (Math.random() * 1000);
    }
    
}
