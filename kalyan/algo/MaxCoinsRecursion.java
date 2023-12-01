package kalyan.algo;

public class MaxCoinsRecursion {
    public static void main(String s[]){
        int c[] = new int[] {2,3};
        int val = 5;

        System.out.println(getMax(c, val));
    }
    public static int getMax(int[] c, int val) {
       if(val == 0) return 0;
       int res = Integer.MIN_VALUE;
       for(int i=0;i<c.length;i++){
           if(c[i]<=val){
               int subRes = getMax(c, val-c[i]);
               if(subRes != Integer.MIN_VALUE){
                   res = Math.max(res,subRes+1);
               }
           }
       }
       return res;
    }


}
