package com.company;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> m = new MyHashMap<>(1000);

        for (int i = 0; i < 20; ++i) {
            m.put(Map.entry(i * 500, i * 7));
        }
        m.print_vals();
        for (int i = 0; i < 20; ++i) {
            int real_ind = m.get_real_index(i * 500);
            //System.out.println("key = " + i * 500 + " ind = " + real_ind);
            System.out.println(m.get(i * 500) == i * 7);
        }
    }
}
