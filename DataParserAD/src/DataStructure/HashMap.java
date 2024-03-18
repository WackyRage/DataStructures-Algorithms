package DataStructure;

import DataStructure.Node.Entry;

public class HashMap<K, T> {
    private int capacity = 250;
    private Entry<K, T>[] table;

    public HashMap(){
        table = new Entry[capacity];
    }

    public void add(K key, T value) {
        if (key == null) {
            return;
        }

        int index = getIndex(key);
        Entry<K, T>  entry = table[index];

        if (entry == null) {
            table[index] = new Entry<>(key, value, null);
        } else {
            while (entry.getNext() != null) {
                if (entry.getKey().equals(key)) {
                    // Key already exists, update the value
                    entry.setValue(value);
                    return;
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
            return null;
        }

        int index = getIndex(key);
        Entry<K, T> entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }

        return null;
    }

    public void delete(K key){
        if (key == null) {
            return;
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

    public boolean contains(T value){
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

        for (int i = 1; i <= hashMap.size(); i++) {
            System.out.println("Key: " + i + ", Value: " + hashMap.get(i));
        }
    }

}

