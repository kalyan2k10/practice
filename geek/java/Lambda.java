package geek.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Lambda {
    public static void main(String[] args) {
        class PredicateTest implements Predicate<Integer>{
            @Override
            public boolean test(Integer integer) {
                return integer%2 == 0;
            }
        }

        class ComparableTest implements Comparator<Integer> {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        }

        PredicateTest p = new PredicateTest();
        ComparableTest ct = new ComparableTest();
        List<Integer> al = new ArrayList<>();
        al.add(2);al.add(4);al.add(6);
        testIntegers(al,ct);
    }

    private static void testIntegers(List<Integer> al, Comparator<Integer> p) {
        Collections.sort(al,p);
        for(int x : al)
            System.out.println(x);
    }
}
