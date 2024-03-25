package DataStructure.Node;

// Entry is object class representing a node into LinkedList table
public class Node<T> {
    private T value;
    private Node<T> next;
    public Node(T data) {
        value = data;
        next = null;
    }

    public Node<T> getNext() {
        return next;
    }

    // Setter method for the next node
    public void setNext(Node<T> nextNode) {
        next = nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
