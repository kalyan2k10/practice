package kalyan.leet;

public class MaxSubSum {
    public static void main(String[] args){
        int a[] = {-3,-2,-3};
        System.out.println(circularSum(a));
    }
    public static int circularSum(int[] nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
        }
        return Math.max(sum - minSubArray(nums), maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int maxCurr = nums[0];
        int maxGlobal = nums[0];

        for(int i=1;i<nums.length;i++){
            maxCurr += nums[i];
            maxCurr = Math.max(nums[i], maxCurr);
            maxGlobal = Math.max(maxGlobal, maxCurr);
        }
        return maxGlobal;
    }

    public static int minSubArray(int[] nums) {
        int minCurr = nums[0];
        int minGlobal = nums[0];

        for(int i=1;i<nums.length;i++){
            minCurr += nums[i];
            minCurr = Math.min(nums[i], minCurr);
            minGlobal = Math.min(minGlobal, minCurr);
        }
        return minGlobal;
    }
}

