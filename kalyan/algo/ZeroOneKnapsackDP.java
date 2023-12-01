package kalyan.algo;

public class ZeroOneKnapsackDP {
    public static void main(String s[]){
        int v[] = new int[] {1,2,3};
        int w[] = new int[] {1,2,3};
        int W = 5;


        int d[][] = new int[W+1][v.length+1];
        for(int i=1;i<=W;i++){
            for(int j=1;j<=v.length;j++){
                d[i][j] = d[i][j-1];
                if(w[j-1] <= i) {
                    d[i][j] = Math.max(d[i][j], v[j-1] + d[i-w[j-1]][j-1]);
                }
            }
        }
        for(int i=1;i<=W;i++) {
            for (int j = 1; j <= v.length; j++) {
                System.out.print(d[i][j]+" ");
            }
            System.out.println();
        }
        //System.out.println(d[W][v.length]);
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
