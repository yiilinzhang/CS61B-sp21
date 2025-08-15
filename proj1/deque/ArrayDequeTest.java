package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {


    /*Runs addLast, addFirst, removeLast, removeFirst N times to check if it crashes
     */
    @Test
    public void addRemoveTest(){
        ArrayDeque<Integer> test  = new ArrayDeque<>();
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
        ArrayDeque<Integer> test = new ArrayDeque<>();
        assertEquals("A newly initialised array should have size 0", 0 , test.size());
        assertEquals("An empty array should return true for isEmpty", true, test.isEmpty());
        test.addLast(1);
        assertEquals("Array should have correct size 1", 1 , test.size());
        assertEquals("Array should no longer be empty", false, test.isEmpty());

    }

    //Test if the array accepts all types
    @Test
    public void multipleParamTest() {
        ArrayDeque<String>  lld1 = new ArrayDeque<>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }


    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }
}


