package kalyan.algo;

public class CountBSTRecur {
    public static void main(String[] args){
        int n=5;
        System.out.println(getCount(n));

    }

    private static int getCount(int n) {
        if(n==0) return 1;
        if(n==1) return 1;
        int sum=0;
        for(int x=0;x<=n-1;x++){
            sum+= getCount(x) * getCount(n-1-x);
        }
        return sum;
    }
}
