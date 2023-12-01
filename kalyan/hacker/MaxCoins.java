package kalyan.hacker;

import java.util.ArrayList;
import java.util.List;

//[2,5,1,6,2,7] - array
///////////////////////////////////////////////////////////////////////////
// s
// f
///////////////////////////////////////////////////////////////////////////
//[0,1,2,3,4,5]

public class MaxCoins {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        int val = 7;
        List<Integer> coins = new ArrayList<>();
        System.out.println(getCoins(a,a.length, val, coins));
        System.out.println(coins);
    }

    private static int getCoins(int[] a, int len, int val, List<Integer> coins) {
        int res = 9999999;
        if(len>=0 && val==0){
            return 0;
        }
        if(len==0 && val>0){
            return res;
        }
        else {
            res = getCoins(a, len-1, val, coins);   // f(3,5) = Math.min(f(2,5),1+f(2,0))
            if(val >= a[len-1]) {
                List<Integer> subList = new ArrayList<>();
                int subRes = 1 + getCoins(a, len-1, val-a[len-1], subList); // 1+ f(1,1)
                if(subRes < res) {
                    res = subRes;
                    subList.add(a[len-1]);
                    coins.clear();
                    coins.addAll(subList);
                }
            }
        }
        return res;
    }
}
