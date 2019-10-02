package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    private static void testMyHashMap(int count) {
        Random r = new Random();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
             nums.add(r.nextInt());
        }
    }

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> m = new MyHashMap<>(5);

        for (int i = 0; i < 10; ++i) {
            m.put(i * 3, i * 7);
        }

        System.out.println(" Before remove -".repeat(5));
        System.out.println(m.size());
        m.printVals();
        for (int i = 0; i < 5; ++i) {
            m.remove(i * 3);
        }
        System.out.println(" After remove -".repeat(5));
        System.out.println(m.size());
        m.printVals();
        for (int i = 5; i < 10; ++i) {
            System.out.println(m.contains(i * 3));
        }
        System.out.println(m.size());

    }
}
