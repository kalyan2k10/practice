package kalyan.algo;

public class RotatedBinary {
    public static void main(String[] args){
        int ele = 4;
        int[] a = new int[]{8,9,10,11,12,1}; // 2,1, 3, 8,4
        System.out.println(getPiv(a,0,a.length-1));
    }

    private static int getIndexInSortedArray(int[] a, int ele) {
        int count = 0;
        for(int i=0;i<a.length;i++){
            if(a[i] < ele) {
                count++;
            }
        }
        return count;
    }

    private static int binSearch(int[] arr, int s, int e, int x) {
        if(s>e) return -1;
        while(s<e) {
            int mid = (s+e)/2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x) {
                e = mid;
            } else {
                s = mid;
            }
        }
        return -1;
    }

    //{8,9,10,11,12,1};
    private static int getPiv(int[] a, int s, int e) {
        int piv =-1;
        if(a[s]<a[e]) return piv;
        int prevMid = 0;
        while(s<e) {
            int mid = (s + e) / 2;
            if(mid == prevMid) mid++;
            prevMid = mid;
            if (a[mid - 1] > a[mid]) {
                piv = mid;
                break;
            }
            if (a[mid] < a[e]) {
                e = mid;
            } else if (a[s] < a[mid]){
                s = mid;
            }
        }
        return piv;
    }
}




