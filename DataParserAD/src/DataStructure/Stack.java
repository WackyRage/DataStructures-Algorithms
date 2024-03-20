package DataStructure;

import DataStructure.Node.Node;

public class Stack<T> {
    private Node<T> node;
    private int size;

    Stack() {
        node = null;
        size = 0;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(node);
        node = newNode;
        size++;
    }

    public T pop() {
        if (node == null) {
            return null;
        }
        T poppedValue = node.getValue();
        node = node.getNext();
        size--;
        return poppedValue;
    }

    public int size() {
        return size;
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Pop elements from the stack
        System.out.println("Popped value: " + stack.pop());
        System.out.println("Popped value: " + stack.pop());

        // Get the size of the stack
        System.out.println("Size of stack: " + stack.size());
    }
}
