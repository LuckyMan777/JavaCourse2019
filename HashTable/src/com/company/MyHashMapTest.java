package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    private final int initialCapacity = 100;
    private final int count = 100;
    MyHashMap<Integer, Integer> map;
    private ArrayList<Integer> nums = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    private void setUp() throws Exception {
        Random r = new Random();
        for (int i = 0; i < count; ++i) {
            nums.add(r.nextInt() % 10000);
        }
        map = new MyHashMap<>(initialCapacity);
        for (Integer num : nums) {
            map.put(num, num * 3);
        }
    }

    @org.junit.jupiter.api.Test
    void get() {
        for (Integer num : nums) {
            assertEquals(map.get(num), num * 3);
        }
    }

    @org.junit.jupiter.api.Test
    void remove() {
        nums = (ArrayList) nums.stream().distinct().collect(Collectors.toList());
        for (int i = 0; i < nums.size() / 2; i++) {
            if (!map.contains(nums.get(i))) {
                map.contains(nums.get(i));
            }
            assertNotNull(map.remove(nums.get(i)));
        }
        assertEquals(nums.size() / 2, map.size());
        map.printVals();
        for (int i = nums.size() / 2; i < nums.size(); i++) {
            if (!map.contains(nums.get(i))) {
                System.out.println("key = " + nums.get(i) + " ind = " +
                        map.getNormalizedIndexInArray(nums.get(i), map.table) + " : " + map.contains(nums.get(i)));
            }
            assertTrue(map.contains(nums.get(i)));
        }
    }

    @org.junit.jupiter.api.Test
    void contains() {
        map.printVals();
        for (int i = 0; i < nums.size(); i++) {
            if (!map.contains(nums.get(i))) {
                System.out.println("key = " + nums.get(i) + " ind = " +
                        map.getNormalizedIndexInArray(nums.get(i), map.table) + " : " + map.contains(nums.get(i)));
            }
            assertTrue(map.contains(nums.get(i)));
        }
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(nums.size(), map.size());
    }
}