package February;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class LongestHarmoniousSubsequence {
    private void quickSort(int[] nums, int p, int r) {
        if (p < r) {
            int q = partition(nums, p, r);
            quickSort(nums, p, q - 1);
            quickSort(nums, q + 1, r);
        }
    }

    private int partition(int[] nums, int p, int r) {
        int i=p-1;
        int x=nums[r];
        for(int j=p; j<r; j++) {
            if(nums[j]<x) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        i++;
        int temp = nums[r];
        nums[r] = nums[i];
        nums[i] = temp;
        return i;
    }

    /*public int findLHS(int[] nums) {
        if(nums==null || nums.length<=1) return 0;

        quickSort(nums, 0, nums.length-1);
        int max = 0, startIndex  = 0, nextIndexStart = 0, prevMax = max;
        for(int i=1; i<nums.length; i++) {
            if(max==0) nextIndexStart = i;
            if(nums[i]-nums[startIndex]<=1) {
                max++;
            } else {
                startIndex = nextIndexStart;
                prevMax = Math.max(prevMax, max);
                max = 0;
            }
        }
       return prevMax;
    }*/
    public int findLHS(int[] nums) {
        if(nums==null || nums.length<=1) return 0;
        Hashtable<Integer, Integer> numCounts = new Hashtable<>();
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(numCounts.containsKey(num)) {
                numCounts.put(num, numCounts.get(num)+1);
            } else {
                numCounts.put(num, 1);
            }
        }
        int[] unique = new int[numCounts.size()];
        int j=0;
        for(Integer num : numCounts.keySet()) {
            unique[j++] = num;
        }
        quickSort(unique, 0, unique.length-1);
        int max = 0;
        for(int i=1; i<unique.length; i++) {
            if(unique[i]-unique[i-1]==1) {
                int m = numCounts.get(unique[i]) + numCounts.get(unique[i-1]);
                max = Math.max(m, max);
            }
        }
        return max;
    }

    public static void main(String args[]) {
        int[] nums = new int[] {1, 3, 2, 2, 5, 3, 2, 7};
        System.out.println(new LongestHarmoniousSubsequence().findLHS(nums));
    }
}
