package srinadh;

public class Steps {
    static int n = 4;
    static int res[]= new int[n+1];
    static {
        for(int i=0;i<=n;i++){
            res[i] = -1;
        }
    }

    public static void main(String[] args){
        System.out.println(getCount(n));
    }

    private static int getCount(int n) {
        if(n==0) res[n] = 1;
        if(n==1) res[n] = 1;
        if(res[n] != -1)
            return res[n];
        else {
            res[n] = getCount(n-1)+getCount(n-2);
        }
        return res[n];
    }
}
