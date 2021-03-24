package January;

public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        int indexMin = 0, indexMax = 0;

        boolean increased = false;
        do {
            indexMin = findIndexOfMin(nums, 0);
            indexMax = findIndexOfMax(nums, 0);
            increased = false;
            if (canIncreaseNumberAtIndex(indexMin, nums)) {
                if(nums[indexMin]*2>nums[indexMax]) {
                    if((nums[indexMin]*2-nums[indexMax])< (nums[indexMax]-nums[indexMin])) {
                        increaseNumberAtIndex(indexMin, nums);
                        increased = true;
                    }
                } else {
                    increaseNumberAtIndex(indexMin, nums);
                    increased = true;
                }


            }
        } while (increased);
        boolean decreased = false;
        do {
            indexMin = findIndexOfMin(nums, 0);
            indexMax = findIndexOfMax(nums, 0);
            decreased = false;
            if (canDecreaseNumberAtIndex(indexMax, nums)) {
                if(nums[indexMin]>nums[indexMax]/2) {
                    if((nums[indexMin]-nums[indexMax]/2)< (nums[indexMax]-nums[indexMin])) {
                        decreaseNumberAtIndex(indexMax, nums);
                        decreased = true;
                    }
                } else {
                    decreaseNumberAtIndex(indexMax, nums);
                    decreased = true;
                }
            }
        } while (decreased);


        int deviation = nums[indexMax] - nums[indexMin];
        return deviation;
    }

    int findIndexOfMin(int nums[], int fromIndex) {
        if (fromIndex >= nums.length) return -1;
        int min = nums[fromIndex];
        int minIndex = fromIndex;
        for (int i = fromIndex; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    boolean canIncreaseNumberAtIndex(int index, int[] nums) {
        if (nums[index] % 2 != 0) return true;
        else return false;
    }

    void increaseNumberAtIndex(int index, int[] nums) {
        nums[index] *= 2;
    }

    int findIndexOfMax(int[] nums, int fromIndex) {
        if (fromIndex >= nums.length) return -1;
        int max = nums[fromIndex];
        int maxIndex = fromIndex;
        for (int i = fromIndex; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    boolean canDecreaseNumberAtIndex(int index, int[] nums) {
        if (nums[index] % 2 == 0) return true;
        else return false;
    }

    void decreaseNumberAtIndex(int index, int[] nums) {
        nums[index] /= 2;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,5,20,3};
        System.out.println(new MinimizeDeviationInArray().minimumDeviation(nums));


       /* Input: [399,908,648,357,693,502,331,649,596,698]
        Output: 344
        Expected: 315*/

    }
}
