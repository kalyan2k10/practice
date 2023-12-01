package geek.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAdjacencyList {
    public static void main(String[] args){
        List<List<Integer>> res = new ArrayList<>(5);
        for(int i=0;i<5;i++) {
            List<Integer> sub = new ArrayList<>();

        }
        res.stream().forEach(e -> {
            e.stream().forEach(x -> System.out.print(" " + x));
            System.out.println();
        });
    }

}
