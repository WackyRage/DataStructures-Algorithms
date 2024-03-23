package DataStructure;

import java.util.Arrays;

public class ArrayList<T> {
    // Default capacity of the ArrayList
    private static final int DEFAULT_CAPACITY = 10;
    // Active size of the ArrayList
    private int size = 0;
    private Object[] elements;

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Method to add an element to the ArrayList
    public void add(T value) {
        // If ArrayList is full, increase capacity
        if (size >= elements.length) {
            capacity();
        }

        // Add new item to ArrayList, with current size as index
        elements[size] = value;
        this.size++;
    }

    // Method to get element from ArrayList by index
    public T get(int index) {
        // Check if index is inside ArrayList range.
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (T) elements[index];
    }

    // Method to delete an element from the ArrayList by index
    public void delete(int index) {
        // Check if index is inside ArrayList range.
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        // Shift elements index to minus one to remove the element
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        // Decrease size to account for deletion.
        size--;
    }

    // Method to check if ArrayList contains specific value
    public Boolean contains(T value) {
        // Loop through elements to find given value
        for (int i = 0; i < size - 1; i++) {
            if (elements[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    // Method to get the size of an ArrayList
    public int size() {
        return this.size;
    }

    // Method to set value at a specific index in the ArrayList
    public void set(int index, T value) {
        // Check if index is inside ArrayList range.
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        // Set the value
        elements[index] = value;
    }

    // Method to increase the capacity of the ArrayList, private to avoid abuse of method.
    private void capacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}
