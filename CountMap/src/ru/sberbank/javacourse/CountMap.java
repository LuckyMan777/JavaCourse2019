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

    public Map<? extends K, Integer> asMap() {
        return (Map<? extends K, Integer>) map.clone();
    }

    public void copyTo(Map<K, Integer> m2) {
        for (K key : map.keySet()) {
            if (!m2.containsKey(key)) m2.put(key, 0);
            m2.put(key, m2.get(key) + map.get(key));
        }
    }
}
