package com.company;

import java.util.Map;

//Hash map
public class MyHashMap<K, V> {
    /*
    private ArrayList<Map.Entry<K, V>> table;
    private int size = 0;
    private final int initialCapacity = 100;
    private final double loadFactor = 0.75;

    public MyHashMap() {
        table = new ArrayList<Map.Entry<K, V>>(initialCapacity);
        for (int i = 0; i < initialCapacity; ++i) {
            table.add(null);
        }
    }

    public MyHashMap(int size) {
        table = new ArrayList<>(size * 2);
        for (int i = 0; i < size * 2; ++i) {
            table.add(null);
        }
    }

    private void reconstructTable() {
        ArrayList<Map.Entry<K, V>> newTable = new ArrayList<>();
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

    public void printVals() {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i) != null) {
                System.out.println("ind = " + i + " kv = " + table.get(i));
            }
        }
    }*/
    private Map.Entry<K, V>[] table;
    private int size = 0;
    private final int initialCapacity = 100;
    private final double loadFactor = 0.75;


    public MyHashMap() {
        table = (Map.Entry<K, V>[]) new Map.Entry[initialCapacity];
        /*for (int i = 0; i < initialCapacity; ++i) {
            table.add(null);
        }*/
    }

    public MyHashMap(int size) {
        table = (Map.Entry<K, V>[]) new Map.Entry[size * 2];
        /*for (int i = 0; i < size * 2; ++i) {
            table.add(null);
        }*/
    }

    private void reconstructTable() {
        Map.Entry<K, V>[] newTable = (Map.Entry<K, V>[]) new Map.Entry[table.length * 2];
        for (Map.Entry<K, V> kvEntry : table) {
            if (kvEntry != null) {
                putToArray(kvEntry.getKey(), kvEntry.getValue(), newTable);
            }
        }
        table = newTable;
    }

    private int getIndexInArray(K key, Map.Entry<K, V>[] array) {
        int hash = Math.abs(key.hashCode());
        return hash % array.length;
    }

    private int getRealIndexInArray(K key, Map.Entry<K, V>[] array) {
        int index = getIndexInArray(key, array);
        while (array[index] != null) {
            //System.out.println("  table.get(index).getKey() = " + table.get(index).getKey());
            //System.out.println("  key = " + key);
            //System.out.println("  (table.get(index).getKey().equals(key)): " + (table.get(index).getKey().equals(key)));
            if (array[index].getKey().equals(key)) {
                return index;
            }
            ++index;
            if (index >= array.length) {
                index = 0;
            }
        }
        return index;
    }

    private void putToArray(K key, V value, Map.Entry<K, V>[] array) {
        int index = getRealIndexInArray(key, array);
        array[index] = Map.entry(key, value);
    }

    public void put(K key, V value) {
        if (size > table.length * loadFactor)
            reconstructTable();
        putToArray(key, value, table);
        ++size;
    }

    public V get(K key) {
        int index = getRealIndexInArray(key, table);
        if (table[index].getKey().equals(key)) {
            return table[index].getValue();
        }
        return null;
    }

    public void remove(K key) {
        int index = getRealIndexInArray(key, table);
        table[index] = null;
        --size;
    }

    public boolean contains(K key) {
        int index = getRealIndexInArray(key, table);
        return table[index] != null;
    }

    public int size() {
        return size;
    }

    public void printVals() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.println("ind = " + i + " kv = " + table[i]);
            }
        }
    }
}
