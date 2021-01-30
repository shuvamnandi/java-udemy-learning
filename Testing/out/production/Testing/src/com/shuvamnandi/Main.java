package com.shuvamnandi;

public class Main {
    public static void main(String[] args) {
	// write your code here
        System.out.println("The application is running");
        Utilities utilities = new Utilities();
        System.out.println(utilities.everyNthChar("Shuvam Nandi".toCharArray(), 3));;
    }
}
