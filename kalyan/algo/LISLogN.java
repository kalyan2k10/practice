package kalyan.algo;

public class LISLogN {
    public static void main(String s[]){
        int c[] = new int[] {3,4,2,8,10};
        int n = c.length;
        int tail[] = new int[n];
        tail[0] = c[0];
        int len = 1;
        for(int i=1;i<n;i++){
            if(c[i]>tail[len-1]){
                tail[len] = c[i];
                len++;
            } else {
                int ciel = getCiel(tail, 0, len, c[i]);
                tail[ciel] = c[i];
            }
        }
        System.out.println(len);
    }
    public static int getCiel(int[] tail, int l, int r, int x) {
        while(l<r){
            int m = l + (r-l)/2;
            if(tail[m] > x)
                r = m;
            else
                l = m+1;
        }
        return r;
    }
}
