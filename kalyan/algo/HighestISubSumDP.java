package kalyan.algo;

import java.util.ArrayList;
import java.util.LinkedList;

public class HighestISubSumDP {
    public static void main(String[] args){
        int[] a = new int[]{2,50,1,3,4};
        int n = a.length;
        int[] d = new int[n+1];
        for(int i=1;i<=n;i++) d[i] = a[i-1];
        for(int i=0;i<=n;i++) System.out.print(" " + d[i]);
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                if(a[j-1] < a[i-1]) {
                    d[i] = Math.max(d[i], a[j-1] + a[i-1]);
                }
            }
        }
        System.out.println();
        for(int i=0;i<=n;i++) System.out.print(" " + d[i]);
    }
}
