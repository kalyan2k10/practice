package kalyan.algo;

public class MinimumCoins {
    public static void main(String s[]){
        int c[] = new int[] {1,3,4};
        int val = 5;
        int d[] = new int[val+1];

        for(int i=0;i<=val;i++){
            d[i] = Integer.MAX_VALUE;
        }
        d[0] = 0;
        for(int i=0;i<=val;i++){
            for(int k=0;k<c.length;k++){
                if(c[k] <= i){
                    int subRes = d[i-c[k]];
                    if(subRes != Integer.MAX_VALUE){
                        d[i] = Math.min(d[i], subRes+1);
                    }
                }
            }
        }
        for(int i=0;i<=val;i++){
            System.out.println(d[i]);
        }

    }



}
