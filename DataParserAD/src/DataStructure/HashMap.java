package DataStructure;

import DataStructure.Node.Entry;

import java.util.List;
import java.util.NoSuchElementException;

public class HashMap<K, T>  {
    private int capacity = 250;
    private Entry<K, T>[] table;

    public HashMap(){
        table = new Entry[capacity];
    }

    public void add(K key, T value) {
        if (key == null || value == null) {
            throw new ArrayStoreException("A null input has been detected, please enter non-null values.");
        }

        int index = getIndex(key);
        Entry<K, T>  entry = table[index];

        if (entry == null) {
            table[index] = new Entry<>(key, value, null);
        } else {
            while (entry.getNext() != null) {
                if (entry.getKey().equals(key)) {
                    throw new IndexOutOfBoundsException("Index: " + key + " already exist, use set to alter existing entries.");
                }
                entry = entry.getNext();
            }
            entry.setNext(new Entry<>(key, value, null));
        }
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    public T get(K key){
        if (key == null) {
            throw new ArrayStoreException("A null input has been detected, please enter non-null values.");
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
            throw new ArrayStoreException("A null input has been detected, please enter non-null values.");
        }

        int index = getIndex(key);

        Entry<K, T> current = table[index];
        Entry<K, T> prev = null;

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

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        // Add some entries
        hashMap.add(1, "stardew");
        hashMap.add(2, "volly");
        hashMap.add(3, "Doom");
        hashMap.add(4, "stardew");
        hashMap.add(5, "volly");
        hashMap.add(6, "Doom");
        hashMap.add(7, "stardew");
        hashMap.add(8, "volly");
        hashMap.add(9, "Doom");

        // Get and print the value for a specific key
        System.out.println("Value for key 1: " + hashMap.get(1));
        System.out.println("Value for key 2: " + hashMap.get(2));
        System.out.println("Value for key 3: " + hashMap.get(3));

        // Update an existing entry
        hashMap.set(2, "Soccer");

        // Get and print the updated value for the same key
        System.out.println("Updated value for key 2: " + hashMap.get(2));

        // Delete an entry
        hashMap.delete(3);

        // Check if a value exists in the HashMap
        System.out.println("Does the HashMap contain value 'Doom'? " + hashMap.contains("Doom"));
        System.out.println("Does the HashMap contain value 'Soccer'? " + hashMap.contains("Soccer"));

        // Get the size of the HashMap
        System.out.println("Size of the HashMap: " + hashMap.size());

        for (int i = 0; i < hashMap.table.length; i++) {
            Entry<Integer, String> entry = hashMap.table[i];
            while (entry != null) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                entry = entry.getNext();
            }
        }
    }

}

