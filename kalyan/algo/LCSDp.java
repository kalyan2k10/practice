package kalyan.algo;

public class LCSDp {
    public static void main(String[] a) {


        String s1 = "abc";
        String s2 = "abd";
        int mm[][] = new int[s1.length()][s2.length()];
        for(int m=1;m<s1.length();m++){
            for(int n=1;n<s2.length();n++){
                if(s1.charAt(m-1) == s2.charAt(n-1)){
                    mm[m][n] = 1+mm[m-1][n-1];
                } else {
                    mm[m][n] = Math.max(mm[m][n-1],mm[m-1][n]);
                }
            }
        }
        System.out.println("ans " + mm[s1.length()-1][s2.length()-1]);
    }



}
