package kalyan.algo;

public class FinMinNoOfPagesDP {
    public static void main(String args[]){
        int a[] = new int[] {10,5,30,1,2,5,10,10};
        int k = 3;
        int n = a.length;
        int[][] d = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            d[i][1] = getSum(a,0,i-1);
        }
        for(int i=1;i<=k;i++){
            d[1][i] = a[0];
        }
        for(int i=1;i<=n;i++){
            for(int j=2;j<=k;j++){
                d[i][j] = Integer.MAX_VALUE;
                for(int x=1;x<i;x++){
                    d[i][j] = Math.min(d[i][j], Math.max(d[x][j-1],getSum(a,x,i-1)));
                }
            }
            System.out.println();
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int find(int[] a, int n, int k) {
        if(k==1) return getSum(a,0,n-1);
        if(n==0) return a[0];
        int res = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            res = Math.min(res, Math.max(find(a,i,k-1),getSum(a,i,n-1)));
        }
        return res;
    }

    private static int getSum(int[] a, int s, int e){
        int sum =0;
        for(int i=s;i<=e;i++){
            sum+=a[i];
        }
        return sum;
    }
}
