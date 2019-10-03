package com.company;

public class MyHashMap<K, V> {
    public final KeyValueHolder<K, V> TOMBSTONE = new KeyValueHolder<>(null, null);
    private final int initialCapacity = 100;
    private final double loadFactor = 0.5;
    private final int multiplier = 2;

    private KeyValueHolder<K, V>[] table;
    private int size = 0;


    public MyHashMap() {
        table = (KeyValueHolder<K, V>[]) new KeyValueHolder[initialCapacity];
    }

    public MyHashMap(int size) {
        table = (KeyValueHolder<K, V>[]) new KeyValueHolder[size * multiplier];
    }

    private void reconstructTable() {
        KeyValueHolder<K, V>[] newTable = (KeyValueHolder<K, V>[]) new KeyValueHolder[table.length * multiplier];
        for (KeyValueHolder<K, V> kvEntry : table) {
            if ((kvEntry != null) && kvEntry != TOMBSTONE) {
                putToArray(kvEntry.getKey(), kvEntry.getValue(), newTable);
            }
        }
        table = newTable;
    }

    private int getNormalizedIndexInArray(K key, KeyValueHolder<K, V>[] array) {
        int hash = Math.abs(key.hashCode());
        return hash % array.length;
    }

    //return next index for probing
    private int getNextProb(int index, KeyValueHolder<K, V>[] array) {
        return (index + 1) % array.length;
    }

    //return true if element added and false if element changed
    private boolean putToArray(K key, V value, KeyValueHolder<K, V>[] array) {
        if (key == null) throw new IllegalArgumentException("Key is null");
        int index = getNormalizedIndexInArray(key, array);
        while (array[index] != null && array[index] != TOMBSTONE) {
            if (array[index].getKey().equals(key)) {
                array[index].setValue(value);
                return false;
            }
            index = getNextProb(index, array);
        }
        array[index] = new KeyValueHolder<>(key, value);
        return true;
    }

    public void put(K key, V value) {
        if (size > table.length * loadFactor)
            reconstructTable();
        if (putToArray(key, value, table)) ++size;
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
