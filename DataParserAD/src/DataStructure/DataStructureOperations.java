package DataStructure;

import DataStructure.Node.Node;

public interface DataStructureOperations<K, T> {
    void add(K key, T value);
    void add(T value);
    T get(K key);
    void delete(K key);
    boolean contains(K key);
    int size();
    void set(K key, T value);

}
