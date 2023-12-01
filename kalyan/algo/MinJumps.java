package kalyan.algo;

import java.util.Arrays;

public class MinJumps {
    public static void main(String s[]) {
        int a[] = new int[]{3,4,2,1,2,1};
        System.out.println(minJumps(a,a.length));
    }

    private static int minJumps(int[] a, int length) {
       if(length==1) return 0;
       int res = Integer.MAX_VALUE;
       for(int i=0;i<=length-2;i++){
           if(i+a[i] >= length-2){
               int subRes = minJumps(a, i+1);
               if(subRes != Integer.MAX_VALUE) {
                   res = Math.min(res, subRes+1);
               }
           }
       }
       return res;
    }
}
