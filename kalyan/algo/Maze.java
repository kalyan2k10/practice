package kalyan.algo;

public class Maze {
    public static void main(String[] args) {
        int[][] m = {{1,0,1}, {1,1,0}, {0,1,1}};
        System.out.println(canGo(1,1,m,m.length-1));

    }

    private static boolean canGo(int i, int j, int[][] m,int len) {
        if(i>len || j >len) return false;
        if(m[i][j] == 1 && i==len && j==len) return true;
        else {
            if(i<=len && j<len && m[i][j+1] == 1) return canGo(i, j+1, m, len);
            if(i<len && j<=len && m[i+1][j] == 1) return canGo(i+1, j, m, len);
        }
        return false;
    }
}
