package ru.sberbank.javacourse.timerproxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    private static void testMap() {
        CheckMapTime test = new CheckMapTime();
        ICheckMapTime testproxy = (ICheckMapTime) Proxy.newProxyInstance(CheckMapTime.class.getClassLoader(),
                CheckMapTime.class.getInterfaces(), new TimerProxy(test));

        Map<Integer, Integer> mapTree = new TreeMap<>();
        Map<Integer, Integer> mapHash = new HashMap<>();

        System.out.println("Add integers in TreeMap: ");
        testproxy.testAddInteger(mapTree);
        System.out.println("Add integers in HashMap: ");
        testproxy.testAddInteger(mapHash);

        System.out.println("Contains integers in TreeMap: ");
        testproxy.testContainsInteger(mapTree);
        System.out.println("Contains integers in HashMap: ");
        testproxy.testContainsInteger(mapHash);

        System.out.println("Remove integers from TreeMap: ");
        testproxy.testRemoveInteger(mapTree);
        System.out.println("Remove integers from HashMap: ");
        testproxy.testRemoveInteger(mapHash);
    }

    public static void main(String[] args) {
        testMap();
    }
}
