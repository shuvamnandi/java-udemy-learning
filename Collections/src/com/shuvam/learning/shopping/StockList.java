package com.shuvam.learning.shopping;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if(item != null) {
            // Get an item if it already exists in the map, and if it doesn't exist its going to
            // use this item that we actually pass to this method, as the item is going to be in stock (default).
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // Check if we already have quantity of this item, in that case, adjust the quantity
            if (inStock != item) {
                item.adjustStock(inStock.getQuantityAvailable());
            }
            list.put(item.getName(), item);
            return item.getQuantityAvailable();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
//        StockItem inStock = list.getOrDefault(item, null);
//        if ((inStock !=null) && (inStock.getQuantityAvailable() >= quantity) && (quantity > 0 )) {
//            inStock.adjustStock(-quantity);
//            return quantity;
//        }
//        return 0;
        StockItem inStock = list.get(item);
        if(inStock != null && quantity > 0) {
            return inStock.finaliseStock(quantity);
        }
        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItem itemInStock = list.get(item);
        if (itemInStock != null && quantity > 0 ) {
            return itemInStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unreserveStock(String item, int quantity) {
        StockItem itemInStock = list.get(item);
        if (itemInStock != null && quantity > 0 ) {
            return itemInStock.unreserveStock(quantity);
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item: list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        // return a map that cannot be modified further
        // provides a Read-Only view of the Map
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item: list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.getQuantityAvailable();
            s += stockItem + ". There are " + stockItem.getQuantityAvailable() + " in stock. Value of items: ";
            s += String.format("%.2f", itemValue) + " \n";
            totalCost += itemValue;
        }
        return s + " Total stock value " + String.format("%.2f", totalCost);
    }
}
