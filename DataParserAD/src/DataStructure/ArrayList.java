package DataStructure;

import java.util.Arrays;

public class ArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(int index, T value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        capacity();
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = value;
        this.size++;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (T) elements[index];
    }

    public void delete(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public Boolean contains(T value) {
        for (int i = 0; i < size - 1; i++) {
            if (elements[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public void set(int index, T value) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        elements[index] = value;
    }

    private void capacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public static void main(String[] args) {
        // Create an instance of ArrayList
        ArrayList<String> list = new ArrayList<>();

        // Add elements to the list
        list.add(0, "Bill");
        list.add(1, "Will");
        list.add(2, "David");

        // Print the elements in the list
        System.out.println("Elements in the list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Check if the list contains a value
        String valueToCheck = "David";
        System.out.println("Does the list contain " + valueToCheck + "? " + list.contains(valueToCheck));

        // Delete an element from the list
        int indexToDelete = 1;
        list.delete(indexToDelete);

        // Print the elements in the list after deletion
        System.out.println("Elements in the list after deletion:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Set a new value at a specific index
        int indexToSet = 0;
        String newValue = "Kevin";
        list.set(indexToSet, newValue);

        // Print the elements in the list after setting a new value
        System.out.println("Elements in the list after setting a new value:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
