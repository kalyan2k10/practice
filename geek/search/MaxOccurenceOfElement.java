package geek.search;

import java.util.Arrays;

public class MaxOccurenceOfElement {
    public static void main(String[] args){
        int[] a = {1,2,3};
        int[] b = {5,10,4};
        int max=10;
        int[] n = new int[max+2];

        for(int i=0;i<a.length;i++){
            n[a[i]] = 1;
            n[b[i]+1] = -1;
        }

        for(int i=1;i<n.length;i++)
            System.out.print(n[i] + " ");
        int currSum = n[1];
        for(int i=2;i<n.length;i++){
            n[i] = n[i] + currSum;
            currSum = n[i];
        }
        System.out.println();
        for(int i=1;i<n.length;i++)
            System.out.print(n[i] + " ");

    }
}
