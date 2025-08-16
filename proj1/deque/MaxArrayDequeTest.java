package deque;

import org.junit.Test;

import java.util.Comparator;

public class MaxArrayDequeTest {

    public class comparator1 implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }

    public class comparator2 implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

    public class comparator3 implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return o1.length()- o2.length();
        }
    }

    @Test
    public void constructorTestInt(){
        MaxArrayDeque<Integer> test = new MaxArrayDeque<>(new comparator1());
        test.addFirst(1);
        test.addFirst(2);
        test.addLast(4);
        System.out.println(test.Max());
        System.out.println(test.Max(new comparator2()));

    }


@Test
public void constructorTestStr(){
    MaxArrayDeque<String> test = new MaxArrayDeque<>(new comparator3());
    test.addFirst("hello");
    test.addFirst("medium hello");
    test.addLast("longgggg hello");
    System.out.println(test.Max());
}
}
