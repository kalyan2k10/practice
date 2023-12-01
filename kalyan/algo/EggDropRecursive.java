package kalyan.algo;

public class EggDropRecursive {
    public static void main(String[] args) {
        int f = 10;
        int e = 2;
        System.out.println(getTrials(f,e));
    }

    private static int getTrials(int f, int e) {
        if(f==0) return 0;
        if(e==1) return f;
        if(f==1) return 1;
        int res = Integer.MAX_VALUE;
        for(int x=1;x<=f;x++){
            int subRes = Math.max(getTrials(x-1,e-1), getTrials(f-x, e)) + 1;
            res = Math.min(res, subRes);
        }
        return res;
    }
}
