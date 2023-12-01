package srinadh;

import java.util.Arrays;

public class LIC {
    public static void main(String[] args) {
        int[] a = {0,5,1,2};
        int[] d = new int[a.length];
        Arrays.fill(d, 1);
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    d[i] = d[i] + a[j];
                }
            }
        }
        Arrays.stream(d).forEach(x->System.out.print(x + " "));
        //System.out.println(logn(a));
    }

    public static int logn(int a[]) {
        int[] t = new int[a.length];
        t[0] = a[0];
        int len = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > t[len]) {
                t[++len] = a[i];
            } else {
                int s = 0;
                int e = len;
                while (s <= e) {
                    int mid = (s + e) / 2;
                    if (t[mid] <= a[i]) {
                        s = mid + 1;
                    } else {
                        e = mid - 1;
                    }
                }
                t[s] = a[i];
            }
        }
        return len + 1;
    }

    private static void pushEleIntoA(int[] t, int ele, int len) {
        int s = 0;
        int e = len;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (t[mid] <= ele) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        t[s] = ele;
    }
}
