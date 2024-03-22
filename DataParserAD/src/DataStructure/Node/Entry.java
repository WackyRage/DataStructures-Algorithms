package DataStructure.Node;

public class Entry<K, T> {
    private K key;
    private T value;
    private Entry<K, T> next;

    public Entry(K key, T value, Entry<K, T> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Entry<K, T> getNext() {
        return next;
    }

    public void setNext(Entry<K, T> next) {
        this.next = next;
    }
}
