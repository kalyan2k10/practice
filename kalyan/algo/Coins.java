package kalyan.algo;

public class Coins {
    public static void main(String[] args){
        int[] a = {1,2,3};
        int val = 4;
        System.out.println(getAllWaysInfinite(a, val,a.length));
    }

    private static int giveMaxCoinsinfiniteFor(int[] c, int val) {
        if(val==0) return 0;

        int res = Integer.MIN_VALUE;
        for(int i=0;i<c.length;i++) {
            if(val>=c[i]) {
                int subRes = giveMaxCoinsinfiniteFor(c, val - c[i]);
                if (subRes != Integer.MIN_VALUE) {
                    res = Math.max(res, subRes + 1);
                }
            }
        }
        return res;
    }

    private static int giveMaxCoinsfinite(int[] a, int val, int len) {
        if(val==0 && len>=0) return 0;
        if(val>0 && len==0) return Integer.MIN_VALUE;
        int res = giveMaxCoinsfinite(a, val, len-1);
        if(val >= a[len-1]) {
            int subRes = giveMaxCoinsfinite(a, val-a[len-1], len-1);
            if(subRes != Integer.MIN_VALUE){
                res = Math.max(res, subRes+1);
            }
        }
        return res;
    }

    private static int giveMinCoinsfinite(int[] a, int val, int len) {
        if(val==0 && len>=0) return 0;
        if(val>0 && len==0) return Integer.MAX_VALUE;
        int res = giveMinCoinsfinite(a, val, len-1);
        if(val >= a[len-1]) {
            int subRes = giveMinCoinsfinite(a, val-a[len-1], len-1);
            if(subRes != Integer.MAX_VALUE){
                res = Math.min(res, subRes+1);
            }
        }
        return res;
    }

    private static int giveMinCoinsInfinite(int[] a, int val, int len) {
        if(val==0 && len>=0) return 0;
        if(val>0 && len==0) return Integer.MAX_VALUE;
        int res = giveMinCoinsInfinite(a, val, len-1);
        if(val >= a[len-1]) {
            int subRes = giveMinCoinsInfinite(a, val-a[len-1], len);
            if(subRes != Integer.MAX_VALUE){
                res = Math.min(res, subRes+1);
            }
        }
        return res;
    }

    private static int giveMaxCoinsInfinite(int[] a, int val, int len) {
        if(val==0 && len>=0) return 0;
        if(val>0 && len==0) return Integer.MIN_VALUE;
        int res = giveMaxCoinsInfinite(a, val, len-1);
        if(val >= a[len-1]) {
            int subRes = giveMaxCoinsInfinite(a, val-a[len-1], len);
            if(subRes != Integer.MIN_VALUE){
                res = Math.max(res, subRes+1);
            }
        }
        return res;
    }



    private static int getAllWaysfinite(int[] a, int val, int len) {
        if(val==0) return 1;
        if(val>0 && len==0) return 0;

        int res = getAllWaysfinite(a, val,len-1);
        if(val >= a[len-1]) {
            res += getAllWaysfinite(a,val-a[len-1], len-1); // 1+f(1,2)
        }
        return res;
    }

    private static int getAllWaysInfinite(int[] a, int val, int len) {
        if(len>0 && val==0) return 1;
        if(val>0 && len==0) return 0;

        int res = getAllWaysInfinite(a, val,len-1);
        if(val >= a[len-1]) {
            res += getAllWaysInfinite(a,val-a[len-1], len); // 1+f(1,2)
        }
        return res;
    }
}
