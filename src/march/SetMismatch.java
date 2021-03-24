package march;

import java.util.Arrays;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        boolean [] numsMap = new boolean[nums.length+1];
        int repeated = 0, missing = 0;
        for(int number : nums ) {
            if (numsMap[number] == true) {
                repeated = number;
               // break;
            } else {
                numsMap[number] = true;
            }
        }
        for(int i=1; i<numsMap.length; i++) {
            boolean isPresent=numsMap[i];
            if(isPresent==false) {
                missing = i;
                break;
            }
        }
        return new int[] {repeated, missing};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2,4};
        int[] res= new SetMismatch().findErrorNums(nums);
        System.out.println(Arrays.toString(res));
    }

}
