package geek.search;

public class search {
    public static void main(String[] args){
        int[] a1= {10,11,12,30};
        int[] a2= {5,9,25};
        //5,9,10,11,12,25,30
        System.out.println(getMed(a1, a2));
    }

    private static double getMed(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return getMed(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                // We have found the correct partition
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                } else {
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                // Move partitionX to the left
                high = partitionX - 1;
            } else {
                // Move partitionX to the right
                low = partitionX + 1;
            }
        }

        return -1;
    }
    private static int findEleInfinite(int[] a, int ele, int s) {
        if(ele == a[0]) return 0;
        int e = 1;
        while(ele > a[e]) {
            e = e*2;
        }
        int mid =0;
        while(s<=e){
            mid = (s+e)/2;
            if(ele == a[mid]) return mid;
            if(ele < a[mid]) {
                e = mid - 1;
            } else if(ele > a[mid]){
                s = mid + 1;
            }
        }
        return -1;
    }

    private static int countOccurencesOfEle(int[] a, int ele, int s, int e) {
        int firstOcc = findIndexOfFirstOccurence(a,ele,s,e);
        int lastOcc = findIndexOfLastOccurence(a,ele,s,e);
        return lastOcc - firstOcc + 1;
    }
    private static int findIndexOfLastOccurence(int[] a, int ele, int s, int e) {
        int mid;
        while(s<=e){
            mid = (s+e)/2;
            if(ele == a[mid]) {
                if(a[mid+1] == ele)
                    s = mid + 1;
                else
                    return mid;
            }
            else if(ele < a[mid]) {
                e = mid - 1;
            } else if(ele > a[mid]){
                s = mid + 1;
            }
        }
        return -1;
    }
    private static int findIndexOfFirstOccurence(int[] a, int ele, int s, int e) {
        int mid;
        while(s<=e){
            mid = (s+e)/2;
            if(ele == a[mid]) {
                if(a[mid-1] == ele)
                    e = mid -1;
                else
                    return mid;
            }
            else if(ele < a[mid]) {
                e = mid - 1;
            } else if(ele > a[mid]){
                s = mid + 1;
            }
        }
        return -1;
    }
    private static int findEleInRotated(int[] a, int ele, int s, int e) {
        int mid = 0;
        while(s<=e){
            mid = (s+e)/2;
            if(ele == a[mid]) return mid;
            if(a[s] < a[mid]) {
                if(ele < a[mid] && ele >= a[s]) {
                    e = mid-1;
                } else {
                    s = mid+1;
                }
            }  else {
                if(ele > a[mid] && ele <= a[e]) {
                    s = mid+1;
                } else {
                    e = mid-1;
                }
            }
        }
        return -1;
    }

    private static int findEle(int[] a, int ele, int s, int e) {
        int mid = 0;
        while(s<=e){
            mid = (s+e)/2;
            if(ele == a[mid]) return mid;
            if(ele < a[mid]) {
                e = mid - 1;
            } else if(ele > a[mid]){
                s = mid + 1;
            }
        }
        return -1;
    }
}
