package ru.sberbank.javacourse.timerproxy;

import java.util.Map;

public interface ICheckMapTime {
    void testAddInteger(Map<Integer, Integer> hm);

    void testContainsInteger(Map<Integer, Integer> hm);

    void testRemoveInteger(Map<Integer, Integer> hm);
}
