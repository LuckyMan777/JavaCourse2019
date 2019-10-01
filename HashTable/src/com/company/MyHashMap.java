package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Hash map
public class MyHashMap<K, V> {
    private ArrayList<Map.Entry<K, V>> table;
    private int size = 0;
    private final int initialCapacity = 100;
    private final double loadFactor = 0.75;

    public MyHashMap() {
        table = new ArrayList<Map.Entry<K, V>>(initialCapacity);
        for (int i = 0; i < initialCapacity; ++i) {
            table.add(null);
        }
        Map<Integer, Integer> map = new HashMap<>();
    }

    public MyHashMap(int size) {
        table = new ArrayList<>(size * 2 + 1);
        for (int i = 0; i < size * 2 + 1; ++i) {
            table.add(null);
        }
    }

    private void reconstructTable() {

    }

    private int get_index(K key) {
        int hash = key.hashCode();
        return hash % table.size();
    }

    public int get_real_index(K key) {
        int index = get_index(key);
        while (table.get(index) != null) {
            //System.out.println("  table.get(index).getKey() = " + table.get(index).getKey());
            //System.out.println("  key = " + key);
            //System.out.println("  (table.get(index).getKey().equals(key)): " + (table.get(index).getKey().equals(key)));
            if (table.get(index).getKey().equals(key)) {
                return index;
            }
            ++index;
            if (index >= table.size()) {
                index = 0;
            }
        }
        return index;
    }

    public void put(Map.Entry<K, V> elem) {
        if (size > table.size() * loadFactor)
            reconstructTable();
        int index = get_real_index(elem.getKey());
        table.set(index, elem);
        ++size;
    }

    public V get(K key) {
        int index = get_real_index(key);
        if (table.get(index).getKey().equals(key)) {
            return table.get(index).getValue();
        }
        return null;
    }

    public void remove(K key) {
        int index = get_real_index(key);
        table.set(index, null);
        --size;
    }

    public boolean contains(K key) {
        int index = get_real_index(key);
        return table.get(index) != null;
    }

    public int size() {
        return size;
    }

    public void print_vals() {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i) != null) {
                System.out.println("ind = " + i + " kv = " + table.get(i));
            }
        }
    }
}
