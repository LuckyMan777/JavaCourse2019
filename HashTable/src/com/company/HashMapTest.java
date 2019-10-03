package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    private final int initialCapacity = 1000000;
    private final int count = 10000000;
    HashMap<Integer, Integer> map;
    ArrayList<Integer> uniqueNums;
    private ArrayList<Integer> nums = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    private void setUp() throws Exception {
        Random r = new Random();
        for (int i = 0; i < count; ++i) {
            nums.add(r.nextInt() % 10);
        }
        uniqueNums = (ArrayList) nums.stream().distinct().collect(Collectors.toList());
        map = new HashMap<>(initialCapacity);
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
        for (int i = 0; i < uniqueNums.size() / 2; i++) {
            assertNotNull(map.remove(uniqueNums.get(i)));
        }
        for (int i = uniqueNums.size() / 2; i < uniqueNums.size(); i++) {
            assertTrue(uniqueNums.contains(uniqueNums.get(i)));
        }
    }

    @org.junit.jupiter.api.Test
    void contains() {
        for (int i = 0; i < nums.size(); i++) {
            assertTrue(map.containsKey(nums.get(i)));
        }
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(uniqueNums.size(), map.size());
        for (int i = 0; i < uniqueNums.size() / 2; ++i) {
            assertNotNull(map.remove(uniqueNums.get(i)));
        }
        assertEquals(uniqueNums.size() - uniqueNums.size() / 2, map.size());
    }
}