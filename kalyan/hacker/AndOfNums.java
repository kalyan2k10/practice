package kalyan.hacker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AndOfNums {
    public static void main(String[] args) {
        String[] str = "722 767 117 717".split(" ");
        System.out.println("x " + (722&117));
        System.out.println("x " + (767&717));
        List<Integer> a = new ArrayList<>();
        for(String s : str) {
            a.add(Integer.parseInt(s));
        }

        int sum = 0;


        for(int i=a.size()/2;i>0;i--) {
            sum += i*getMaxDP(a);
            System.out.println(a);
        }
        System.out.println("sum" + sum);

    }

    public static int getMaxDP(List<Integer> a){
        int n = a.size();
        int[] d = new int[n+1];
        d[1] = a.get(0);
        d[2] = a.get(0) & a.get(1);
//"722 767 117 717".
        int x=0, y=1;
        for(int i=3;i<=n;i++){
            d[i] = d[i-1];
            for(int j=1;j<i;j++){
                if((a.get(i-1) & a.get(j-1)) > d[i]) {
                    d[i] = a.get(i - 1) + a.get(j - 1);
                    x=i-1;
                    y=j-1;
                }
            }
        }
        System.out.println(x + "  " + y);
        if(n>2) {
            a.remove(x);
            a.remove(y-1);
        }
        System.out.println(d[n]);
        return d[n];
    }

    private static int getMaxAnd(int[] a, int n) {
        if(n==1) return a[0];
        if(n==2) return a[0] * a[1];
        int res = getMaxAnd(a,n-1);
        for(int i=0;i<n-1;i++){
            res = Math.max(res, a[n-1] * a[i]);
        }
        return res;
    }

}
