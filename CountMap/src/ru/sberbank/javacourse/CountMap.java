package ru.sberbank.javacourse;

import java.util.HashMap;
import java.util.Map;

public class CountMap<K> {
    private HashMap<K, Integer> map = new HashMap<>();

    public void add(K key) {
        if (!map.containsKey(key)) {
            map.put(key, 0);
        }
        map.put(key, map.get(key) + 1);
    }

    private void add(K key, int count) {
        if (!map.containsKey(key)) {
            map.put(key, 0);
        }
        map.put(key, map.get(key) + count);
    }

    public int remove(K key) {
        Integer count;
        return (count = map.remove(key)) == null ? 0 : count;
    }

    public int getCount(K key) {
        Integer count;
        return (count = map.get(key)) == null ? 0 : count;
    }

    public Map<K, Integer> asMap() {
        HashMap<K, Integer> newMap = new HashMap<>();
        copyTo(newMap);
        return newMap;
    }

    public void copyTo(Map<? super K, ? super Integer> m2) {
        m2.putAll(map);
    }
}
