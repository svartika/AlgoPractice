package DynamicProgramming;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        int[]maxEndingIn = new int[nums.length];
        int[] maxBefore = new int[nums.length];
        maxEndingIn[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            maxEndingIn[i] = Math.max(nums[i], nums[i] + maxEndingIn[i-1]);
        }
        int maxSum = nums[0];
        for(int i=0; i<nums.length; i++) {
            maxSum = Math.max(maxSum, maxEndingIn[i]);
            maxBefore[i] = maxSum;
        }
        return maxBefore[nums.length-1];
    }

    public static void main(String args[]) {
        //int[]nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int[]nums = new int[] {-1};
       // int[]nums = new int[] {-11, 20, -3, 5, 8, 9, 6, -3, -5};
       // int[]nums = new int[] {1, 2, -3, 6, -7, 4, 7, -8, 9};
        System.out.println(new MaximumSubArray().maxSubArray(nums));
    }
}
