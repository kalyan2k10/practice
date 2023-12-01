package kalyan.algo;

import java.util.Arrays;
import java.util.Collections;

public class PalindromePartitionRecurse {
    public static void main(String[] args){
        String s = "geek";
        System.out.println(getMinPalPart(s,0,s.length()-1));
    }

    private static int getMinPalPart(String s, int i, int j) {
        if(isPalindrome(s,i,j)) return 0;
        int res = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            res = Math.min(res, getMinPalPart(s,i,k) + getMinPalPart(s,k+1,j)+1);
        }
        return res;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        char[] ar = s.substring(i,j+1).toCharArray();
        int f=0;
        StringBuffer sb = new StringBuffer();
        for(int k=ar.length-1;k>=0;k--){
            sb.append(ar[k]);
        }
        if(sb.toString().equals(s.substring(i,j+1)))
            return true;
        return false;
    }
}
