package January.ksumpair;

import java.util.Hashtable;

public class MaxNumOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        int numOfOperations = 0;
        Hashtable<Integer, Integer> elementCount = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if(current>=k) continue;
            if(elementCount.containsKey(current)) {
                int currentCount = elementCount.get(current);
                elementCount.put(current, ++currentCount);
            } else {
                elementCount.put(current, 1);
            }

            if(k%2==0 && current==k/2) {
                if (elementCount.containsKey(current)) {
                    int currentCount = elementCount.get(current);
                    if(currentCount>=2) {
                        int newVal = currentCount-2;
                        if(newVal==0) elementCount.remove(current);
                        else elementCount.put(current, newVal);
                        numOfOperations++;
                    }
                }
            } else {
                int counterPart = k - current;
                if (elementCount.containsKey(current) && elementCount.containsKey(counterPart)) {
                    int counterPartCount = elementCount.get(counterPart);
                    if (counterPartCount == 1 || counterPartCount == 0) elementCount.remove(counterPart);
                    else elementCount.put(counterPart, --counterPartCount);

                    int currentCount = elementCount.get(current);
                    if (currentCount == 1 || currentCount == 0) elementCount.remove(current);
                    else elementCount.put(current, --currentCount);

                    numOfOperations++;
                }
            }
        }
        return numOfOperations;
    }

    public static void main(String args[]) {
        int [] nums = new int[] {1,2,3,4};
        int k = 5;
        System.out.println(new MaxNumOfKSumPairs().maxOperations(nums, k));

        int [] nums1 = new int[] {3,1,3,4,3};
        int k1 = 6;
        System.out.println(new MaxNumOfKSumPairs().maxOperations(nums1, k1));

        int [] nums3 = new int[] {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k3 = 3;
        System.out.println(new MaxNumOfKSumPairs().maxOperations(nums3, k3));

    }
}
