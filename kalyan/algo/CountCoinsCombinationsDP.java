package kalyan.algo;

public class CountCoinsCombinationsDP {
    public static void main(String s[]){
        int c[] = new int[] {1,2,3};
        int sum = 4;
        int d[][] = new int[sum+1][c.length+1];
        for(int i=0;i<=sum;i++) d[i][0] = 0;
        for(int i=0;i<=c.length;i++) d[0][i] = 1;

        for(int i=1;i<=sum;i++) {
            for(int j=1;j<=c.length;j++) {
                d[i][j] = d[i][j-1];
                if(c[j-1] <= i) {
                    d[i][j]+=d[i-c[j-1]][j];
                }
            }
        }

        System.out.println(d[sum][c.length]);
    }


}
