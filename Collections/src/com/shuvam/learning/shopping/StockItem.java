package com.shuvam.learning.shopping;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock = 0; // can be initialized here
    private int reserved = 0;

    public StockItem(String name, double price) {
        this(name, price, 0);
    }

    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock; // or here (but wouldn't normally be done in both)
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    // Can use the same name as the instance variable
    public int getQuantityAvailable() {
        return quantityInStock - reserved;
    }

    public void adjustStock(int quantityStock) {
        int newQuantity = this.quantityInStock + quantityStock;
        if (newQuantity >= 0) {
            this.quantityInStock = newQuantity;
        }
    }

    public int reserveStock(int quantityToReserve) {
        if (quantityToReserve <= getQuantityAvailable()) { // Using the getQuantityAvailable method, not the field
            this.reserved += quantityToReserve;
            return quantityToReserve;
        }
        return 0;
    }

    public int unreserveStock(int quantityToUnreserve) {
        if (quantityToUnreserve<=this.reserved){
            this.reserved -= quantityToUnreserve;
            return quantityToUnreserve;
        }
        return 0;
    }

    public int finaliseStock(int quantity) {
        if (quantity <= reserved) {
            reserved -= quantity;
            quantityInStock -= quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 39;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if (obj == this) {
            return true;
        }

        if((obj == null) || (obj.getClass() != this.getClass())){
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int compareTo(StockItem o) {
        // System.out.println("Entering StockItem.compareTo");
        if (this == o) {
            return 0;
        }

        if(o!=null) {
            return this.name.compareTo(o.getName());
        }
        // Added implementation of compareTo method, which throws a NullPointerException if a null value is compared to this object
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": price = " + this.price + ". Reserved: " + this.reserved;
    }
}
