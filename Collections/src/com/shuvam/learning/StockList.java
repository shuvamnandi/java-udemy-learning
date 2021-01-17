package com.shuvam.learning;

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
                item.adjustStock(inStock.getQuantityStock());
            }
            list.put(item.getName(), item);
            return item.getQuantityStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock !=null) && (inStock.getQuantityStock() >= quantity) && (quantity > 0 )) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
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
            double itemValue = stockItem.getPrice() * stockItem.getQuantityStock();
            s += stockItem + ". There are " + stockItem.getQuantityStock() + " in stock. Value of items: ";
            s += String.format("%.2f", itemValue) + " \n";
            totalCost += itemValue;
        }
        return s + " Total stock value " + String.format("%.2f", totalCost);
    }
}
