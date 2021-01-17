package com.shuvam.learning;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock = 0; // can be initialized here

    public StockItem(String name, double price) {
        this(name, price, 0);
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock; // or here (but wouldn't normally be done in both)
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

    public int getQuantityStock() {
        return quantityStock;
    }

    public void adjustStock(int quantityStock) {
        int newQuantity = this.quantityStock + quantityStock;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
        }
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
        System.out.println("Entering StockItem.compareTo");
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
        return this.name + ": price = " + this.price;
    }
}
