package kalyan.hacker;

public class FindRepeatingEle {
    public static void main(String[] args){
        int[] a = {3,5,1,2,6,4,3}; //
        int fast = a[0];
        int slow = a[0];
        do {
            slow = a[slow];
            fast = a[a[fast]];
        }while(fast != slow);

        slow = a[0];
        while (slow != fast) {
            slow = a[slow];
            fast = a[fast];
        }
        System.out.println(slow + " " + fast);
    }
}
