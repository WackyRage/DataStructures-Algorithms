package DataStructure;

import DataStructure.Node.Entry;

import java.util.NoSuchElementException;

public class HashMap<K, T>  {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;
    // Array that will hold the HashMap entries
    private Entry<K, T>[] table;
    // Active size of the HashMap
    private int size = 0;
    private int capacity = DEFAULT_CAPACITY;

    public HashMap(){
        table = new Entry[DEFAULT_CAPACITY];
    }

    // Method to add an element to the HashMap
    public void add(K key, T value) {
        // Check if key and value contains value
        if (key == null || value == null) {
            throw new NullPointerException("Null key is not allowed.");
        }

        // Check if capacity is bigger than threshold, if true: increase size
        if ((double) size / capacity >= LOAD_FACTOR_THRESHOLD) {
            capacity();
        }

        // Calculate Index on where to place the entry
        int index = getIndex(key);
        Entry<K, T>  entry = table[index];

        // Safety check to see if Index is empty, if so create new entry
        if (entry == null) {
            table[index] = new Entry<>(key, value, null);
            size++;
        } else {
            // If entry exist, loop till end to add new entry
            while (entry.getNext() != null) {
                // Check if Key matches, if so: throw error.
                if (entry.getKey().equals(key)) {
                    throw new IllegalArgumentException("Index: " + key + " already exist, use set to alter existing entries.");
                }
                entry = entry.getNext();
            }
            entry.setNext(new Entry<>(key, value, null));
            size++;
        }
    }

    // Method to calculate the index for given key
    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    // Method to get element from HashMap by key
    public T get(K key){
        // Check if key contains value
        if (key == null) {
            throw new NullPointerException("Null key is not allowed.");
        }

        int index = getIndex(key);
        Entry<K, T> entry = table[index];
        // Loop through entries to get right value
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }

        // If loop produced no value, throws error
        throw new NoSuchElementException("Index: " + key + " does not exist.");
    }

    // Method to delete an element from the HashMap by key
    public void delete(K key){
        // Check if key contains value
        if (key == null) {
            throw new ArrayStoreException("A null input has been detected, please enter non-null values.");
        }

        int index = getIndex(key);

        Entry<K, T> current = table[index];
        Entry<K, T> prev = null;

        // Loop through entries to get right value
        while (current != null) {
            if (current.getKey().equals(key)) {
                if (prev == null) {
                    table[index] = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    // Method to check if HashMap contains specific value
    public Boolean contains(T value){
        for (Entry<K, T> entry : table) {
            while (entry != null) {
                if (entry.getValue().equals(value)) {
                    return true;
                }
                entry = entry.getNext();
            }
        }
        return false;
    }

    // Method to get the size of an HashMap
    public int size() {
        int count = 0;
        // Loop to count the entries, excluding null
        for (Entry<K, T> entry : table) {
            Entry<K, T> current = entry;
            while (current != null) {
                count++;
                current = current.getNext();
            }
        }
        return count;
    }

    // Method to set value at a specific key in the ArrayList
    public void set(K key, T value) {
        int index = getIndex(key);
        Entry<K, T> entry = table[index];

        // Loop through entries, until matching key if found
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
            entry = entry.getNext();
        }
        add(key, value);
    }

    // Method to increase size of capacity
    public void capacity() {
        int newCapacity = capacity * 2;
        Entry<K, T>[] newTable = new Entry[newCapacity];

        // Loop to rehash all entries to new table
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

