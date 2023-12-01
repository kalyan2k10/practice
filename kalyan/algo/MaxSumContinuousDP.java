package kalyan.algo;

public class MaxSumContinuousDP {
    public static void main(String s[]){
        int c[] = new int[] {4,0,-3,0,10,0,0,-10};
        System.out.println();
        int n = c.length;
        int[] d = new int[n+1];
        d[1] = c[0];
        d[2] = Math.max(Math.max(c[1]+c[0],c[0]), c[1]);
        for(int i=3;i<=n;i++){
            int sr = Math.max(d[i-2] + c[i-2] + c[i-1], c[i-2] + c[i-1]);
            d[i] = Math.max(sr,c[i-1]);
            if(d[i] == 0) System.out.println("yes");
        }
        for(int i=1;i<=n;i++) {
            System.out.print(" " + d[i]);
        }
    }
    public static int getSum(int[] c, int n) {
        if(n==0) return 0;
        if(n==1) return c[0];
        if(n==2) return Math.max(Math.max(c[0]+c[1],c[1]),c[0]);
        int sr = Math.max(getSum(c,n-2) + c[n-2] + c[n-1], c[n-1]+c[n-2]);
        return Math.max(sr, c[n-1]);
    }
}
