package com.shuvam.learning.shopping;

import java.util.Map;

public class StockListProgram {
    /*
    There are variants of the HashMap and HashSet classes, called LinkedHashMap and LinkedHashSet. The real difference
    in these variants is that they have got an ordering incorporated in them. The Oracle documentation states that the
    ordering of items in a HashMap or HashSet is chaotic but the linked versions maintain insertion order.
     */
    private static StockList stockList = new StockList();
    private static final ShoppingBasket shuvamBasket = new ShoppingBasket("Shuvam's Basket");
    private static final ShoppingBasket neethuBasket = new ShoppingBasket("Neethu's basket");

    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread", 0.86 , 100);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 1.1 , 70);
        stockList.addStock(temp);

        temp = new StockItem("Car", 12.5 , 2);
        stockList.addStock(temp);

        temp = new StockItem("Chair", 5.2 , 10);
        stockList.addStock(temp);

        temp = new StockItem("Cup", 0.51 , 120);
        stockList.addStock(temp);
        temp = new StockItem("Cup", 0.45 , 10);
        stockList.addStock(temp);

        temp = new StockItem("Juice", 3.1 , 20);
        stockList.addStock(temp);

        temp = new StockItem("Phone", 8.7 , 30);
        stockList.addStock(temp);

        temp = new StockItem("Towel", 2.3 , 60);
        stockList.addStock(temp);

        temp = new StockItem("Vase", 7.2 , 15);
        stockList.addStock(temp);

        // Order of insertion is retained when we print out the map items
        // or keys of the LinkedHashMap
        System.out.println(stockList);
        for (String key: stockList.Items().keySet()){
            System.out.println(key);
        }

        sellItem(shuvamBasket, "Car", 1);
        System.out.println(shuvamBasket);

        sellItem(shuvamBasket, "Car", 1);
        System.out.println(shuvamBasket);

        sellItem(shuvamBasket, "Car", 2);
        System.out.println(shuvamBasket);

        sellItem(shuvamBasket, "Spanner", 1);
        System.out.println(shuvamBasket);

        sellItem(shuvamBasket, "Juice", 5);
        System.out.println(shuvamBasket);

        sellItem(shuvamBasket, "Cup", 12);
        System.out.println(shuvamBasket);

        sellItem(shuvamBasket, "Bread", 2);
        System.out.println(shuvamBasket);

        sellItem(shuvamBasket, "Towel", 1);
        System.out.println(shuvamBasket);

        System.out.println(stockList);
        // stockList.Items().put(temp.getName(), temp); // throws an UnsupportedOperationException

        // Individual objects inside the map can still be accessed and modified, with two different ways of accessing the Car item
        // stockList.Items().get("Car").adjustStock(2000);
        // stockList.get("Car").adjustStock(-1000);
        // System.out.println(stockList);

        // Both String and Double are immutable
        // for(Map.Entry<String, Double> priceEntry: stockList.PriceList().entrySet()) {
        //     System.out.println(priceEntry.getKey() + " costs " + priceEntry.getValue());
        // }
        System.out.println("================================");
        sellItem(neethuBasket, "Cup", 100);
        sellItem(neethuBasket, "Chair", 3);
        removeItem(neethuBasket, "Cup", 1);
        sellItem(neethuBasket, "Cup", 1);
        System.out.println(neethuBasket);

        removeItem(shuvamBasket, "Car", 1);
        removeItem(shuvamBasket, "Cup", 9);
        removeItem(shuvamBasket, "Car", 1);
        System.out.println("Cars removed: " + removeItem(shuvamBasket, "Car", 1)); // Should not remove any

        System.out.println(shuvamBasket);

        removeItem(shuvamBasket, "Bread", 2);
        removeItem(shuvamBasket, "Cup", 3);
        removeItem(shuvamBasket, "Juice", 5);
        removeItem(shuvamBasket, "Cup", 1);
        removeItem(shuvamBasket, "Towel", 1);

        System.out.println(shuvamBasket); // should be empty

        System.out.println("\nDisplay stock list before and after checkout");

        System.out.println(neethuBasket);
        System.out.println(stockList);
        checkoutBasket(neethuBasket);
        System.out.println(neethuBasket);
        System.out.println(stockList);

        System.out.println(shuvamBasket);

    }

    public static int sellItem(ShoppingBasket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0) {
            int quantityAdded = basket.addToBasket(stockItem, quantity);
            System.out.println("Item " + item + " added to shopping basket. Quantity in basket: " + quantityAdded);
            return quantityAdded;
        } else {
            System.out.println("Stock finished. Item " + item + " could not be added to shopping basket. Quantity in basket: " + quantity);
        }
        return 0;
    }

    public static int removeItem(ShoppingBasket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            int quantityRemoved = stockList.unreserveStock(item, quantity);
            System.out.println("Item " + item + " removed from shopping basket. Quantity removed: " + stockItem);
            return quantityRemoved;
        } else {
            System.out.println("Stock finished. Item " + item + " could not be added to shopping basket. Quantity in basket: " + quantity);
        }
        return 0;
    }

    public static void checkoutBasket(ShoppingBasket basket) {
        System.out.println("\nTotal amount to be paid: " + basket.computeBasketValue());
        for (Map.Entry<StockItem, Integer> item: basket.getBasket().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }

}
