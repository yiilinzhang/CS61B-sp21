package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> testAlist = new AListNoResizing();
        BuggyAList<Integer> testBuggyAlist = new BuggyAList();
        //adds range(4,7) to alist and buggyalist via iteration
        for (int x = 4; x<=6; x++){
            testAlist.addLast(x);
            testBuggyAlist.addLast(x);
        }

        for (int repeat = 0 ; repeat <= 2; repeat++){
        //checks that the sizes are equal
        assertEquals(testAlist.size(), testBuggyAlist.size());
        //iterates through the whole array and checked that every element is equal
        for (int i =0; i<testAlist.size(); i++){
            assertEquals(testAlist.get(i), testBuggyAlist.get(i));
        }
    }}

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> Buggy = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                Buggy.addLast(randVal);
                assertEquals(L.getLast(), Buggy.getLast());
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeBuggy = Buggy.size();
                assertEquals(size, sizeBuggy);
            }else if (operationNumber == 2 && L.size()>0){
                int lastVar = L.getLast();
                int lastVarBuggy = Buggy.getLast();
                int varRemoved = L.removeLast();
                int varRemovedBuggy = Buggy.removeLast();
                assertEquals(varRemoved, varRemovedBuggy);
                assertEquals(lastVar, lastVarBuggy);
                System.out.println("getLast(" +lastVar+ ")" + "getLastBuggy(" +lastVarBuggy+ ")");
            }
        }}
}
