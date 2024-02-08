package com.ecommerce;

public class ProductClass {
    private int productID;
    private String name;
    private double price;

    // Constructors
    public ProductClass(int productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    // Default constructor (if needed)
    public ProductClass() {
        // Initialize default values or leave empty based on your requirements
    }

    // Getter for productID
    public int getProductID() {
        return productID;
    }

    // Setter for productID
    public void setProductID(int productID) {
        this.productID = productID;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    // Other methods

    // Method to display information about the product
    @Override
    public String toString() {
        return "Product Information: " +
                "ProductID=" + productID +
                ", Name='" + name + '\'' +
                ", Price=$" + price;
    }
}
