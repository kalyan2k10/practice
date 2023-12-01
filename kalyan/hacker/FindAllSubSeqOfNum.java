package kalyan.hacker;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubSeqOfNum {
    public static void main(String[] args){
        String number = "123";
        List<String> al = new ArrayList<>();
        getSeq(number, number.length(), al);
        System.out.println(al);
    }

    private static void getSeq(String str, int len, List<String> al) {
        if(len<0) return;
        if(len == 1) {
            al.add("");
            al.add(String.valueOf(str.charAt(0)));
        }
        else {
            List<String> subList = new ArrayList<>();
            getSeq(str, len-1, subList);
            for(String s : subList) {
                al.add(s + "");
                al.add(s + str.charAt(len-1));
            }
        }
    }
}
