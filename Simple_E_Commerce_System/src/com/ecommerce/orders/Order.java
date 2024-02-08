package com.ecommerce.orders;

import com.ecommerce.CustomerClass;
import com.ecommerce.ProductClass;

import java.util.List;

public class Order {
    private int orderID;
    private CustomerClass customer;
    private List<ProductClass> products;
    private double orderTotal;
    private String orderStatus;

    // Constructors
    public Order(int orderID, CustomerClass customer, List<ProductClass> products, String orderStatus) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = products;
        this.orderStatus = orderStatus;
        calculateOrderTotal();
    }

    // Default constructor (if needed)
    public Order() {
        // Initialize default values or leave empty based on your requirements
    }

    // Getter for orderID
    public int getOrderID() {
        return orderID;
    }

    // Setter for orderID
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    // Getter for customer
    public CustomerClass getCustomer() {
        return customer;
    }

    // Setter for customer
    public void setCustomer(CustomerClass customer) {
        this.customer = customer;
    }

    // Getter for products
    public List<ProductClass> getProducts() {
        return products;
    }

    // Setter for products
    public void setProducts(List<ProductClass> products) {
        this.products = products;
        calculateOrderTotal();
    }

    // Getter for orderTotal
    public double getOrderTotal() {
        return orderTotal;
    }

    // Getter and Setter for orderStatus
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // Method to generate order summaries
    public String generateOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order ID: ").append(orderID).append("\n");
        summary.append("Customer: ").append(customer.getName()).append("\n");
        summary.append("Products: ").append(products).append("\n");
        summary.append("Order Total: $").append(orderTotal).append("\n");
        summary.append("Order Status: ").append(orderStatus).append("\n");
        return summary.toString();
    }

    // Method to update order status
    public void updateOrderStatus(String newStatus) {
        orderStatus = newStatus;
    }

    // Method to calculate the total cost of the order
    private void calculateOrderTotal() {
        orderTotal = 0.0;
        for (ProductClass product : products) {
            orderTotal += product.getPrice();
        }
    }
}
