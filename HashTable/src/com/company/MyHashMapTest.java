package com.company;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    private ArrayList<Integer> nums = new ArrayList<>();
    MyHashMap<Integer, Integer> map = new MyHashMap<>();
    private int count = 100;

    @org.junit.jupiter.api.BeforeEach
    private void setUp() throws Exception {
        Random r = new Random();
        for (int i = 0; i < count; ++i) {
            nums.add(r.nextInt() % 10000);
        }
        map = new MyHashMap<>();
        for (Integer num : nums) {
            map.put(num, num * 3);
        }
    }

    @org.junit.jupiter.api.Test
    void get() {
        for (Integer num : nums) {
            assertEquals(map.get(num), num*3);
        }
    }

    @org.junit.jupiter.api.Test
    void remove() {
        for (int i = 0; i < nums.size() / 2; i++) {
             map.remove(nums.get(i));
        }
        assertEquals(map.size(), nums.size() / 2);
        map.printVals();
        for (int i = nums.size() / 2; i < nums.size(); i++) {
            System.out.println(map.contains(nums.get(i)));
            map.contains(nums.get(i));
            assertTrue(map.contains(nums.get(i)));
        }
    }

    @org.junit.jupiter.api.Test
    void contains() {
        for (int i = 0; i < nums.size(); i++) {
             assertTrue(map.contains(nums.get(i)));
        }
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(nums.size(), map.size());
    }
}