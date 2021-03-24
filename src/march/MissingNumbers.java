package march;

public class MissingNumbers {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        int expectedSum = (nums.length * (nums.length+1) ) /2;
        return expectedSum - sum;
    }
    public static  void main(String args[]) {
        System.out.println(new MissingNumbers().missingNumber(new int[] {3,0,1}));
    }
}
