package deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int arraySize;
    private T[] array;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        arraySize = 8;
        size = 0;
        array = (T[]) new Object[8];
        nextFirst = 3;
        nextLast = 4;
    }

    @Override
    public T removeFirst() {
        int removeIndex = nextFirst + 1;
        T removedItem = null;
        if (nextFirst == arraySize-1) {
            removeIndex = 0;
        }
        if (size != 0) {
            size--;
            removedItem = array[removeIndex];
            array[removeIndex] = null;
            nextFirst = removeIndex;
        }
        if (size < arraySize / 4) {
            resize();
        }
        return removedItem;
    }

    //returns the x's item of the array

    @Override
    public T get(int index) {
        int arrayIndex = nextFirst;
        for (int i = 0; i <= index; i++) {
            if (arrayIndex == arraySize - 1) {
                arrayIndex = 0;
            } else {
                arrayIndex++;
            }
        }
        return array[arrayIndex];
    }

    //removes and returns the last item in the list
    @Override
    public T removeLast() {
        int removeIndex = nextLast - 1;
        T removedItem = null;
        if (nextLast == 0) {
            removeIndex = arraySize - 1;
        }
        if (size != 0) {
            size--;
            removedItem = array[removeIndex];
            array[removeIndex] = null;
            nextLast = removeIndex;
        }
        if (size < arraySize / 4) {
            resize();
        }
        return removedItem;
    }

    //returns the number of elements in the array
    @Override
    public int size() {
        return size;
    }

    //helper function to check if a resize is necessary when adding elements
    private void checkIncSize() {
        if (arraySize == size) {
            resize();
        }
    }

    //adds the parameter to the front of the array
    @Override
    public void addFirst(T x) {
        checkIncSize();
        size += 1;
        array[nextFirst] = x;
        if (nextFirst == 0) {
            nextFirst = arraySize - 1;
        } else {
            nextFirst -= 1;
        }
    }

    //adds the parameter to the back of the array
    @Override
    public void addLast(T x) {
        checkIncSize();
        size += 1;
        array[nextLast] = x;
        if (nextLast == arraySize - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }

    //resizes the array up or down
    private void resize() {
        int copyIndex;
        if (nextFirst == arraySize - 1) {
            copyIndex = 0;
        } else {
            copyIndex = nextFirst + 1;
        }

        if (size < arraySize / 4) {
            T[] newDecArray = (T[]) new Object[arraySize / 4];
            resizeHelper(array, newDecArray, copyIndex, size);
            array = newDecArray;
            arraySize = arraySize / 4;
        } else {
            T[] newIncArray = (T[]) new Object[arraySize * 2];
            resizeHelper(array, newIncArray, copyIndex, size);
            array = newIncArray;
            arraySize = arraySize * 2;
        }
        nextFirst = arraySize - 1;
        nextLast = size;
    }

    //helper function for resize - custom copy array func
    private void resizeHelper(T[] source, T[] destination, int startIndexSource, int length) {
        for (int i = 0; i < length; i++) {
            if (startIndexSource == arraySize) {
                startIndexSource = 0;
            }
            destination[i] = source[startIndexSource];
            startIndexSource++;
        }
    }

    @Override
    public void printDeque() {
        String toPrint = "";
        for (int i = 0; i < size; i++) {
            toPrint += get(i) + " ";
        }
        System.out.println(toPrint);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Deque) {
            Deque<T> linked = (Deque<T>) o;
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

    private class ArrayDequeIterator implements Iterator<T> {
        int wizPos;

        ArrayDequeIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            if (wizPos < size) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            T item = get(wizPos);
            wizPos += 1;
            return item;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }
}
