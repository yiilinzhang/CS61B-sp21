package deque;

public class ArrayDeque {
    int arraySize;
    int[] array;
    int nextFirst;
    int nextLast;
    int size;

    ArrayDeque(){
        arraySize=8;
        size=0;
        array = new int[8];
        nextFirst = 3;
        nextLast=4;
    }

    /*Methods implemented
    * 1.removeFirst()
    * 2.removeLast()
    * 3.get(index)
    * 4.addLast()
    * 5.addFirst()
    * 6.size()*/

    //removes and returns the first item in the list
    public int removeFirst(){
        int removeIndex = nextFirst+1;
        int removedItem = 0;
        if (nextFirst== arraySize-1){
            removeIndex = 0;
        }
        if (size!=0){
            size --;
            removedItem = array[removeIndex];
            nextFirst = removeIndex;
        }
        return removedItem;
    }


    //returns the x's item of the array
    public int get(int index){
        int arrayIndex = nextFirst;
        for(int i = 0; i<=index; i++){
            if(arrayIndex == arraySize-1){
                arrayIndex=0;
            }else{
                arrayIndex++;
            }
        }
        return array[arrayIndex];
    }

    //removes and returns the last item in the list
    public int removeLast(){
        int removeIndex = nextLast-1;
        int removedItem = 0;
        if (nextLast==0){
            removeIndex = arraySize-1;
        }
        if (size != 0){
            size --;
            removedItem = array[removeIndex];
            nextLast = removeIndex;
        }
        return removedItem;
    }


    //return true is the array is empty and false otherwise
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }else{
            return false;
        }
    }

    //returns the number of elements in the array
    public int size(){
        return size;
    }

    //helper function to check if a resize is necessary when adding elements
    private void checkIncSize(){
        if (arraySize==size){
            resize();
        }
    }

    //adds the parameter to the front of the array
    public void addFirst(int T){
        checkIncSize();
        size+=1;
        array[nextFirst]=T;
        if (nextFirst==0){
            nextFirst=arraySize-1;
        }else{
        nextFirst-=1;}
    }

    //adds the paramenter to the back of the array
    public void addLast(int T){
        checkIncSize();
        size+=1;
        array[nextLast] = T;
        if (nextLast == arraySize-1){
            nextLast=0;
        }else{
        nextLast+=1;}
    }

    //resizes the array up or down
    private void resize(){
        int copyIndex;
        if (nextFirst == size-1){
            copyIndex = 0;
        }else{
            copyIndex= nextFirst+1;
        }

        if (size< arraySize / 4){
            int[] newDecArray = new int[arraySize / 4];
            resizeHelper(array, newDecArray, copyIndex , size);
            array= newDecArray;
            arraySize= arraySize / 4;
        }else{
            int[] newIncArray = new int[arraySize*2];
            resizeHelper(array, newIncArray, copyIndex, size);
            array = newIncArray;
            arraySize = arraySize*2;
        }
        nextFirst = arraySize-1;
        nextLast = size;

    }

    //helper function for resize - custom copy array func
    //default start copying into destination array at index 0
    private void resizeHelper(int[] source, int[] destination, int startIndexSource, int length){
        for(int i = 0 ; i <length; i++){
            if (startIndexSource == arraySize){
                startIndexSource=0;
            }
            destination[i] = source[startIndexSource];
            startIndexSource ++;
        }
    }
}
