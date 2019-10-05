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

    public void addAll(CountMap<K> m2) {
        for (K key : m2.map.keySet()) {
            this.add(key, m2.getCount(key));
        }
    }

    public int remove(K key) {
        return map.remove(key);
    }

    public int getCount(K key) {
        return map.get(key);
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
