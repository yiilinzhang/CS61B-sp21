package deque;

import java.util.Iterator;

public interface Deque<T> {

    public int size();
    public void addFirst(T item);
    public void addLast(T item);
    public void printDeque();
    public T removeFirst();
    public T removeLast();
    public T get(int index);
    public Iterator<T> iterator();
    public boolean equals(Object o);

    default public boolean isEmpty(){
        if(size() ==0){
            return true;
        }else{
            return false;
        }
    }
}
