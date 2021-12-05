package Permutations;

import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permuting(nums, 0, nums.length);
    }

    List<List<Integer>> permuting(int[] nums, int startIndex, int endIndex) {
        System.out.println("StartIndex"+ startIndex + "endIndex"+endIndex);
//        System.out.print("Going to permute over[");
//        for(int i = startIndex; i < endIndex; i++) {
//
//            System.out.print(nums[i]);
//        }
//        System.out.println("]");
        if(startIndex >= endIndex) {
            ArrayList<Integer> list = new ArrayList<>();
            if(startIndex < nums.length)
            list.add(nums[startIndex]);


            return Arrays.asList( list);
        }
        ArrayList<List<Integer>> results = new ArrayList<>();
        for(int index = startIndex  ; index < endIndex; index++) {
            List<List<Integer>> permutationsBegining = permuting(nums, startIndex, index);
            List<List<Integer>> permutationsEnding = permuting(nums, index+1, endIndex);

            for(List<Integer> startCombo: permutationsBegining) {
                for(List<Integer> endCombo: permutationsEnding) {
                    results.add(combineLists(startCombo, new ArrayList<>(nums[index]), endCombo));
                    results.add(combineLists(endCombo, new ArrayList<>(nums[index]), startCombo));


                }
            }
        }
        return results;
    }

    List<Integer> combineLists(List<Integer> first,List<Integer> second, List<Integer> third) {
        ArrayList<Integer> combined = new ArrayList();
        combined.addAll(first);
        combined.addAll(second);
        combined.addAll(third);
//        System.out.print("Permutaion result [");
//        for(int i :combined) {
//
//            System.out.print(i);
//        }
//        System.out.println("]");
        return combined;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> result = sol.permute(new int[]{ 10, 1, 4, 5});
        for(List<Integer> resultRow: result) {
            for(int resultItem: resultRow) {
                System.out.print(resultItem+" ");
            }
            System.out.println("");
        }
    }
}
