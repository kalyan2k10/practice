package kalyan.algo;

public class ZeroOneKnapsack {
    public static void main(String s[]){
        int v[] = new int[] {60,100,120};
        int w[] = new int[] {10,20,30};
        int n = v.length;
        int W = 50;

        System.out.println(getWeight(v,w,n,W));
    }
    public static int getWeight(int[] v, int[] w, int n, int W) {
        if(n==0) return 0;
        if(W==0) return 0;
        int res = getWeight(v,w,n-1,W);
        if(w[n-1] <= W) {
            res = Math.max(res, v[n-1] + getWeight(v,w,n-1,W-w[n-1]));
        }
        return res;
    }
}
