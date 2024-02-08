package mainProgram;

import com.ecommerce.*;
import com.ecommerce.orders.Order;

import java.util.ArrayList;
import java.util.List;

public class MainProgram {
    public static void main(String[] args) {
        // Create instances of products
        ProductClass laptop = new ProductClass(1, "Laptop", 899.99);
        ProductClass smartphone = new ProductClass(2, "Smartphone", 499.99);

        // Create instances of customers
        CustomerClass customer1 = new CustomerClass(101, "John Doe");
        CustomerClass customer2 = new CustomerClass(102, "Jane Smith");

        // Create instances of orders
        List<ProductClass> order1Products = new ArrayList<>();
        order1Products.add(laptop);
        order1Products.add(smartphone);
        Order order1 = new Order(201, customer1, order1Products, "Processing");

        List<ProductClass> order2Products = new ArrayList<>();
        order2Products.add(smartphone);
        Order order2 = new Order(202, customer2, order2Products, "Shipped");

        // Demonstrate the functionality of the e-commerce system
        customer1.getShoppingCart().addProduct(laptop);
        customer1.getShoppingCart().addProduct(smartphone);

        // Display information about products, customers, and orders
        System.out.println("Product Information: " + laptop.toString());
        System.out.println("Product Information: " + smartphone.toString());
        System.out.println("Customer Information: " + customer1.toString());
        System.out.println("Order Information: " + order1.generateOrderSummary());

        System.out.println("\nCustomer Information: " + customer2.toString());
        System.out.println("Order Information: " + order2.generateOrderSummary());
    }
}
