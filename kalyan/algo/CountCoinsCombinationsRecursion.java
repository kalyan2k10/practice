package kalyan.algo;

public class CountCoinsCombinationsRecursion {
    public static void main(String s[]){
        int c[] = new int[] {1,2,3};
        int sum = 4;

        System.out.println(getCount(c, c.length, sum));
    }
    public static int getCount(int[] c, int n, int sum) {
        if(sum==0) return 1;
        if(n==0) return 0;
        int subRes = getCount(c,n-1,sum);
        if(c[n-1]<=sum) {
            subRes += getCount(c,n,sum-c[n-1]);
        }
        return subRes;
    }


}
