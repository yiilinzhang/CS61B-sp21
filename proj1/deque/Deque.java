package deque;

import java.util.Iterator;

public interface Deque<T> {

    int size();
    void addFirst(T item);
    void addLast(T item);
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
    Iterator<T> iterator();
    default boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }
}
