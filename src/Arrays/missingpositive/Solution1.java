package Arrays.missingpositive;

public class Solution1 {
    public int findKthPositive(int[] arr, int k) {
        int lastVal = 0;
        int missing = 0;
        for(int index = 0 ; index < arr.length ; index++) {
            int gap = arr[index] - lastVal;
            missing += gap -1;
            if(missing<k) {
                lastVal = arr[index];
                continue;
            } else {
                missing = missing - (gap-1);
                return lastVal+ (k-missing);
            }
        }
        return lastVal + (k - missing);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int value = solution.findKthPositive(new int[]{2, 3, 4, 7, 11}, 8);
        System.out.println("Found "+value);
    }
}
