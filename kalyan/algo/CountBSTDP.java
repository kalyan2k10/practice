package kalyan.algo;

public class CountBSTDP {
    public static void main(String[] args){
        int n=4;
        int d[] = new int[n+1];
        d[0] = 1;
        d[1] = 1;
        for(int i=2;i<=n;i++){
            for(int x=0;x<=i-1;x++){
                d[i] += d[x]*d[i-1-x];
            }
        }
        System.out.println(d[n]);
    }
}
