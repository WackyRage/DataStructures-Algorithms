package DataStructure;

import DataStructure.Node.Node;

public class LinkedList<K, T>  implements DataStructureOperations<K, T> {
    private Node<T> head;

    @Override
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

    @Override
    public void add(K key, T value) {
        throw new UnsupportedOperationException("Linked list does not require a key for adding elements.");
    }


    @Override
    public void delete(K key) {
        Node<T> temp = head;
        Node<T> prev = null;

        if (temp != null && temp.getValue().equals(key)) {
            head = temp.getNext();
            return;
        }

        while (temp != null && !temp.getValue().equals(key)) {
            prev = temp;
            temp = temp.getNext();
        }

        if (temp == null) {
            return;
        }

        prev.setNext(temp.getNext());
    }

    @Override
    public boolean contains(K key) {
        Node<T> current = head;
        while (current != null) {
            if (current.getValue().equals(key)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public T get(K key) {
        if (key instanceof Integer) {
            int index = (Integer) key;
            if (index < 0 || head == null || index >= size()) {
                return null;
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
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public void set(K key, T value) {
        if (key instanceof Integer) {
            int index = (Integer) key;
            Node<T> current = head;
            int count = 0;
            while (current != null && count < index) {
                current = current.getNext();
                count++;
            }
            if (current != null) {
                current.setValue(value);
            } else {
                System.out.println("Invalid index");
            }
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer, String> linkedList = new LinkedList<>();

        // Append some values
        linkedList.add(1, "Apple");
        linkedList.add(2, "Banana");
        linkedList.add(3, "Orange");

        // Loop through the linked list to print its contents
        System.out.println("Linked list contents:");
        Node<String> current = linkedList.head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println(); // Print a newline after printing the linked list

        // Search for a value by index
        int index = 1;
        String nodeAtIndex = linkedList.get(index);
        if (nodeAtIndex != null) {
            System.out.println("Node at index " + index + " contains value: " + nodeAtIndex);
        } else {
            System.out.println("Node at index " + index + " not found.");
        }

        // Print the linked list using a loop
        System.out.println("Linked list contents using loop:");
        for (int i = 0; i < linkedList.size(); i++) {
            String node = linkedList.get(i);
            System.out.print(node + " ");
        }
        System.out.println(); // Print a newline after printing the linked list

        // Print the size of the linked list
        System.out.println("Size of the linked list: " + linkedList.size());

        // Search for a value
        String searchValue = "Banana";
        if (linkedList.contains(Integer.parseInt(searchValue))) {
            System.out.println("Value " + searchValue + " found in the list.");
        } else {
            System.out.println("Value " + searchValue + " not found in the list.");
        }

        // Delete a value
        String deleteValue = "Apple";
        linkedList.delete(Integer.parseInt(deleteValue));
        System.out.println("List after deleting " + deleteValue + ":");

        // Loop through the updated linked list to print its contents
        System.out.println("Linked list contents after deletion:");
        current = linkedList.head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println(); // Print a newline after printing the linked list

        // Change the value at index 0 to "Grapes"
        int indexToChange = 0;
        String newValue = "Grapes";
        linkedList.set(Integer.parseInt(String.valueOf(indexToChange)), newValue);
        System.out.println("List after changing value at index " + indexToChange + " to " + newValue + ":");

        // Print the linked list using a loop
        System.out.println("Linked list contents after value change:");
        for (int i = 0; i < linkedList.size(); i++) {
            String node = linkedList.get(i);
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
