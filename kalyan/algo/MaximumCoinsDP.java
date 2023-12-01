package kalyan.algo;

public class MaximumCoinsDP {
    public static void main(String s[]){
        int c[] = new int[] {2,3};
        int val = 5;
        int d[] = new int[val+1];

        for(int i=0;i<=val;i++){
            d[i] = Integer.MIN_VALUE;
        }
        d[0] = 0;
        for(int i=0;i<=val;i++){
            for(int k=0;k<c.length;k++){
                if(c[k] <= i){
                    int subRes = d[i-c[k]];
                    if(subRes != Integer.MIN_VALUE){
                        d[i] = Math.max(d[i], subRes+1);
                    }
                }
            }
        }
        for(int i=0;i<=val;i++){
            System.out.println(d[i]);
        }

    }



}
