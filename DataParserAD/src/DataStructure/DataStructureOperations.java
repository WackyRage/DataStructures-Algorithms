package DataStructure;

public interface DataStructureOperations<T> {
    void add(T value);
    LinkedList.Node<T> get(int index);
    void delete(T value);
    Boolean contains(T value);
    int size();
    void set(int index, T value);
}
