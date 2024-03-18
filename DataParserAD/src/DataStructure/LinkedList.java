package DataStructure;

import DataStructure.Node.Node;

public class LinkedList<T>  implements DataStructureOperations<T> {
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
    public void delete(T value) {
        Node<T> temp = head;
        Node<T> prev = null;

        if (temp != null && temp.getNext() == value) {
            head = temp.getNext();
            return;
        }

        while (temp != null && temp.getNext() != value) {
            prev = temp;
            temp = temp.getNext();
        }

        if (temp == null) {
            return;
        }

        prev.setNext(temp.getNext());
    }

    @Override
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

    @Override
    public Node<T> get(int index) {
        if (index < 0 || head == null) {
            return null; // Invalid index or empty list
        }

        Node<T> current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current; // Return the value stored in the node
            }
            current = current.getNext();
            count++;
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
    public void set(int index, T Value) {
        Node<T> node = (Node<T>) get(index);
        if (node != null) {
            node.setValue(Value);
        } else {
            System.out.println("Invalid index. Cannot set value.");
        }
    }


    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        // Append some values
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Orange");

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
        String nodeAtIndex = linkedList.get(index).getValue();
        if (nodeAtIndex != null) {
            System.out.println("Node at index " + index + " contains value: " + nodeAtIndex);
        } else {
            System.out.println("Node at index " + index + " not found.");
        }

        // Print the linked list using a loop
        System.out.println("Linked list contents using loop:");
        for (int i = 0; i < linkedList.size(); i++) {
            String node = linkedList.get(i).getValue();
            System.out.print(node + " ");
        }
        System.out.println(); // Print a newline after printing the linked list

        // Print the size of the linked list
        System.out.println("Size of the linked list: " + linkedList.size());

        // Search for a value
        String searchValue = "Banana";
        if (linkedList.contains(searchValue)) {
            System.out.println("Value " + searchValue + " found in the list.");
        } else {
            System.out.println("Value " + searchValue + " not found in the list.");
        }

        // Delete a value
        String deleteValue = "Banana";
        linkedList.delete(deleteValue);
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
        linkedList.set(indexToChange, newValue);
        System.out.println("List after changing value at index " + indexToChange + " to " + newValue + ":");

        // Print the linked list using a loop
        System.out.println("Linked list contents after value change:");
        for (int i = 0; i < linkedList.size(); i++) {
            String node = linkedList.get(i).getValue();
            System.out.print(node + " ");
        }
        System.out.println(); // Print a newline after printing the linked list
    }
}
