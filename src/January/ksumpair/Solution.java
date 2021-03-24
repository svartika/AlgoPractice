package January.ksumpair;

import java.util.Hashtable;

public class Solution {
    public int maxOperations(int[] nums, int k) {
        Hashtable<Integer, Integer> occurance = new Hashtable<>();
        int totalCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (occurance.containsKey(k - current)) {
                //entry for other part exists
                int counterPartsCount = occurance.get(k - current);

                //decrease down till 0
                occurance.replace(k - current, --counterPartsCount);

                //if 0 then just remove counterpart Entry
                if (counterPartsCount == 0) {
                    occurance.remove(k - current);
                }

                totalCount++;

            } else {
                if (occurance.containsKey(current)) {
                    occurance.replace(current, occurance.get(current) + 1);
                } else {
                    occurance.put(current, 1);
                }
            }
        }
        return totalCount;
    }

    public static void main(String args[]) {
        int[] nums = new int[]{1, 2, 3, 4};
        int k = 5;
        System.out.println(new Solution().maxOperations(nums, k));

        int[] nums1 = new int[]{3, 1, 3, 4, 3};
        int k1 = 6;
        System.out.println(new Solution().maxOperations(nums1, k1));

        int[] nums3 = new int[]{2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2};
        int k3 = 3;
        System.out.println(new Solution().maxOperations(nums3, k3));

    }
}
