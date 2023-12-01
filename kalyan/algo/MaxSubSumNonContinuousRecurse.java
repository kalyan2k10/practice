package kalyan.algo;

public class MaxSubSumNonContinuousRecurse {
    public static void main(String s[]){
        int c[] = new int[] {10,15,5,20,2,30};
        int val = 5;

        System.out.println(getSum(c, c.length-1));
    }
    public static int getSum(int[] c, int n) {
       if(n == 0) return c[0];
       if(n == 1) return Math.max(c[0],c[1]);

       return Math.max(c[n] + getSum(c, n-2), getSum(c,n-1));
    }
}
