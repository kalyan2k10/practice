package kalyan.hacker;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();                 // Reading input from STDI



        List<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++) {
            a.add(s.nextInt());
        }
        int k = s.nextInt();
        int sum = 0;
        for(int i=k;i>0;i--) {
            sum += i*getMaxDP(a);
            System.out.println(a);
        }
        System.out.println(sum);
    }
    public static int getMaxDP(List<Integer> a){
        int n = a.size();
        int[] d = new int[n+1];
        d[1] = a.get(0);
        d[2] = a.get(0) & a.get(1);

        int x=1, y=2;
        for(int i=3;i<=n;i++){
            d[i] = d[i-1];
            for(int j=1;j<i;j++){

                if((a.get(i-1) & a.get(j-1)) > d[i]) {
                    d[i] = a.get(i - 1) & a.get(j - 1);
                    x=i-1;
                    y=j-1;
                }
            }
        }
        if(n>2) {
            a.remove(x);
            a.remove(y);
        }
        return d[n];
    }

}
