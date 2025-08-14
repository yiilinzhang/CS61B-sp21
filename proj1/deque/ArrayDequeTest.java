package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {


    /*Runs addLast, addFirst, removeLast, removeFirst N times to check if it crashes
     */
    @Test
    public void addRemoveTest(){
        ArrayDeque test  = new ArrayDeque();
        int N = 5000;
        for(int i = 0; i<N; i++){
            int actionNo= StdRandom.uniform(0, 5);
            if(actionNo==0){
                test.addFirst(i);
            }else if (actionNo == 1){
                test.addLast(i);
            }else if (actionNo == 2){
                test.removeFirst();
            } else if (actionNo == 3) {
                test.removeLast();
            }else{
                test.get(test.size / 2);
            }
        }

    }

    //checks if isEmpty returns true when array is empty and false otherwise
    @Test
    public void isEmptyTest(){
        ArrayDeque test = new ArrayDeque();
        assertEquals("A newly initialised array should have size 0", 0 , test.size());
        assertEquals("An empty array should return true for isEmpty", true, test.isEmpty());
        test.addLast(1);
        assertEquals("Array should have correct size 1", 1 , test.size());
        assertEquals("Array should no longer be empty", false, test.isEmpty());

    }

    //Test if the array accepts all types
    @Test
    public void multipleParamTest() {
        ArrayDeque<String>  lld1 = new ArrayDeque<String>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }



}
