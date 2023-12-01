package kalyan.algo;

public class EditDistanceRecursion {
    public static void main(String[] a){
        String s1 = "CATM";
        String s2 = "CUTN";
        System.out.println(ed(s1,s2,s1.length(),s2.length()));
    }

    private static int ed(String s1, String s2, int m, int n) {
        if(m==0) return n;
        if(n==0) return m;
        if(s1.charAt(m-1) == s2.charAt(n-1)) return ed(s1,s2,m-1,n-1);
        else
            return 1+Math.min(Math.min(ed(s1,s2,m,n-1), ed(s1,s2,m-1,n)), ed(s1,s2,m-1,n-1));
    }
}
