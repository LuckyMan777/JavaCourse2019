package com.company;

import java.util.stream.IntStream;

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
    public KeyValueHolder<K, V>[] table;
    private int size = 0;
    private final int initialCapacity = 100;
    private final double loadFactor = 0.7;
    private final int multiplier = 2;
    public final KeyValueHolder<K, V> TOMBSTONE = new KeyValueHolder<>(null, null);


    public MyHashMap() {
        table = (KeyValueHolder<K, V>[]) new KeyValueHolder[initialCapacity];
        /*for (int i = 0; i < initialCapacity; ++i) {
            table.add(null);
        }*/
    }

    public MyHashMap(int size) {
        table = (KeyValueHolder<K, V>[]) new KeyValueHolder[size * multiplier];
        /*for (int i = 0; i < size * 2; ++i) {
            table.add(null);
        }*/
    }

    private void reconstructTable() {
        KeyValueHolder<K, V>[] newTable = (KeyValueHolder<K, V>[]) new KeyValueHolder[table.length * 2];
        for (KeyValueHolder<K, V> kvEntry : table) {
            if ((kvEntry != null) && kvEntry != TOMBSTONE) {
                putToArray(kvEntry.getKey(), kvEntry.getValue(), newTable);
            }
        }
        table = newTable;
    }

    public int getNormalizedIndexInArray(K key, KeyValueHolder<K, V>[] array) {
        int hash = Math.abs(key.hashCode());
        return hash % array.length;
    }

    private int getNextProb(int index, KeyValueHolder<K, V>[] array) {
        return (index + 1) % array.length;
    }

    private void putToArray(K key, V value, KeyValueHolder<K, V>[] array) {
        if (key == null) throw new IllegalArgumentException("Key is null");
        int index = getNormalizedIndexInArray(key, array);
        while (array[index] != null && array[index] != TOMBSTONE) {
            if (array[index].getKey().equals(key)) {
                array[index].setValue(value);
                return;
            }
            index = getNextProb(index, array);
        }
        array[index] = new KeyValueHolder<>(key, value);
    }

    public void put(K key, V value) {
        if (size > table.length * loadFactor)
            reconstructTable();
        putToArray(key, value, table);
        ++size;
    }

    public V get(K key) {
        int index = getNormalizedIndexInArray(key, table);
        int firstTombstone = -1;
        while (table[index] != null) {
            if ((table[index] == TOMBSTONE) && (firstTombstone == -1)) {
                firstTombstone = index;
            }
            if ((table[index] != TOMBSTONE) && table[index].getKey().equals(key)) {
                if (firstTombstone != -1) {
                    table[firstTombstone] = table[index];
                    table[index] = TOMBSTONE;
                    return table[firstTombstone].getValue();
                }
                return table[index].getValue();
            }
            index = getNextProb(index, table);
        }
        return null;
    }

    public V remove(K key) {
        int index = getNormalizedIndexInArray(key, table);
        while (table[index] != null) {
            if ((table[index] != TOMBSTONE) && table[index].getKey().equals(key)) {
                V value = table[index].getValue();
                table[index] = TOMBSTONE;
                --size;
                return value;
            }
            index = getNextProb(index, table);
        }
        return null;
    }

    public boolean contains(K key) {
        int index = getNormalizedIndexInArray(key, table);
        while (table[index] != null) {
            if ((table[index] != TOMBSTONE) && table[index].getKey().equals(key)) return true;
            index = getNextProb(index, table);
        }
        return false;
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
