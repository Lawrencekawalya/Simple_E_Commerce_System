package com.ecommerce;

public class CustomerClass {
    private int customerID;
    private String name;
    private ShoppingCart shoppingCart;

    // Constructors
    public CustomerClass(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.shoppingCart = new ShoppingCart();
    }

    // Default constructor (if needed)
    public CustomerClass() {
        // Initialize default values or leave empty based on your requirements
    }

    // Getter for customerID
    public int getCustomerID() {
        return customerID;
    }

    // Setter for customerID
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for shoppingCart
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    // Setter for shoppingCart (if needed)
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    // Other methods

    // Method to display information about the customer
    @Override
    public String toString() {
        return /*"Customer Information: " +*/
                "CustomerID=" + customerID +
                ", Name='" + name + '\'' +
                ", ShoppingCart=" + shoppingCart;
    }
}
