package kalyan.algo;

public class MinJumpsDP {
    public static void main(String s[]) {
        int a[] = new int[]{3,4,2,1,2,1};
        int d[] = new int[a.length];

        for(int i=0;i<d.length;i++){
            d[i] = Integer.MAX_VALUE;
        }
        d[0]=0;
        for(int i=0;i<d.length;i++){
            for(int j=0;j<i;j++){
                if(j+a[j]>=i){
                    int sr = d[j];
                    if(sr != Integer.MAX_VALUE){
                        d[i] = Math.min(d[i],sr+1);
                    }
                }
            }
        }
        for(int i=0;i<d.length;i++){
            System.out.println(d[i]);
        }

    }


}
