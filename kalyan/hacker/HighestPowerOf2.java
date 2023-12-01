package kalyan.hacker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HighestPowerOf2 {
    public static void main(String[] args) {
        int y = 5;
        int[] s = new int[] {7,10,9,7,12,12,12,12,7,7,7,11,11,11,7,7};
        List<Integer> res = find(s, y, s.length);
        System.out.println(res);
        int min=-1,max=-1,diff=0;
        for(int i=0;i<res.size()-1;i++){
            if(res.get(i) == -1 && i>0 && res.get(i-1) !=-1) {
                diff = max-min;
                System.out.println("diff "+diff);
            }
            if(res.get(i+1) > res.get(i)) {
                if(res.get(i)==-1) min=i+1;
                max=i+1;
            }
        }
        System.out.println("diff "+(max-min));
    }

    private static List<Integer> find(int[] s, int y, int len) {
        List<Integer> res = new ArrayList<>();
        if(len==1) {
            if(matchCriteria(s[0], y))
                res.add(0);
            else res.add(-1);
        } else if(len>=2){
            res = find(s,y,len-1);
            if(matchCriteria(y,s[len-1])) {
                res.add(len-1);
            } else {
                res.add(-1);
            }
        }
        return res;
    }

    private static boolean matchCriteria(int y, int n) {

        int result = 1;
        while ((result << 1) < y) {
            result = result << 1;
        }
        return ((n < result) || n > (result << 1)) ;
    }
}
