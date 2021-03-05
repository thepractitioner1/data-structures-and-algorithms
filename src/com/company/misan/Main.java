package com.company.misan;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList list = new LinkedList();
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        var arraya = list.toArray();
        System.out.println(Arrays.toString(arraya));
        list.reverse();
        var array = list.toArray();
        System.out.println(Arrays.toString(array));

    }
}
