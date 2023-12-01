package kalyan.algo;

public class StrategyGameRecurseKal {
    public static void main(String s[]){
        //int a[] = new int[] {20,5,4,6};
        int a[] = new int[] {2,3,15,7};
        int res[][] = new int[a.length][a.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                res[i][j] = -1;
            }
        }
        System.out.println("val is " + getMax(a,0,a.length-1, res));

    }
    public static int getMax(int[] a, int s, int e, int[][] res) {

        if(s==e-1) res[s][e] = Math.max(a[s],a[e]);
        if(res[s][e] !=-1) return res[s][e];
        int x;
        if(a[s+1] > a[e]){
            x = getMax(a,s+2,e,res);
        }else{
            x = getMax(a,s+1,e-1,res);
        }
        int y;
        if(a[s] > a[e-1]){
            y = getMax(a,s+1,e-1,res);
        } else {
            y = getMax(a,s,e-2,res);
        }
        res[s][e] = Math.max(a[s] + x, a[e] + y);
        return res[s][e];
    }
}
