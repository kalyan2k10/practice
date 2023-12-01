package kalyan.algo;

public class MaxSumContinuousRecurse {
    public static void main(String s[]){
        int c[] = new int[] {-4,3,-1,2};
        System.out.println(getSum(c, c.length));
    }
    public static int getSum(int[] c, int n) {
        if(n==0) return 0;
        if(n==1) return c[0];
        if(n==2) return Math.max(Math.max(c[0]+c[1],c[1]),c[0]);
        int sr = Math.max(getSum(c,n-2) + c[n-2] + c[n-1], c[n-1]+c[n-2]);
        return Math.max(sr, c[n-1]);
    }
}
