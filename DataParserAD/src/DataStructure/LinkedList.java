package DataStructure;

import DataStructure.Node.Node;

public class LinkedList<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> last = head;
        while (last.getNext() != null) {
            last = last.getNext();
        }

        last.setNext(newNode);
    }

    public void delete(T value) {
        if (head == null) {
            throw new RuntimeException("Cannot delete from an empty list.");
        }

        Node<T> temp = head;
        Node<T> prev = null;

        if (temp != null && temp.getValue().equals(value)) {
            head = temp.getNext();
            return;
        }

        while (temp != null && !temp.getValue().equals(value)) {
            prev = temp;
            temp = temp.getNext();
        }

        if (temp == null) {
            throw new IllegalArgumentException("Value does not exist in the list.");
        }

        prev.setNext(temp.getNext());
    }

    public Boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }

        Node<T> current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.getValue();
            }
            current = current.getNext();
            count++;
        }
        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void set(int index, T value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }

        Node<T> current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.getNext();
            count++;
        }
        if (current != null) {
            current.setValue(value);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }
}
