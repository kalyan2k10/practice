package kalyan.hacker;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args){
        String subString = "ab";
        List<String> permutations = new ArrayList<>();
        generatePermutations("","abc", permutations);
        System.out.println(permutations);
    }
    private static void generatePermutations(String prefix, String remaining,List<String> permutations) {
        if(prefix.startsWith("ab")) return;
        if (remaining.length() == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                String newPrefix = prefix + remaining.charAt(i);
                String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                generatePermutations(newPrefix, newRemaining,permutations);
            }
        }
    }
}
