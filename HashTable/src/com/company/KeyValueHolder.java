package com.company;

public class KeyValueHolder<K, V> {
    final K key;
    V value;

    public KeyValueHolder(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + ": " + value;
    }
}
