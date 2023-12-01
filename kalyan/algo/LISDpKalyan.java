package kalyan.algo;

public class LISDpKalyan {
    public static void main(String s[]){
        int c[] = new int[] {3,4,2,8,10,5,11};
        int d[]= new int[c.length];
        for(int i=0;i<c.length;i++) d[i] =1;
        for(int i=0;i<c.length;i++){
            int ci=getFloor(c,i);
            if(ci != -1) {
                d[i] = d[ci] + 1;
            }
        }
        int res = d[0];
        for(int i=0;i<c.length;i++){
            res = Math.max(d[i],res);
        }
        System.out.println(res);
    }
    public static int getFloor(int[] c, int n) {
        int res = -1;
        int ci = -1;
        for(int i=0;i<n;i++){
            if(c[i] < c[n]){
                if(c[i] > res) {
                    res = c[i];
                    ci = i;
                }
            }
        }
        return ci;
    }
}
