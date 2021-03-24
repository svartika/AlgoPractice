package DynamicProgramming;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0], nums[1]);
        nums[2] = nums[0] + nums[2];
        for(int i=3; i<nums.length; i++) {
            /*if(nums[i-3]>nums[i-2]) nums[i] = nums[i] + nums[i-3];
            else nums[i] = nums[i] + nums[i-2];*/
            nums[i] += nums[i-3]>nums[i-2] ? nums[i-3] : nums[i-2];
        }
        return Math.max(nums[nums.length-1], nums[nums.length-2]);
    }

    public static void main(String args[]) {
        //int nums[] = new int[] {2,7,9,3,1,1 };
        int nums[] = new int[] {2,9,7,9,3,1,1 };
        System.out.println(new HouseRobber().rob(nums));
    }
}
