package ru.sberbank.javacourse;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountMapTest {
    private final int count = 1000;
    private CountMap<Integer> m;

    //Key: count == key*2
    @org.junit.jupiter.api.BeforeEach
    private void setUp() {
        m = new CountMap<>();
        for (int i = 1; i < count; ++i)
            for (int j = 1; j <= i * 2; ++j)
                m.add(i);
    }

    @org.junit.jupiter.api.Test
    void add() {
        m.add(5);
        m.add(6);
        m.add(5); // 5: +2
        m.add(6); // 6: +2
        assertEquals(12, m.getCount(5));
        assertEquals(14, m.getCount(6));
        assertEquals(20, m.getCount(10));
    }

    @org.junit.jupiter.api.Test
    void count() {
        for (int i = 1; i < count; ++i) {
            assertEquals(i*2, m.getCount(i));
        }
    }

    @org.junit.jupiter.api.Test
    void asMap() {
        HashMap<Integer, Integer> m2 = (HashMap<Integer, Integer>) m.asMap();
        for (int i = 1; i < count; ++i) {
            assertEquals(i*2, m2.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void copyTo() {
        HashMap<Integer, Integer> m2 = (HashMap<Integer, Integer>) m.asMap();
        m.copyTo(m2);
        for (int i = 1; i < count; ++i) {
            assertEquals(i*2, m2.get(i));
        }
    }
}