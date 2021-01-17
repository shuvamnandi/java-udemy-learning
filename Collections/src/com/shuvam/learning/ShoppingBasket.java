package com.shuvam.learning;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {
    private final String name;
    private final Map<StockItem, Integer> basket;

    public ShoppingBasket(String name) {
        this.name = name;
        this.basket = new HashMap<>();
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

    public String getName() {
        return name;
    }

    public Map<StockItem, Integer> getBasket() {
        return Collections.unmodifiableMap(basket);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + basket.size() + " items\n";
        double totalCost = 0.0;
        for(Map.Entry<StockItem, Integer> item : basket.entrySet()) {
            s += item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + " Total stock value " + String.format("%.2f", totalCost);
    }
}
