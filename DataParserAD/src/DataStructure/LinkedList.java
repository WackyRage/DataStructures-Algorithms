package DataStructure;

public class LinkedList<T>  implements DataStructureOperations<T> {
    Node<T> head;

    static class Node<T> {
        T value;
        Node<T> next;

        Node(T data) {
            value = data;
            next = null;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    public void delete(T value) {
        Node<T> temp = head;
        Node<T> prev = null;

        if (temp != null && temp.value == value) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.value != value) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        prev.next = temp.next;
    }

    public Boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Node<T> get(int index) {
        if (index < 0 || head == null) {
            return null; // Invalid index or empty list
        }

        Node<T> current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current;
            }
            current = current.next;
            count++;
        }
        return null;
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void set(int index, T Value) {
        Node<T> node = get(index);
        if (node != null) {
            node.value = Value;
        } else {
            System.out.println("Invalid index. Cannot set value.");
        }
    }
}

//    public static void main(String[] args) {
//        LinkedList<String> linkedList = new LinkedList<>();
//
//        // Append some values
//        linkedList.add("Apple");
//        linkedList.add("Banana");
//        linkedList.add("Orange");
//
//        // Loop through the linked list to print its contents
//        System.out.println("Linked list contents:");
//        Node<String> current = linkedList.head;
//        while (current != null) {
//            System.out.print(current.value + " ");
//            current = current.next;
//        }
//        System.out.println(); // Print a newline after printing the linked list
//
//        // Search for a value by index
//        int index = 1;
//        Node<String> nodeAtIndex = linkedList.get(index);
//        if (nodeAtIndex != null) {
//            System.out.println("Node at index " + index + " contains value: " + nodeAtIndex.value);
//        } else {
//            System.out.println("Node at index " + index + " not found.");
//        }
//
//        for (int i = 0; i < linkedList.size(); i++) {
//            Node<String> node = linkedList.get(i);
//            System.out.print(node.value + " ");
//        }
//
//        System.out.println("Size of the linked list: " + linkedList.size());
//
//        // Search for a value
//        String searchValue = "Banana";
//        if (linkedList.contains(searchValue)) {
//            System.out.println("Value " + searchValue + " found in the list.");
//        } else {
//            System.out.println("Value " + searchValue + " not found in the list.");
//        }
//
//        // Delete a value
//        String deleteValue = "Banana";
//        linkedList.delete(deleteValue);
//        System.out.println("List after deleting " + deleteValue + ":");
//
//        // Loop through the updated linked list to print its contents
//        current = linkedList.head;
//        while (current != null) {
//            System.out.print(current.value + " ");
//            current = current.next;
//        }
//
//        // Change the value at index 1 to "Grapes"
//        int indexToChange = 0;
//        String newValue = "Grapes";
//        linkedList.set(indexToChange, newValue);
//        System.out.println("List after changing value at index " + indexToChange + " to " + newValue + ":");
//
//        for (int i = 0; i < linkedList.size(); i++) {
//            Node<String> node = linkedList.get(i);
//            System.out.print(node.value + " ");
//        }
//
//        System.out.println();
//    }

