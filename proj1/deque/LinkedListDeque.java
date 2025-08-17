package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>{

    private class Node{
        T item ;
        Node next ;
        Node prev ;
        private Node(T i, Node p, Node n){
            item = i;
            next = n;
            prev = p;
        }
    }

    private int size;
    private Node sentinel;
    private Node getHelper;

    //Initialises the first Linkedlist
    public LinkedListDeque(){
        size=0;
        sentinel= new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        getHelper = sentinel;
    }

    //Adds an item of type T to the front of the deque. You can assume that item is never null.
    @Override
    public void addFirst(T item){
        size +=1;
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev= newNode;
        sentinel.next = newNode;
    }

    //Adds an item of type T to the back of the deque. You can assume that item is never null.
    @Override
    public void addLast(T item){
        size+=1;
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
    }

    //Returns true if deque is empty, false otherwise.

    //Returns the number of items in the deque.
    @Override
    public int size(){return size;}

    /*Prints the items in the deque from first to last, separated by a space.
    Once all the items have been printed, print out a new line.
     */
    @Override
    public void printDeque(){
        Node tempPointer= sentinel;
        String toPrint = "";
        for (int i = 0; i<size; i++){
            tempPointer= tempPointer.next;
            toPrint += tempPointer.item + " ";
        }
        System.out.println(toPrint);
    }

    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
    @Override
    public T removeFirst(){
        if(size ==0){
            return null;
        }
        size -=1;
        Node firstItem = sentinel.next;
        sentinel.next = firstItem.next;
        firstItem.next.prev=sentinel;
        return firstItem.item;
    };

    //Removes and returns the item at the back of the deque. If no such item exists, returns null.
    @Override
    public T removeLast(){
        if(size ==0){
            return null;
        }
        size -=1;
        Node lastItem = sentinel.prev;
        sentinel.prev=lastItem.prev;
        lastItem.prev.next=sentinel;
        return lastItem.item;
    }

    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
    @Override
    public T get(int index){
        Node tempPointer = sentinel;
        for(int i = 0 ; i<=index; i++){
            tempPointer = tempPointer.next;
        }
        return tempPointer.item;

    }

    public T getRecursive(int index) {
        T returnItem = null;
        if (index == 0) {
            returnItem = getHelper.next.item;
            getHelper = sentinel;
        } else {
            getHelper = getHelper.next;
        }
        return returnItem;
    }

    private class ListDequeIterator implements Iterator<T> {
        int wizPos;

        public ListDequeIterator(){
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            if (wizPos < size){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            T item = get(wizPos);
            wizPos += 1;
            return item;
        }}

    @Override
    public Iterator<T> iterator(){
        return new ListDequeIterator();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof LinkedListDeque) {
            LinkedListDeque<?> linked = (LinkedListDeque<?>) o;
            if (size != linked.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!get(i).equals(linked.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


}
