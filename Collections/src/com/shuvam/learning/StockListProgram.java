package com.shuvam.learning;

public class StockListProgram {
    /*
    There are variants of the HashMap and HashSet classes, called LinkedHashMap and LinkedHashSet. The real difference
    in these variants is that they have got an ordering incorporated in them. The Oracle documentation states that the
    ordering of items in a HashMap or HashSet is chaotic but the linked versions maintain insertion order.
     */
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread", 0.86 , 100);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 1.1 , 70);
        stockList.addStock(temp);

        temp = new StockItem("Car", 12.5 , 8);
        stockList.addStock(temp);

        temp = new StockItem("Chair", 5.2 , 10);
        stockList.addStock(temp);

        temp = new StockItem("Cup", 0.51 , 120);
        stockList.addStock(temp);

        temp = new StockItem("Juice", 3.1 , 20);
        stockList.addStock(temp);

        temp = new StockItem("Phone", 8.7 , 30);
        stockList.addStock(temp);

        temp = new StockItem("Towel", 2.3 , 60);
        stockList.addStock(temp);

        temp = new StockItem("Vase", 7.2 , 15);
        stockList.addStock(temp);

        System.out.println(stockList);
    }

}
