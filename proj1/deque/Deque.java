package deque;

public interface Deque<T> {

    public int size();

    default public boolean isEmpty(){
        if(size() ==0){
            return true;
        }else{
            return false;
        }
    }
}
