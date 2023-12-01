package kalyan.hacker;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(generateSubsequences(s,s.length()));
    }

    private static List<String> generateSubsequences(String s, int n) {
        List<String> res = new ArrayList<>();
       if(n==0) {
           res.add("");
           return res;
       } else {
           List<String> subRes = generateSubsequences(s,n-1);
           for(String x : subRes) {
               res.add(x + "");
               res.add(x + s.charAt(n-1));
           }
           return res;
       }
    }
}
