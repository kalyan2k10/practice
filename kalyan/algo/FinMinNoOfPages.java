package kalyan.algo;

public class FinMinNoOfPages {
    public static void main(String args[]){
        int a[] = new int[] {10,5,30,1,2,5,10,10};
        int k = 3;
        int n = a.length;
        System.out.println(find(a,n,k));
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
