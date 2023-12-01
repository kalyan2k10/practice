package kalyan.algo;

public class FindSubSumWaysDP {
    public static void main(String s[]){
        int c[] = new int[] {2,5,3};
        int sum = 5;
        int n = c.length;
        int[][] d = new int[sum+1][n+1];
        for(int i=0;i<=n;i++) d[0][i] = 1;
        for(int i=1;i<=sum;i++){
            for(int j=1;j<=n;j++){
                d[i][j] = d[i][j-1];
                if(i>=c[j-1]) {
                    d[i][j] += d[i-c[j-1]][j-1];
                }
            }
        }
        for(int i=0;i<=sum;i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(" " + d[i][j]);
            }
            System.out.println();
        }
    }
}
