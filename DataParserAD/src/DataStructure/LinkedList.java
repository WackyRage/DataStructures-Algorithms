package DataStructure;

import DataStructure.Node.Node;

public class LinkedList<T> {
    private Node<T> head;

    // Method to add an element to the LinkedList
    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        // Check if Linked list is empty, if true add first value
        if (head == null) {
            head = newNode;
            return;
        }

        // Set current as last head
        Node<T> last = head;
        // Loop until null is found
        while (last.getNext() != null) {
            last = last.getNext();
        }
        // Set new value on null
        last.setNext(newNode);
    }

    // Method to delete an element from the LinkedList by index
    public void delete(T value) {
        if (head == null) {
            throw new RuntimeException("Cannot delete from an empty list.");
        }

        Node<T> temp = head;
        Node<T> prev = null;

        // Check if delete matches head
        if (temp != null && temp.getValue().equals(value)) {
            // Set next node as current node, to adjust for deletion
            head = temp.getNext();
            return;
        }

        // Loop through the nodes to find identical value
        while (temp != null && !temp.getValue().equals(value)) {
            prev = temp;
            temp = temp.getNext();
        }

        if (temp == null) {
            throw new IllegalArgumentException("Value does not exist in the list.");
        }

        // When node is found replace current node with next node.
        prev.setNext(temp.getNext());
    }

    // Method to check if LinkedList contains specific value
    public Boolean contains(T value) {
        Node<T> current = head;
        // Loop through nodes to find given value
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Method to get element from LinkedList by index
    public T get(int index) {
        // Check if index is within bound and LinkedList contains at least one value
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }

        Node<T> current = head;
        int count = 0;

        // Loop through nodes to return correct value
        while (current != null) {
            if (count == index) {
                return current.getValue();
            }
            current = current.getNext();
            count++;
        }

        // If not found throws an error
        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    // Method to get the size of an LinkedList
    public int size() {
        int count = 0;
        Node<T> current = head;
        // Loop through nodes to count size
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    // Method to set value at a specific index in the LinkedList
    public void set(int index, T value) {
        // Check if index is within bound and LinkedList contains at least one value
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }

        Node<T> current = head;
        int count = 0;
        // Loop through nodes unit right index is given
        while (current != null && count < index) {
            current = current.getNext();
            count++;
        }
        // Check to determine if position is valid
        if (current != null) {
            current.setValue(value);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }
}
