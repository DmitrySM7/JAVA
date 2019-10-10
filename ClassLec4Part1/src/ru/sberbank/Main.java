package ru.sberbank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        CountMapClass tom = new CountMapClass();
        System.out.println(tom.size());
        tom.add(1);
        tom.add(2);
        tom.add(3);
        tom.add(2);
        tom.add(2);
        System.out.println(tom.toMap());
        System.out.println(tom.getCount(2));
        System.out.println(tom.remove(3));
        System.out.println(tom.toMap());
        tom.add(3);
        System.out.println(tom.toMap());
        System.out.println(tom.getCount(3));
        System.out.println(tom.size());

        //HashMap<K, Integer> jerry = new HashMap<K, Integer>();
    }
}
