package kalyan.algo;

public class FindSubSumWaysRecurse {
    public static void main(String s[]){
        int c[] = new int[] {2,5,3};
        System.out.println(getWays(c, c.length,5));
    }
    public static int getWays(int[] c, int n, int sum) {
        int res =0;
        if(sum==0 && n>=0) return 1;
        if(n==0 && sum>0) return res;

        res = getWays(c,n-1,sum);
        if(sum >= c[n-1]) {
            res += getWays(c,n-1,sum-c[n-1]);
        }
        return res;
    }
}
