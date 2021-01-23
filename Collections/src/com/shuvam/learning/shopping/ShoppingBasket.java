package com.shuvam.learning.shopping;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingBasket {
    private final String name;
    private final Map<StockItem, Integer> basket;

    public ShoppingBasket(String name) {
        this.name = name;
        // Makes the items sorted in alphabetical order, using compareTo method on the key object of this map
        this.basket = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if (item!= null && quantity > 0) {
            int inBasket = basket.getOrDefault(item, 0);
            inBasket += quantity;
            basket.put(item, inBasket);
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if(item != null && quantity > 0) {
            int inBasket = basket.getOrDefault(item, 0);
            int newQuantity = inBasket - quantity;

            if (newQuantity > 0) {
                basket.put(item, newQuantity);
                return quantity;
            } else if (newQuantity == 0) {
                basket.remove(item);
                return quantity;
            }
        }
        return 0;
    }

    public void clearBasket() {
        // Easier then removing all items one by one
        this.basket.clear();
    }

    public String getName() {
        return name;
    }

    public Map<StockItem, Integer> getBasket() {
        return Collections.unmodifiableMap(basket);
    }

    public double computeBasketValue() {
        double totalCost = 0.0;
        for(Map.Entry<StockItem, Integer> item : basket.entrySet()) {
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return totalCost;
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + basket.size() + " types of items\n";
        double totalCost = 0.0;
        for(Map.Entry<StockItem, Integer> item : basket.entrySet()) {
            s += item.getKey() + ", " + item.getValue() + " added\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total stock value " + String.format("%.2f", totalCost);
    }
}
