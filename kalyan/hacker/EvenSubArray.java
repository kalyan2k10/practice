package kalyan.hacker;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenSubArray {

    public static void findEvenSubArray(Integer[] arr, int y) {
        int n = arr.length;
        int start = 0, end = 0;
        int maxStart = 0, maxEnd = 0;

        for (int i = 0; i < n; i++) {
            if (matchCriteria(y, arr[i])) {
                end = i;
            } else {
                start = i + 1;
            }

            if (end - start > maxEnd - maxStart) {
                maxStart = start;
                maxEnd = end;
            }
        }

        System.out.println(maxStart + "--" + maxEnd);
        for (int i = maxStart; i <= maxEnd; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static boolean matchCriteria(int y, int n) {
        int result = 1;
        while ((result << 1) < y) {
            result = result << 1;
        }
        return ((n < result) || n > (result << 1)) ;
    }

    public static void main(String[] args) {
        Integer[] arr = {2,2,7,5 ,2 ,2, 2, 5};
        findEvenSubArray(arr, 5);
    }
}