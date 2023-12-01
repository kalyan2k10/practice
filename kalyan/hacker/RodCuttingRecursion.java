package kalyan.hacker;

public class RodCuttingRecursion {
    public static void main(String[] args){
        int[] ar = new int[] {3,2};
        int sum = 8;
        int[][] d = new int[sum+1][ar.length+1];
        for(int i=0;i<=ar.length;i++) d[0][i] = 0;
        for(int i=1;i<=sum;i++){
            for(int j=1;j<=ar.length;j++){
                d[i][j] = d[i][j-1];
                if(i>=ar[j-1]) {
                    d[i][j] = Math.max(d[i][j], 1+d[i-ar[j-1]][j]);
                }
            }
        }
        for(int i=1;i<=sum;i++){
            for(int j=1;j<=ar.length;j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(findMaxWays(ar,ar.length, sum));
    }

    private static int findMaxWays(int[] ar, int n, int sum) {
        int res = Integer.MIN_VALUE;
        if(n>0 && sum==0) return 0;
        if(n>=1) {
            res = findMaxWays(ar, n-1, sum);
            if(sum >= ar[n-1])
                res = Math.max(res, 1+findMaxWays(ar, n, sum - ar[n-1]));
        }
        return res;
    }
}
