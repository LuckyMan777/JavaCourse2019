package ru.sberbank.javacourse;

import ru.sberbank.javacourse.person.Address;
import ru.sberbank.javacourse.person.Person;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.*;

public class Main {

    private static void testMap(){
        TestMap test = new TestMap();
        ITestMap testproxy = (ITestMap) Proxy.newProxyInstance(TestMap.class.getClassLoader(),
                TestMap.class.getInterfaces(), new TimerProxy(test));

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

    public static void main(String[] args) throws IOException, IllegalAccessException {
        //testMap();

        List<String> phoneNumbers = Arrays.asList("567-89", "123-456");
        Person p = new Person("firstname", "lastname",
                new Address("city", 789456), phoneNumbers);
        Serialization.serializeIntoFile(p, "pers.txt");
    }
}
