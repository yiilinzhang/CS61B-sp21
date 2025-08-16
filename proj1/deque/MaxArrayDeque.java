package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    public Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c){
        comparator = c;
    }

    public T Max(){
        T var1 = get(0);
        for (int i = 1; i <size; i++){
            if ( comparator.compare(get(i),var1)>0){
                var1=get(i);
            }
        }
        return var1;
    }

    public T Max(Comparator<T> c){
        T var1 = get(0);
        for (int i = 1; i <size; i++){
            if ( c.compare(get(i),var1)>0){
                var1=get(i);
            }
        }
        return var1;
    }

}
