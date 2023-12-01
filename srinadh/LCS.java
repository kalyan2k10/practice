package srinadh;

public class LCS {
    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "bca";
        int x = getLCS(s1,s2,s1.length()-1,s2.length()-1);
        System.out.println("lcs is " + x);
    }

    private static int getLCS(String s1, String s2, int m, int n) {
        if(m<0 || n<0) return 0;
        if(s1.charAt(m) == (s2.charAt(n))){
            return 1+ getLCS(s1,s2,m-1,n-1);
        } else {
            return Math.max(getLCS(s1,s2,m,n-1), getLCS(s1,s2,m,n-1));
        }
    }
}
