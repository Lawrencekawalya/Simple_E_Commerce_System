package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ProductClass> products;

    // Constructor
    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    // Method to add a product to the shopping cart
    public void addProduct(ProductClass product) {
        products.add(product);
    }

    // Method to remove a product from the shopping cart
    public void removeProduct(ProductClass product) {
        products.remove(product);
    }

    // Method to clear all products from the shopping cart
    public void clearCart() {
        products.clear();
    }

    // Method to get the list of products in the shopping cart
    public List<ProductClass> getProducts() {
        return products;
    }

    // Method to calculate the total cost of products in the shopping cart
    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (ProductClass product : products) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    // Other methods for additional functionality

    // Method to display information about the shopping cart
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Shopping Cart Information:\n");
        result.append("Products: ");

        for (ProductClass product : products) {
            result.append("\n").append(product.toString());
        }
        
        result.append("\n------------------------------------------------\nTotal Cost: $")
        .append(calculateTotalCost()).append("\n------------------------------------------------");
//        result.append("\nTotal Cost: $").append(calculateTotalCost()).append("]");

        return result.toString();
    }

}
