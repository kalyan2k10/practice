package kalyan.algo;

public class ActivitySelection {
    public static void main(String[] args){
        int[] ar1 = {2,3,5,8,7};
        int[] ar2 = {4,7,9,9,11};

        System.out.println(getLength(ar1,ar2));
    }

    private static int getLength(int[] ar1, int[] ar2) {
        int n = ar1.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++) dp[i] = 1;
        for(int i=1;i<ar1.length;i++) {
            for(int j=0;j<i;j++){
                if(ar2[j] < ar1[i]) {
                    dp[i] = dp[j]+1;
                }
            }
        }
        for(int i=0;i<dp.length;i++)
            System.out.println(" " + dp[i]);
        return 0;
    }
}
