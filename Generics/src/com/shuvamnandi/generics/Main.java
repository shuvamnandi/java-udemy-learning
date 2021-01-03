package com.shuvamnandi.generics;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        // error would come up in printDoubled method, which Java cannot detect until runtime
        //items.add("Tim");
        items.add(3);
        items.add(4);
        printDoubled(items);
    }

    private static void printDoubled(List<Integer> n){
        for(int i: n) {
            System.out.println(i*2);
        }
    }
}
