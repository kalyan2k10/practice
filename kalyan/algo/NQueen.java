package kalyan.algo;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        int[][] m = new int[n][n];
        m[0][1]=1;
        System.out.println(isPossible(0,0, m));
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int i, int j, int[][] m){
        int cnt=0;
        for(int l=0;l<m.length;l++) {
            if (m[i][l] == 1) cnt++;
            if (cnt == 2) return false;
        }
        cnt=0;
        for(int l=0;l<m.length;l++) {
            if (m[l][j] == 1) cnt++;
            if (cnt == 2) return false;
        }
        cnt = 0;
        for(int l=0;l+i<m.length || l+j<m.length;l++){
            if(l+i==m.length || l+j==m.length) break;
            if(m[l+i][l+j] == 1) cnt++;
            if (cnt == 2) return false;
        }
        for(int l=0;i-l>=0 || j>=0;l++){
            if(i-l==-1 || j-l==-1) break;
            if(m[l+i][l+j] == 1) cnt++;
            if (cnt == 2) return false;
        }
        cnt = 0;
        for(int l=0;l<m.length;l++) {
            if(m[m.length-1-l][l] == 1) cnt++;
            if (cnt == 2) return false;
        }
        return true;
    }

    private static boolean isPossible(int i, int j, int[][] m) {
        if(i==m.length || j== m.length) return true;
        for(int k=i;k<m.length;k++){
            for(int l=0;l<m.length;l++) {
                if(k!=i && l!=j) {
                    m[k][l] = 1;
                    if (isSafe(k,l,m)) {
                        return isPossible(k, l, m);
                    } else {
                        m[k][l] = 0;
                    }
                }
            }
        }
        return false;
    }
}
