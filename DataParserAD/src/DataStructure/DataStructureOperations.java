package DataStructure;

import DataStructure.Node.Node;

public interface DataStructureOperations<T> {
    void add(T value);
    Node<T> get(int index);
    void delete(T value);
    Boolean contains(T value);
    int size();
    void set(int index, T value);
}
