package Design;

import java.util.*;

public class ShuffleAnArray {
    /*class Solution {
        int[] shuffledNums;
        int[] orgNums;
        int[] visited;
        public Solution(int[] nums) {
            this.orgNums = nums;
            this.shuffledNums = new int[nums.length];
            visited = new int[nums.length];
        }

        *//** Resets the array to its original configuration and return it. *//*
        public int[] reset() {
            for(int i = 0; i< orgNums.length; i++) {
                shuffledNums[i] = 0;
            }
            return orgNums;
        }

        *//** Returns a random shuffling of the array. *//*
        public int[] shuffle() {
            Random random = new Random();
            for(int i=0; i<orgNums.length; i++) {
                int j = random.nextInt(orgNums.length);
                while(visited[j]==1) {
                    j = random.nextInt(orgNums.length);
                }
                visited[j] = 1;
                shuffledNums[i] = orgNums[j];
            }
            for(int i=0; i<orgNums.length; i++) {
                visited[i] = 0;
            }
            return shuffledNums;
        }

    }*/
    class Solution {
        int[] orgNums;
        public Solution(int[] nums) {
            this.orgNums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return orgNums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            List<Integer> list = new ArrayList<Integer>();
            int[] shuffledNums = new int[orgNums.length];
            for(int i=0; i<orgNums.length; i++) {
                list.add(orgNums[i]);
            }
            Random random = new Random();
            for(int i=0; i<orgNums.length; i++) {
                int j = random.nextInt(list.size());
                shuffledNums[i] = list.get(j);
                list.remove(j);
            }
            return shuffledNums;
        }

    }

    public static void main(String args[]) {
       /* int[] nums = new int[] {1,2,3};
        Solution s = new ShuffleAnArray().new Solution(nums);
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.reset()));
        System.out.println(Arrays.toString(s.shuffle()));*/


         int[] nums = new int[] {0,-12893,128384};
        Solution s = new ShuffleAnArray().new Solution(nums);
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));
    }
}
