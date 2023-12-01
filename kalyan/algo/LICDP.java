package kalyan.algo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class LICDP {
    public static void main(String[] args){
        int[] a = new int[]{-1,2,3,4};
        int n = a.length;
        int[] d = new int[n+1];
        for(int i=1;i<=n;i++) d[i] = 1;
        ArrayList<LinkedList<Integer>> al = new ArrayList<>(n+1);
        for(int i=0;i<=n;i++)
            al.add(new LinkedList<>());
        al.get(1).add(0);
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                if(a[j-1] < a[i-1]) {
                    if(d[i] < d[j] + 1){
                        d[i] = d[j] + 1;
                        al.get(i).add(j-1);
                    }
                }
            }
            al.get(i).add(i-1);
        }
        for(int i=0;i<=n;i++) System.out.print(" " + d[i]);
        System.out.println();
        for(int i=0;i<al.size();i++) {
            al.get(i).forEach(e -> { System.out.print(" " + e);});
            System.out.println();
        }

    }
}
