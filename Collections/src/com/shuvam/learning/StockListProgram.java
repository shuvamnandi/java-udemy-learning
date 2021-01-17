package com.shuvam.learning;

import java.util.Map;

public class StockListProgram {
    /*
    There are variants of the HashMap and HashSet classes, called LinkedHashMap and LinkedHashSet. The real difference
    in these variants is that they have got an ordering incorporated in them. The Oracle documentation states that the
    ordering of items in a HashMap or HashSet is chaotic but the linked versions maintain insertion order.
     */
    private static StockList stockList = new StockList();
    private static ShoppingBasket basket = new ShoppingBasket("Shuvam's Basket");

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

        sellItem(basket, "Car", 1);
        System.out.println(basket);

        sellItem(basket, "Car", 1);
        System.out.println(basket);

        sellItem(basket, "Car", 2);
        System.out.println(basket);

        sellItem(basket, "Spanner", 1);
        System.out.println(basket);

        sellItem(basket, "Juice", 5);
        System.out.println(basket);

        sellItem(basket, "Cup", 12);
        System.out.println(basket);

        sellItem(basket, "Bread", 2);
        System.out.println(basket);

        sellItem(basket, "Towel", 1);
        System.out.println(basket);

        System.out.println(stockList);
        // stockList.Items().put(temp.getName(), temp); // throws an UnsupportedOperationException

        // Individual objects inside the map can still be accessed and modified, with two different ways of accessing the Car item
        stockList.Items().get("Car").adjustStock(2000);
        stockList.get("Car").adjustStock(-1000);
        System.out.println(stockList);

        // Both String and Double are immutable
        for(Map.Entry<String, Double> priceEntry: stockList.PriceList().entrySet()) {
            System.out.println(priceEntry.getKey() + " costs " + priceEntry.getValue());
        }
    }

    public static int sellItem(ShoppingBasket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            System.out.println("Item " + item + " added to shopping basket. Quantity in basket: " + quantity);
            return quantity;
        } else {
            System.out.println("Stock finished. Item " + item + " could not be added to shopping basket. Quantity in basket: " + quantity);
        }
        return 0;
    }

}
