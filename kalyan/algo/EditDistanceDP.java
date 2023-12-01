package kalyan.algo;

public class EditDistanceDP {
    public static void main(String[] a){
        String s1 = "CATX";
        String s2 = "CUT";
        int m = s1.length();
        int n = s2.length();
        int d[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++) d[i][0] = i;
        for(int j=0;j<=n;j++) d[0][j] = j;
        for(int i=1;i<=m;i++) {
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    d[i][j] = d[i-1][j-1];
                }else {
                    d[i][j] = 1+Math.min(Math.min(d[i][j-1],d[i-1][j]),d[i-1][j-1]);
                }
            }

        }
        System.out.println(d[m][n]);
    }


}
