package kalyan.algo;

public class EggDropDP {
    public static void main(String[] args) {
        int f = 10;
        int e = 2;
        int[][] d = new int[f+1][e+1];
        for(int i=0;i<=f;i++){
            d[i][1] = i;
        }
        for(int i=0;i<=e;i++){
            d[1][e] = 1;
        }

        for(int i=2;i<=f;i++){
            for(int j=2;j<=e;j++){
                d[i][j] = Integer.MAX_VALUE;
                for(int x=1;x<=i;x++){
                    d[i][j] = Math.min(d[i][j], 1 + Math.max(d[x-1][j-1],d[i-x][j]));
                }
            }
        }
        for(int i=0;i<=f;i++) {
            for (int j = 0; j <= e; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
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
