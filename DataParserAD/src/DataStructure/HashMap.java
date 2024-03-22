package DataStructure;

import DataStructure.Node.Entry;

import java.util.NoSuchElementException;

public class HashMap<K, T>  {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;
    private Entry<K, T>[] table;
    private int size = 0;
    private int capacity = DEFAULT_CAPACITY;


    public HashMap(){
        table = new Entry[DEFAULT_CAPACITY];
    }

    public void add(K key, T value) {
        if (key == null || value == null) {
            throw new NullPointerException("Null key is not allowed.");
        }

        if ((double) size / capacity >= LOAD_FACTOR_THRESHOLD) {
            capacity();
        }

        int index = getIndex(key);
        Entry<K, T>  entry = table[index];

        if (entry == null) {
            table[index] = new Entry<>(key, value, null);
            size++;
        } else {
            while (entry.getNext() != null) {
                if (entry.getKey().equals(key)) {
                    throw new IllegalArgumentException("Index: " + key + " already exist, use set to alter existing entries.");
                }
                entry = entry.getNext();
            }
            entry.setNext(new Entry<>(key, value, null));
            size++;
        }
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    public T get(K key){
        if (key == null) {
            throw new NullPointerException("Null key is not allowed.");
        }

        int index = getIndex(key);
        Entry<K, T> entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }

        throw new NoSuchElementException("Index: " + key + " does not exist.");
    }

    public void delete(K key){
        if (key == null) {
            throw new NullPointerException("Null key is not allowed.");
        }
        System.out.println("Entered delete");



    }

    public Boolean contains(T value){
        for (Entry<K, T> entry : table) {
            Entry<K, T> current = entry;
            while (current != null) {
                if (current.getValue().equals(value)) {
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    public int size() {
        int count = 0;
        for (Entry<K, T> entry : table) {
            Entry<K, T> current = entry;
            while (current != null) {
                count++;
                current = current.getNext();
            }
        }
        return count;
    }

    public void set(K key, T value) {
        int index = getIndex(key);
        Entry<K, T> entry = table[index];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
            entry = entry.getNext();
        }
        add(key, value);
    }

    public void capacity() {
        int newCapacity = capacity * 2;
        Entry<K, T>[] newTable = new Entry[newCapacity];

        for (Entry<K, T> entry : table) {
            while (entry != null) {
                int newIndex = getIndex(entry.getKey());
                Entry<K, T> next = entry.getNext();
                entry.setNext(newTable[newIndex]);
                newTable[newIndex] = entry;
                entry = next;
            }
        }

        table = newTable;
        capacity = newCapacity;
    }
}

