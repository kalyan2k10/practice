package kalyan.algo;

public class MinimumCoinsRecursion {
    public static void main(String s[]){
        int c[] = new int[] {2,4,6};
        int val = 8;

        System.out.println(getMin(c, val));
    }
    public static int getMin(int[] c, int val) {
       if(val == 0) return 0;
       int res = Integer.MAX_VALUE;
       for(int i=0;i<c.length;i++){
           if(c[i]<=val){
               int subRes = getMin(c, val-c[i]);
               if(subRes != Integer.MAX_VALUE){
                   res = Math.min(res,subRes+1);
               }
           }
       }
        return res;



    }


}
