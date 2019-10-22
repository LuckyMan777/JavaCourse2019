package ru.sberbank.javacourse;

import java.util.Map;
import java.util.Random;

public class TestMap implements ITestMap {
    private static final int COUNTER = 1000000;

    @Override
    public void testAddInteger(Map<Integer, Integer> hm){
        Random r = new Random();
        for (int i = 0; i < COUNTER; ++i) {
            hm.put(r.nextInt(), r.nextInt());
        }
    }

    @Override
    public void testContainsInteger(Map<Integer, Integer> hm){
        Random r = new Random();
        for (int i = 0; i < COUNTER; ++i) {
            hm.containsKey(r.nextInt());
        }
    }

    @Override
    public void testRemoveInteger(Map<Integer, Integer> hm) {
        Random r = new Random();
        for (int i = 0; i < COUNTER; ++i) {
            hm.remove(r.nextInt());
        }
    }
}
