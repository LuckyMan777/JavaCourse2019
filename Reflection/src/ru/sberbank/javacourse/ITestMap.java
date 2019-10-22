package ru.sberbank.javacourse;

import java.util.Map;

public interface ITestMap {
    void testAddInteger(Map<Integer, Integer> hm);
    void testContainsInteger(Map<Integer, Integer> hm);
    void testRemoveInteger(Map<Integer, Integer> hm);
}
