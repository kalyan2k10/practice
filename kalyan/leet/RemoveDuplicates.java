package kalyan.leet;

public class RemoveDuplicates {
    public static void main(String[] args){
        int a[] = {2,2,2,2};
        //{0,0,1u,1,1i,1,2,2,2,2,3,3,3}
        removeVal(a,2);
        for(int i=0;i<a.length;i++)
            System.out.print(" " + a[i]);
    }

    public static void removeVal(int[] nums, int val){
        int i=0;
        int len = nums.length-1;
        while(i<len){
            if(nums[i] == val){
                nums[i] = nums[len];
                len--;
            } else {
                i++;
            }
        }
    }
    public static int removeDuplicates(int[] nums) {
        int unique= 0;
        int count=1;

        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[unique]) {
                unique++;
                nums[unique] = nums[i];
                count=1;

            } else {
                if(count<2){
                    count++;
                    unique++;
                    nums[unique] = nums[i];
                }
            }
        }
        for(int i=0;i<nums.length;i++) {
            System.out.print(" " + nums[i]);
        }
        return unique+1;
    }
}
