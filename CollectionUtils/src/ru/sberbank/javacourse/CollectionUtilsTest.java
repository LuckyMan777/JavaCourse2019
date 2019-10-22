package ru.sberbank.javacourse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {
    List<Number> listNumbersFull;
    List<Integer> listIntegers;
    List<Double> listDoubles;
    List<Number> listNumbersPart;

    @BeforeEach
    void setUp() {
        listNumbersFull = new ArrayList<Number>();
        listNumbersFull.addAll(Arrays.asList(1, 1.1, 2, 2.2, 3, 3.3, 4, 4.4, 5, 5.5));
        listIntegers = new ArrayList<Integer>();
        listIntegers.addAll(Arrays.asList(1, 2, 3, 4, 5));
        listDoubles = new ArrayList<Double>();
        listDoubles.addAll(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5));
        listNumbersPart = new ArrayList<Number>();
        listNumbersPart.addAll(Arrays.asList(2, 2.2, 3, 3.3, 4));
    }

    @Test
    void addAllNumbers() {
        CollectionUtils.addAll(listNumbersPart, listNumbersFull);
        for (int i = listNumbersFull.size() - listNumbersPart.size(), j = 0; i < listNumbersFull.size(); ++i, ++j) {
            assertEquals(listNumbersPart.get(j), listNumbersFull.get(i));
        }
    }

    @Test
    void addAllDoubles() {
        CollectionUtils.addAll(listDoubles, listNumbersFull);
        for (int i = listNumbersFull.size() - listDoubles.size(), j = 0; i < listNumbersFull.size(); ++i, ++j) {
            assertEquals(listDoubles.get(j), listNumbersFull.get(i));
        }
    }

    @Test
    void addAllIntegers() {
        CollectionUtils.addAll(listIntegers, listNumbersFull);
        for (int i = listNumbersFull.size() - listIntegers.size(), j = 0; i < listNumbersFull.size(); ++i, ++j) {
            assertEquals(listIntegers.get(j), listNumbersFull.get(i));
        }
    }

    @Test
    void indexOfInteger() {
        assertEquals(0, CollectionUtils.indexOf(listNumbersFull, 1));
        assertEquals(0, CollectionUtils.indexOf(listIntegers, 1));
        assertEquals(-1, CollectionUtils.indexOf(listIntegers, 8));
    }

    @Test
    void indexOfDouble() {
        assertEquals(1, CollectionUtils.indexOf(listNumbersFull, 1.1));
        assertEquals(0, CollectionUtils.indexOf(listDoubles, 1.1));
        assertEquals(-1, CollectionUtils.indexOf(listDoubles, 2.1));
    }

    @Test
    void limitNumbers() {
        List<Number> l = CollectionUtils.limit(listNumbersFull, 3);
        List<Number> lExpected = listNumbersFull.subList(0, 3);

        for (int i = 0; i < l.size(); ++i) {
            assertEquals(l.get(i), lExpected.get(i));
        }
    }

    @Test
    void limitIntegers() {
        List<Integer> l = CollectionUtils.limit(listIntegers, 3);
        List<Integer> lExpected = listIntegers.subList(0, 3);

        for (int i = 0; i < l.size(); ++i) {
            assertEquals(l.get(i), lExpected.get(i));
        }
    }

    @Test
    void addNumber() {
        CollectionUtils.add(listNumbersFull, 90);
        assertEquals(90, listNumbersFull.get(listNumbersFull.size() - 1));
        CollectionUtils.add(listNumbersFull, 0.6);
        assertEquals(0.6, listNumbersFull.get(listNumbersFull.size() - 1));
    }

    @Test
    void addInteger() {
        CollectionUtils.add(listNumbersFull, 90);
        assertEquals(90, listNumbersFull.get(listNumbersFull.size() - 1));
        CollectionUtils.add(listIntegers, 6);
        assertEquals(6, listIntegers.get(listIntegers.size() - 1));
    }

    @Test
    void addDouble() {
        CollectionUtils.add(listNumbersFull, 0.9);
        assertEquals(0.9, listNumbersFull.get(listNumbersFull.size() - 1));
        CollectionUtils.add(listDoubles, 0.6);
        assertEquals(0.6, listDoubles.get(listDoubles.size() - 1));
    }

    @Test
    void removeAllNumbers() {
        List<Number> lExpected = listNumbersFull.subList(0, listNumbersFull.size());
        lExpected.removeAll(listNumbersPart);
        CollectionUtils.removeAll(listNumbersFull, listNumbersPart);

        for (int i = 0; i < listNumbersFull.size(); ++i) {
            assertEquals(listNumbersFull.get(i), lExpected.get(i));
        }
    }

    @Test
    void removeAllIntegers() {
        List<Number> lExpected = listNumbersFull.subList(0, listNumbersFull.size());
        lExpected.removeAll(listIntegers);
        CollectionUtils.removeAll(listNumbersFull, listIntegers);

        for (int i = 0; i < listNumbersFull.size(); ++i) {
            assertEquals(listNumbersFull.get(i), lExpected.get(i));
        }
    }

    void removeAllDoubles() {
        List<Number> lExpected = listNumbersFull.subList(0, listNumbersFull.size());
        lExpected.removeAll(listDoubles);
        CollectionUtils.removeAll(listNumbersFull, listDoubles);

        for (int i = 0; i < listNumbersFull.size(); ++i) {
            assertEquals(listNumbersFull.get(i), lExpected.get(i));
        }
    }

    @Test
    void containsAllNumbers() {
        assertTrue(CollectionUtils.containsAll(listNumbersFull, listNumbersPart));
        assertFalse(CollectionUtils.containsAll(listNumbersPart, listNumbersFull));
    }

    @Test
    void containsAllIntegers() {
        assertTrue(CollectionUtils.containsAll(listNumbersFull, listIntegers));
        assertFalse(CollectionUtils.containsAll(listNumbersFull, Arrays.asList(1, 4, 7)));
    }

    @Test
    void containsAllDoubles() {
        assertTrue(CollectionUtils.containsAll(listNumbersFull, listDoubles));
        assertFalse(CollectionUtils.containsAll(listNumbersFull, Arrays.asList(1.1, 2.2, 1.7)));
    }

    @Test
    void containsAnyNumber() {
        assertTrue(CollectionUtils.containsAny(listNumbersFull, listNumbersPart));
        assertTrue(CollectionUtils.containsAny(listNumbersPart, listNumbersFull));
        assertFalse(CollectionUtils.containsAny(listNumbersPart, Arrays.asList(7, 7.7)));
    }

    @Test
    void containsAnyInteger() {
        assertTrue(CollectionUtils.containsAny(listNumbersFull, listIntegers));
        assertTrue(CollectionUtils.containsAny(listNumbersFull, Arrays.asList(1, 4, 7)));
        assertFalse(CollectionUtils.containsAny(listNumbersFull, Arrays.asList(7)));
    }

    @Test
    void containsAnyDouble() {
        assertTrue(CollectionUtils.containsAny(listNumbersFull, Arrays.asList(1.1, 2.2, 1.7)));
        assertTrue(CollectionUtils.containsAny(listNumbersFull, listDoubles));
        assertFalse(CollectionUtils.containsAny(listNumbersFull, Arrays.asList(7.7)));
    }

    @Test
    void rangeIntegers() {
        List<Integer> lExpected = listIntegers.subList(0, 3);
        List<Integer> l = CollectionUtils.range(listIntegers, 0, 3);

        for (int i = 0; i < l.size(); ++i) {
            assertEquals(l.get(i), lExpected.get(i));
        }
    }

    @Test
    void rangeDoubles() {
        List<Double> lExpected = listDoubles.subList(0, 3);
        List<Double> l = CollectionUtils.range(listDoubles, 0.0, 3.0);

        for (int i = 0; i < l.size(); ++i) {
            assertEquals(l.get(i), lExpected.get(i));
        }
    }

    @Test
    void rangeComparatorIntegers() {
        List<Integer> lExpected = listIntegers.subList(0, 3);
        List<Integer> l = CollectionUtils.range(listIntegers, 0, 3, Comparator.comparingInt(o -> o));

        for (int i = 0; i < l.size(); ++i) {
            assertEquals(l.get(i), lExpected.get(i));
        }
    }

    @Test
    void rangeComparatorDoubles() {
        List<Double> lExpected = listDoubles.subList(0, 3);
        List<Double> l = CollectionUtils.range(listDoubles, 0.0, 3.0, Comparator.comparingDouble(o -> o));

        for (int i = 0; i < l.size(); ++i) {
            assertEquals(l.get(i), lExpected.get(i));
        }
    }
}